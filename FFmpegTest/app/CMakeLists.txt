# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

#set(distribution_DIR ${CMAKE_SOURCE_DIR}/libs)            # 文件夹为libs的情况下
set(distribution_DIR ${CMAKE_SOURCE_DIR}/src/main/jniLibs) # 文件夹为jniLibs的情况下
message("distribution_DIR:" ${distribution_DIR})

add_library( libavcodec-56 #libavcodec
        SHARED
        IMPORTED )

add_library( libavdevice-56
        SHARED
        IMPORTED )

add_library( libavfilter-5
        SHARED
        IMPORTED )

add_library( libavformat-56
        SHARED
        IMPORTED )

add_library( libavutil-54
        SHARED
        IMPORTED )

add_library( libpostproc-53
        SHARED
        IMPORTED )

add_library( libswresample-1
        SHARED
        IMPORTED )

add_library( libswscale-3
        SHARED
        IMPORTED )

set_target_properties( libavcodec-56
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libavcodec-56.so)

set_target_properties( libavdevice-56
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libavdevice-56.so)

set_target_properties( libavfilter-5
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libavfilter-5.so)

set_target_properties( libavformat-56
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libavformat-56.so)

set_target_properties( libavutil-54
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libavutil-54.so)

set_target_properties( libpostproc-53
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libpostproc-53.so)

set_target_properties( libswresample-1
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libswresample-1.so)

set_target_properties( libswscale-3
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libswscale-3.so)

#set_target_properties( ffmpeg
#        PROPERTIES IMPORTED_LOCATION
#        ${distribution_DIR}/${ANDROID_ABI}/libavcodec-56.so)
#${distribution_DIR}/${ANDROID_ABI}/libavdevice-56.so
#${distribution_DIR}/${ANDROID_ABI}/libavfilter-5.so
#${distribution_DIR}/${ANDROID_ABI}/libavformat-56.so
#${distribution_DIR}/${ANDROID_ABI}/libavutil-54.so
#${distribution_DIR}/${ANDROID_ABI}/libpostproc-53.so
#${distribution_DIR}/${ANDROID_ABI}/libswresample-1.so
#${distribution_DIR}/${ANDROID_ABI}/libswscale-3.so

add_library( # Sets the name of the library.
        native-lib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${CMAKE_SOURCE_DIR}/src/main/cpp/native-lib.c)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

include_directories(src/main/cpp/include)

target_link_libraries( # Specifies the target library.
        native-lib
        libavcodec-56
        libavdevice-56
        libavfilter-5
        libavformat-56
        libavutil-54
        libpostproc-53
        libswresample-1
        libswscale-3
        android #如果我们在编写代码时使用了ANativeWindow相关的方法的话，需要在链接库文件的时候加入android这个库文件，不然会报undefined reference to的错

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib} )
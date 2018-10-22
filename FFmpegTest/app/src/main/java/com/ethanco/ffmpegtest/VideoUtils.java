package com.ethanco.ffmpegtest;

/**
 * @author EthanCo
 * @since 2018/10/20
 */
public class VideoUtils {

    static {
        //顺序不能乱
        System.loadLibrary("avutil-54");
        System.loadLibrary("swresample-1");
        System.loadLibrary("avcodec-56");
        System.loadLibrary("avformat-56");
        System.loadLibrary("swscale-3");
        System.loadLibrary("postproc-53");
        System.loadLibrary("avfilter-5");
        System.loadLibrary("avdevice-56");

//        System.loadLibrary("libavutil-54");
//        System.loadLibrary("libswresample-1");
//        System.loadLibrary("libavcodec-56");
//        System.loadLibrary("libavformat-56");
//        System.loadLibrary("libswscale-3");
//        System.loadLibrary("libpostproc-53");
//        System.loadLibrary("libavfilter-5");
//        System.loadLibrary("libavdevice-56");

//        System.loadLibrary("avutil");
//        System.loadLibrary("swresample");
//        System.loadLibrary("avcodec");
//        System.loadLibrary("avformat");
//        System.loadLibrary("swscale");
//        System.loadLibrary("postproc");
//        System.loadLibrary("avfilter");
//        System.loadLibrary("avdevice");
        System.loadLibrary("native-lib");
    }

    public native static String ffmpegInfo();

    public native static void decode(String input,String output);
}

#include <stdio.h>
#include <stdlib.h>

extern "C"{
#include "libavcodec\avcodec.h"
};

void main(){
	printf("%s\n", avcodec_configuration());
	system("pause");
}
#include <jni.h>
#include "com_mmotiy_service_Mouse.h"
#include <stdio.h>
#include <windows.h>
JNIEXPORT void JNICALL Java_com_mmotiy_service_Mouse_sendInput(JNIEnv *env, jobject obj, jobject param){
    printf("revice an info\n");
    //测试访问java 实例的字段
    INPUT ip;
    MOUSEINPUT mip;
    mip.dwFlags = MOUSEEVENTF_MOVE;
    mip.dx = 10;
    mip.dy = 10;
    mip.time = 0;
    ip.type = INPUT_MOUSE;
    ip.mi = mip;
    SendInput(1,&ip,sizeof(INPUT));
    return ;
  }



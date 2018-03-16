#include <jni.h>
#include "one_one_Test.h"
#include <stdio.h>
#include <windows.h>
 JNIEXPORT void JNICALL Java_one_one_Test_sayHello(JNIEnv * env, jobject obj, jstring name){
 	const char *str; 
        str = (*env)->GetStringUTFChars(env, name, NULL); 
        if (str == NULL) { 
            return; 
        } 
        
        printf("Hello World! %s \n", str );

    printf("revice an info\n");
    INPUT ip;
    MOUSEINPUT mip;
    mip.dwFlags = MOUSEEVENTF_MOVE;
    mip.dx = 10;
    mip.dy = 10;
    mip.time = 0;
    ip.type = INPUT_MOUSE;
    ip.mi = mip;
    SendInput(1,&ip,sizeof(INPUT));
 	return;
  }
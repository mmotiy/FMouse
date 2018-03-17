#include <jni.h>
#include "com_mmotiy_service_Mouse.h"
#include <stdio.h>
#include <windows.h>
#define MY_TYPE_NAME  "type"
#define MY_MOUSE_DATE "tagMOUSEINPUT"

jint getIntFromObj(JNIEnv *env ,jobject obj,const char* name,const char* sig){
    jclass objClass = env -> GetObjectClass(obj);
    jfieldID objFieldID = env -> GetFieldID(objClass,name,sig);
    if(objFieldID == NULL){
        return -1;
    }
    return env -> GetIntField(obj,objFieldID);
  }

jobject getObjFormObj(JNIEnv *env ,jobject obj,const char* name,const char*  sig){
    jclass objClass = env -> GetObjectClass(obj);
    jfieldID objFieldID = env -> GetFieldID(objClass,name,sig);
    if(objFieldID == NULL){
        return NULL;
    }
    return env -> GetObjectField(obj,objFieldID);
  }


JNIEXPORT void JNICALL Java_com_mmotiy_service_Mouse_sendInput(JNIEnv *env, jobject obj, jobject param){
    printf("revice an info\n");
    //测试访问java 实例的字段
    INPUT ip;
    // mip.dwFlags = MOUSEEVENTF_MOVE;
    // mip.dx = 10;
    // mip.dy = 10;
    // mip.time = 0;
    
    //得到参数的Class 类
    // jclass tagClass = env -> GetObjectClass(param);
    // jfieldID tagTypFieldID = env -> GetFieldID(tagClass,MY_TYPE_NAME,"I");
    // jint tagType = env -> GetIntField(param,tagTypFieldID);
    jint tagType = getIntFromObj(env,param,MY_TYPE_NAME,"I");
    if(tagType == INPUT_MOUSE){//鼠标移动事件
        // jfieldID mouseDataFieldID = env ->GetFieldID(tagClass,MY_MOUSE_DATE,"Lcom/mmotiy/dto/TagMOUSEINPUT;");
        // jobject mouseDataObject = env -> GetObjectField(param,mouseDataFieldID);
        // jclass mouseDataClass = env -> GetObjectClass(mouseDataObject);
        jobject mouseDataObject = getObjFormObj(env,param,MY_MOUSE_DATE,"Lcom/mmotiy/dto/TagMOUSEINPUT;");
        //winodw api 参数
        MOUSEINPUT mip;
        // jfieldID myDwFlagsFieldID =  env -> GetFieldID(mouseDataClass,"dwFlags","I");
        // jint myDwFlags = env -> GetIntField(mouseDataObject,myDwFlagsFieldID);
        jint myDwFlags = getIntFromObj(env,mouseDataObject,"dwFlags","I");
        jint myDx = getIntFromObj(env,mouseDataObject,"dx","I");
        jint myDy = getIntFromObj(env,mouseDataObject,"dy","I");
        jint myTime = getIntFromObj(env,mouseDataObject,"time","I");
        mip.dwFlags = myDwFlags;
        mip.dx = myDx;
        mip.dy = myDy;
        mip.time = myTime;
        ip.type = INPUT_MOUSE;
        ip.mi = mip;
        printf("%d\n", myDwFlags);
        SendInput(1,&ip,sizeof(INPUT));
    }else if(tagType == INPUT_KEYBOARD){//键盘事件

    }else if(tagType == INPUT_HARDWARE){//硬件事件

    }else{
        printf("%s\n", "未正确识别");
    }
    return ;
  }






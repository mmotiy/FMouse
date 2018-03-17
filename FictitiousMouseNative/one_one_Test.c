#include <jni.h>
#include "one_one_Test.h"
#include <stdio.h>
#include <windows.h>
 JNIEXPORT void JNICALL Java_one_one_Test_sayHello(JNIEnv * env, jobject obj, jstring name){
 	const char *str; 
        str = env->GetStringUTFChars( name, NULL); 
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

  JNIEXPORT void JNICALL Java_one_one_Test_accessField(JNIEnv * env, jobject obj, jobject param)
  {

   jclass aclass =  env -> GetObjectClass(param);
   jfieldID fid = env -> GetFieldID(aclass,"a","Ljava/lang/String;");
   jfieldID fid2 = env -> GetFieldID(aclass,"b","Lone/one/B;");
   jstring a =  (jstring) env -> GetObjectField(param,fid);
   jobject b = env -> GetObjectField(param,fid2);

   jclass bclass = env -> GetObjectClass(b);
   jfieldID fid3 = env -> GetFieldID(bclass,"b","Ljava/lang/String;");
   jstring str_b = (jstring) env -> GetObjectField(b,fid3);
   const char * str = env -> GetStringUTFChars(a,JNI_FALSE);
   const char * str_b_str = env -> GetStringUTFChars(str_b,JNI_FALSE);
   printf("%s\n", str); 
   printf("%s\n", str_b_str); 
   env -> ReleaseStringUTFChars(a,str);
   env -> ReleaseStringUTFChars(str_b,str_b_str);
  
  }
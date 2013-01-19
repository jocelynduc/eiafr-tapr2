#include <CoreServices/CoreServices.h>
#include "ShowOSXInfo.h"
#include <string.h>

SInt32 maj, min, bug;

int getInfo() {
	Gestalt(gestaltSystemVersionMajor, &maj);
    Gestalt(gestaltSystemVersionMinor, &min);
    Gestalt(gestaltSystemVersionBugFix, &bug);
}

JNIEXPORT jobject JNICALL Java_ShowOSXInfo_getOSXInfo(JNIEnv *env, jobject thisObj)
{
	getInfo();
	jstring ver;

	if (maj = 10){
		switch (min) {
			case 1:
				ver = (*env)->NewStringUTF(env, "Puma");
				break;
			case 2:
				ver = (*env)->NewStringUTF(env, "Jaguar");
				break;
			case 3:
				ver = (*env)->NewStringUTF(env, "Panther");
				break;
			case 4:
				ver = (*env)->NewStringUTF(env, "Tiger");
				break;
			case 5:
				ver = (*env)->NewStringUTF(env, "Leopard");
				break;
			case 6:
				ver = (*env)->NewStringUTF(env, "Snow Leopard");
				break;
			case 7:
				ver = (*env)->NewStringUTF(env, "Lion");
				break;
			case 8:
				ver = (*env)->NewStringUTF(env, "Mountain Lion");
				break;
			default: 
				ver = (*env)->NewStringUTF(env, "Unknown");
		}
	}
	else {
		ver = (*env)->NewStringUTF(env, "Unknown");
	}

	jclass osxinfo = (*env)->FindClass(env, "OSXInfo");
	if (osxinfo == NULL) {
        jclass exception = (*env)->FindClass(env,"java/lang/Exception");
        (*env)->ThrowNew(env, exception, "Cannot find OSXInfo");
        return NULL;
    }
    
	jmethodID constructorMethod = (*env)->GetMethodID(env, osxinfo, "<init>", "(IIILjava/lang/String;)V");
	if (constructorMethod == NULL) {
        (*env)->DeleteLocalRef(env, osxinfo);
        jclass exception  = (*env)->FindClass(env,"java/lang/Exception");
        (*env)->ThrowNew(env, exception, "Cannot find constructor");
        return NULL;
    }

    jobject result = (*env)->NewObject(env, osxinfo, constructorMethod, maj, min, bug, ver);

    return result;
}

int main()
{
	getInfo();
    printf("Mac Version: %d.%d.%d\n", maj, min, bug);
}
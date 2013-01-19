#include <CoreServices/CoreServices.h>
#include "ShowOSXInfo.h"
#include <string.h>

SInt32 maj, min, bug;

int getInfo() {
	Gestalt(gestaltSystemVersionMajor, &maj);
    Gestalt(gestaltSystemVersionMinor, &min);
    Gestalt(gestaltSystemVersionBugFix, &bug);
}

JNIEXPORT jstring JNICALL Java_ShowOSXInfo_getOSXInfo(JNIEnv *env, jobject thisObj)
{
	getInfo();
	char ver[1000];
    snprintf(ver, sizeof ver, "Mac OSX: %d.%d.%d", maj, min, bug);
    return (*env)->NewStringUTF(env,ver);
}

int main()
{
	getInfo();
    printf("Mac Version: %d.%d.%d\n", maj, min, bug);
}
/* File:	  TheNativeMethodImpl.c
 * What:	  'C' implementation for the native method
 * Changes:	Rudolf Scheurer, EIA-FR (rudolf.scheurer@hefr.ch)
 */

#include <stdio.h>
#include "AClassWithNativeMethods.h"

JNIEXPORT jstring JNICALL Java_AClassWithNativeMethods_sayHello
	(JNIEnv* env, jobject thisObj, jstring myParameter){
		char buf [128];
		const char *str = (*env)->GetStringUTFChars(env, myParameter, NULL);
		printf("%s", str);
		(*env)->ReleaseStringUTFChars(env, myParameter, str);
		scanf("%s", buf);
		return (*env)->NewStringUTF(env, buf);
}
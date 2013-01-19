/* File:	  TheNativeMethodImpl.c
 * What:	  'C' implementation for the native method
 * Changes:	Rudolf Scheurer, EIA-FR (rudolf.scheurer@hefr.ch)
 */

#include <stdio.h>
#include "AClassWithNativeMethods.h"

JNIEXPORT void JNICALL Java_AClassWithNativeMethods_theNativeMethod
	(JNIEnv* env, jobject thisObj) 	{
 	    printf("Hi folks, welcome to the JNI world!\n");
}


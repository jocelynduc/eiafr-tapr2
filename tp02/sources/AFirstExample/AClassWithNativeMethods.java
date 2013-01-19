/* File:	  AClassWithNativeMethods.java
 * What:	  Java program to demonstrate
 *		      a simple native method invocation
 * Changes:	Rudolf Scheurer, EIA-FR (rudolf.scheurer@eif.ch)
 */

/**
 * AClassWithNativeMethods
 */
public class AClassWithNativeMethods {
    
	public native void theNativeMethod();
	
 	public void aJavaMethod() {
 	    theNativeMethod(); // the native method
	}
}


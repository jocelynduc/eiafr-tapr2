/* File:	  SimpleJNI.java
 * What:	  Java program to demonstrating
 *		      a simple native method invocation
 * Changes:	Rudolf Scheurer, EIA-FR (rudolf.scheurer@hefr.ch)
 */

/**
 * The SimpleJNI class
 */
public class SimpleJNI {
	static {
		System.loadLibrary("NativeMethodImpl");
	}
	public static void main(String[] args) {
		AClassWithNativeMethods theClass = new AClassWithNativeMethods();
		theClass.aJavaMethod();    // a NON native method
	}
}

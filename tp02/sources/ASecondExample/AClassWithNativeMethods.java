/* File:	  AClassWithNativeMethods.java
 * What:	  Java program to demonstrate
 *		      a simple native method invocation
 * Changes:	Rudolf Scheurer, EIA-FR (rudolf.scheurer@eif.ch)
 */

/**
 * AClassWithNativeMethods
 */
public class AClassWithNativeMethods {
    
	public native String sayHello(String message);

	public void saySomething() {
 	    System.out.println(sayHello("Hello world!")); // the native method
	}
}


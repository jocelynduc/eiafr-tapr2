package rmi.hello;

import java.rmi.*;

public class HelloClient {

	public static void main(String args[]) {

		// check argument
		

		try {

			System.out.println("Performing lookup ...");
			Hello obj = (Hello) Naming
					.lookup("//160.98.61.213/MyHelloServer");

			System.out.println("Invoking remote method ...");
			String message = obj.sayHello();
			System.out.println("Remote method returned '" + message
					+ "' and completed successfully.\n");

		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}

/**
 * File   : TCPServer.java
 * Author : R. Scheurer (EIA-FR)
 * Date   : 04.10.2012
 * 
 * Description - a simple TCP server template
 *
 */
package sockets.tcp;

import java.net.*;
import java.io.*;

public class TCPServer {

	static final int SERVER_PORT = 1234; // server port to use
	static int id = 0; // client id

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(SERVER_PORT);
		Socket s;
		Thread t;
		System.out.println("Listening on TCP port " + SERVER_PORT + " ...");
		while(true){
			s = ss.accept();
			t = new TCPServerThread(s, id);
			t.start();
			id++;
		}
	}
}

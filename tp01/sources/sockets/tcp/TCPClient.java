/**
 * File   : TCPClient.java
 * Author : R. Scheurer (EIA-FR)
 * Date   : 04.10.2012
 * 
 * Description - a simple TCP client
 *
 */
package sockets.tcp;

import java.net.*;
import java.io.*;

public class TCPClient {

	private Socket s;
	private ObjectOutputStream oos;

	public TCPClient(InetSocketAddress isa) throws IOException {
		InetAddress client = InetAddress.getByName("160.98.61.161");
		InetSocketAddress isaClient = new InetSocketAddress(client, 61234);
		s = new Socket(isa.getHostName(), isa.getPort(), isaClient.getAddress(), isaClient.getPort());
		oos = new ObjectOutputStream(s.getOutputStream());
	}
	
	public void closeSocket() throws IOException{
		oos.close();
		s.close();
	}
	
	public void sendMsg(String msg) throws IOException{
		oos.writeObject(msg);
		oos.flush();
	}
}

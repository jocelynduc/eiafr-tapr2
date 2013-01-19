/**
 * File   : UDPClient.java
 * Author : R. Scheurer (EIA-FR)
 * Date   : 04.10.2012
 * 
 * Description - a simple UDP client
 * 
 */
package sockets.udp;

import java.net.*;

public class UDPClient {
	
 
  DatagramSocket ds;
  DatagramPacket dp;
  byte[] buffer;
  static final int MAX_SIZE = 30;
  

  public UDPClient(int localPort) throws SocketException {
    ds = new DatagramSocket(localPort);
    
  }
  
  public int getPort(){
	  return ds.getLocalPort();
  }
  
  public void closeSocket(){
	  ds.close();
  }
    
  public void sendMsg(InetSocketAddress isaServer, String msg) throws Exception {
	  // preparing
		//InetAddress inetAddress = InetAddress.getByName(isaServer.getHostName());

		if(msg.length() > MAX_SIZE)throw new Exception("Message out of bound");
		dp = new DatagramPacket(
				msg.getBytes(),   // data buffer (of type byte[])
				msg.length(),     // size of data buffer
				isaServer.getAddress(),      // destination address
				isaServer.getPort()    // integer
		);

		// sending
		ds.send(dp);
  }

}

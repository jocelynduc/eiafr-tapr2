/**
 * File   : UDPServer.java
 * Author : R. Scheurer (EIA-FR)
 * Date   : 04.10.2012
 * 
 * Description - a simple UDP server template
 * 
 */
package sockets.udp;

import java.io.IOException;
import java.net.*;

public class UDPServer {

  static final int MAX_SIZE = 100;
  static final int SERVER_PORT = 1234;


  
  public static void main(String[] args) {
	int msgCounter = 0;
    byte[] buffer = new byte[MAX_SIZE];
    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

    try {            
        DatagramSocket datagramSocket = new DatagramSocket(SERVER_PORT);
        System.out.println("Datagram Socket initialized on port: " + SERVER_PORT);
        while(true) {
            dp.setLength(buffer.length);
            datagramSocket.receive(dp);
            datagramSocket.send(dp);
            char[] chars = new char[dp.getLength()];
            new String(dp.getData()).getChars(dp.getOffset(), dp.getLength(), chars, 0);
            msgCounter++;
            System.out.print("Message " + msgCounter + " from "  + dp.getAddress().getHostAddress() + " --> " );
            System.out.println(chars);
            
            
        }
    }
    catch(SocketException e) {  
        System.out.println("A SocketException ocurred related to the DatagramSocket. "+e.getMessage());
    }
    catch(IOException e) { 
        System.out.println("An I/O exception occurred related to the DatagramSocket. "+e.getMessage());
    }
    
  }
}

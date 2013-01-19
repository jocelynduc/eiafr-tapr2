package sockets.tcp;

import java.io.*;
import java.net.*;

public class TCPServerThread extends Thread {

	private Socket s;
	private int id;
	private ObjectInputStream ois;

	public TCPServerThread(Socket s, int id) throws IOException {
		this.s = s;
		this.id = id;
		ois = new ObjectInputStream(s.getInputStream());
		System.out.println(">> " + id + " : New connection request from "
				+ s.getInetAddress() + ":" + s.getPort());
	}

	@Override
	public void run() {
		try {
			while (true) {
				String str = (String) ois.readObject();
				System.out.println("@@ " + id + " : " + str);
			}
		} catch (IOException e) {
			System.out.println("## " + id + " : Connection closed");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found.");
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				s.close();
			} catch (IOException e) {
				System.err.println("Unable to close the connection.");
				e.printStackTrace();
			}
		}
	}
}

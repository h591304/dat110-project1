package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {
		byte[] data;
		data = MessageUtils.encapsulate(message);

		// encapsulate the data contained in the message and write to the output stream
		
		try {
			outStream.write(data);
		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public Message receive() {

		Message message = null;
		byte[] segment = new byte[MessageConfig.SEGMENTSIZE];

		// read a segment from the input stream and decapsulate into message
		try {
			inStream.read(segment);
		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		message = MessageUtils.decapsulate(segment);

		return message;
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
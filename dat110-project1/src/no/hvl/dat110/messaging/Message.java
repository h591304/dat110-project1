package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		if(data != null && data.length < MessageUtils.SEGMENTSIZE) {
			this.data = data;
		}
		else {
			System.out.println("Too many bytes!!!");
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.data; 
	}

}

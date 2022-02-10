package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		connection = msgclient.connect();
	}
	
	public void disconnect() {
		
		connection.close();
	}
	
	public byte[] call(byte rpcid, byte[] rpcRequest) {
		
		byte[] rpcReply = null;
		
		/* 
		 * 
		Make a remote call on the RPC server by sending an RPC request message
		and receive an RPC reply message
		
		rpcRequest is the marshalled parameters from the client-stub
				
		The rpcid, params(rpcRequest), and return value(rpcReply) must be encapsulated/decapsulated
		according to the RPC message format
			
		*/



		Message requestMessage = new Message(RPCUtils.encapsulate(rpcid, rpcRequest));

		connection.send(requestMessage);
		rpcReply = RPCUtils.decapsulate(connection.receive().getData());

		return rpcReply;
		
	}

}

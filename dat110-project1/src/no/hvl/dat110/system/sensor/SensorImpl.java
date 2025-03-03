package no.hvl.dat110.system.sensor;

import no.hvl.dat110.rpc.RPCCommon;
import no.hvl.dat110.rpc.RPCRemoteImpl;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.rpc.RPCServer;

public class SensorImpl extends RPCRemoteImpl {

	static final int RANGE = 20;

	public SensorImpl(byte rpcid, RPCServer rpcserver) {
		super(rpcid,rpcserver);
	}
	
	public int read() {

		long seconds = System.currentTimeMillis();

		double temp = RANGE * Math.sin(seconds / 1000);

		System.out.println("READ:" + temp);
		
		return (int) Math.ceil(temp);
	}
	
	public byte[] invoke(byte[] params) {
				
		RPCUtils.unmarshallVoid(params); 
		
		int temp = read();
				
		byte[] returnval = RPCUtils.marshallInteger(temp);
		
		return returnval;
	}
}

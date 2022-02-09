package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;
import no.hvl.dat110.system.sensor.SensorImpl;

public class DisplayDevice {

    public static void main(String[] args) {

        System.out.println("Display server starting ...");

        // implement the operation of the display RPC server
        // see how this is done for the sensor RPC server in SensorDevice

        RPCServer rpcServer = new RPCServer(Common.DISPLAYPORT);
        SensorImpl sensor = new SensorImpl((byte)1 ,rpcServer);

        rpcServer.run();
        rpcServer.stop();

        System.out.println("Display server stopping ...");
    }
}
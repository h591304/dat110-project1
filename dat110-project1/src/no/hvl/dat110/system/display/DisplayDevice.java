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

        RPCServer display = new RPCServer(Common.DISPLAYPORT);
        DisplayImpl sensor = new DisplayImpl((byte)2, display);

        display.run();
        display.stop();

        System.out.println("Display server stopping ...");
    }
}
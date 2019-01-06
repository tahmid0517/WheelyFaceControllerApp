package com.tahmid.wheelyfacecontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by owner on 8/4/2017.
 */

public class SocketConnector
{
    private static final String ADDRESS = "E4:F8:9C:34:76:AE";
    private static BluetoothSocket socket;
    private static PrintWriter writer;
    public static void connect(String address)
    {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(address);
        try{
            socket = device. createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            socket.connect();
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch(IOException e){
            System.out.println("error");
        }
    }
    public static void write(String line)
    {
       writer.println(line);
       writer.flush();
    }
}

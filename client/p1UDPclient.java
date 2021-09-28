package client;
import java.net.*;
import java.io.*;

public class p1UDPclient extends thisClient{

    public p1UDPclient(String port_, String host_) {
        super(port_, host_);
        //TODO Auto-generated constructor stub
    }

    @Override
    void run()
    {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            byte [] m = "info".getBytes();
            InetAddress aHost = InetAddress.getByName(hostname);
            int serverPort = Integer.valueOf(port).intValue();
            DatagramPacket request = new DatagramPacket(m, "info".length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
            }
            catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
            }
            catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
            }
            finally {
            if (aSocket != null) 
            aSocket.close();
            }
           
    }
    
}

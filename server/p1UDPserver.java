package server;

import java.io.*;
import java.net.*;

public class p1UDPserver extends thisServer{

    public p1UDPserver(String port_) {
        super(port_, "UDP");
        startServer();
    }

    @Override
    public
    void startServer() {
        running = true;
        run();
    }

    @Override
    public
    void stopServer() {
        running = false;
    }

    @Override
    public
    void run()
    {
        DatagramSocket aSocket = null;
        try {
            int socket_no = port;
            aSocket = new DatagramSocket(socket_no);
            while(running)
            {

                    byte[] buffer = new byte[1000];
                    while(true)
                    {
                        DatagramPacket request = new DatagramPacket(buffer,
                        buffer.length);
                        aSocket.receive(request);
                        DatagramPacket reply = new DatagramPacket(request.getData(),
                        request.getLength(),request.getAddress(),
                        request.getPort());
                        aSocket.send(reply);
                    }
            }
        }
        catch (SocketException e) {
            //serverLog.callLogger("Socket: " + e.getMessage());
        }
        catch (IOException e) {
            //serverLog.callLogger("IO: " + e.getMessage());
        }
        finally {
            if (aSocket != null) 
                aSocket.close();
        }
    }   
}
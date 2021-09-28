package server;

import java.io.*;

import javax.print.DocFlavor.STRING;

import logger.allLogger;

public class serverHandler {
    boolean keeprunning;
    p1TCPserver tcpServer;
    p1UDPserver udpServer;
    public static void main(String[] args) {
        serverHandler newServer = new serverHandler();
        newServer.checkServers();
    }

    public void checkServers()
    {
        int i = -1;
        do
        {
            decideServer();
        }while(i != -1);
    }

    public int decideServer()
    {
        int serverType = -1;
        Console console = System.console();
        String serverDecision = console.readLine("For a TCP client enter T / for a UDP client enter U: ");
        if (serverDecision.length() != 1) return -1;
        char c = Character.toLowerCase(serverDecision.charAt(0));
        if( c == 't')
        {
            serverType = 0;
            tcpServer = new p1TCPserver(getPort());
            if(udpServer != null)
                udpServer.stopServer();
        }    
        else if( c == 'u')
        {
            serverType = 1;
            udpServer = new p1UDPserver(getPort());
            if(tcpServer != null)
                tcpServer.stopServer();
        }    
        else
        {
            serverType = -1;
            if(tcpServer != null)
                tcpServer.stopServer();
            if(udpServer != null)
                udpServer.stopServer();
        }    
        return serverType;
    }

    public static String getPort()
    {
        Console console = System.console();
        String port_ = console.readLine("Enter a port : ");
        return port_;
    }
}

package client;

import java.util.HashMap;
import java.io.*;

public class clientFeatureHandler {
        public HashMap<String, String> initStore;
        p1TCPclient tcpClient;
        p1UDPclient udpClient;
    
        public clientFeatureHandler()
        {
            initStore = new HashMap<String, String>();
        }
    
        //initizialize the hashmap store for the first time.
        public void initializeStore(){
            initStore.put("001615081", "Uttkarsh Narayan");
            initStore.put("001615302", "Rohan Gal");
            initStore.put("001615785", "Drek Rin");
            initStore.put("001615098", "Riku Kin");
            initStore.put("001615111", "Thomas Bane");
        }

        public static void main(String[] args) {
            clientFeatureHandler newClient = new clientFeatureHandler();
            newClient.decideServer();
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
                tcpClient = new p1TCPclient(getPort(), getHost());
                tcpClient.run();
            }    
            else if( c == 'u')
            {   
                serverType = 1;
                udpClient = new p1UDPclient(getPort(), getHost());
                udpClient.run();
            }
            else
            {    serverType = -1;
            }
            return serverType;
        }

        public static String getPort()
        {
            Console console = System.console();
            String port_ = console.readLine("Enter a port : ");
            return port_;
        }

        public static String getHost()
        {
            Console console = System.console();
            String port_ = console.readLine("Enter a hostname : ");
            return port_;
        }
}

package client;

import logger.allLogger;
import java.util.HashMap;
import java.io.*;

public abstract class thisClient {
    public boolean running;
    public allLogger clientLog;
    public int port;
    public String hostname;
    public HashMap<String, String> initClientStore;

    public thisClient(String port_, String host_)
    {
        initClientStore = new HashMap<String,String>();
        initializeStore();
        clientLog = new allLogger();
        clientLog.setLogger("clientLog.log", true);
        try {
            port =  Integer.parseInt(port_);
        } catch (NumberFormatException e) {
            clientLog.callLogger("invalid port info given");
          return;
        }

        hostname = host_;
        running = true;
    }

    public void initializeStore(){
        initClientStore.put("1", "Uttkarsh Narayan");
        initClientStore.put("2", "Rohan Gal");
        initClientStore.put("3", "Drek Rin");
        initClientStore.put("4", "Riku Kin");
        initClientStore.put("5", "Thomas Bane");
    }

    public String serverDataPUT(String key, String val)
    {
        return key + "," + val +","+"PUT"; 
    }
    public String serverDataGET(String key, String val)
    {
        return key + "," + val +","+"GET"; 
    }
    public String serverDataDELETE(String key, String val)
    {
        return key + "," + val +","+"DELETE"; 
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
        String host = console.readLine("Enter a hostname : ");
        return host;
    }

    abstract void run();
}

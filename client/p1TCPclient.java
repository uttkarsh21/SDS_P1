package client;
import java.net.*;
import java.io.*;


public class p1TCPclient extends thisClient {

    static p1TCPclient tcpClient;
    public static void main(String[] args) throws IOException {
        Console console = System.console();
        String port_ = console.readLine("Enter a port : ");
        String host_ = console.readLine("Enter a hostname : ");
        tcpClient = new p1TCPclient(port_,host_);
        tcpClient.clientLog.callLogger("initiated TCP server");
    }

    public p1TCPclient(String port_, String host_) {
        super(port_, host_);
    }
    
    @Override
    void run()
    {

        try
        {           
            Socket socket1 = new Socket(hostname,port);

            while(running)
            {
                InputStream socket1In = socket1.getInputStream();
                DataInputStream inputStream = new DataInputStream(socket1In);
    
                String st = new String (inputStream.readUTF());
                tcpClient.clientLog.callLogger("Server " +st);
        
                OutputStream socket1out = socket1.getOutputStream();
                DataOutputStream outputStream = new DataOutputStream(socket1out);        
            
                outputStream.writeUTF(tcpClient.serverDataDELETE("1", tcpClient.initClientStore.get("1")));
        
                inputStream = new DataInputStream(socket1In);
                st = new String (inputStream.readUTF());
                tcpClient.clientLog.callLogger("Reversed string received from server is " +st);
    
                tcpClient.clientLog.callLogger("closing client now!");
                inputStream.close();
                socket1In.close();
            }

            socket1.close();
        } catch (SocketException e) {
            tcpClient.clientLog.callLogger("Server port not found, exception thrown : " +e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            tcpClient.clientLog.callLogger(e.toString());
        }
    }
}

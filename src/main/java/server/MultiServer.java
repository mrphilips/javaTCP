package main.java.server;

import main.java.server.http.requests.Request;

import java.io.*;
import java.net.Socket;

/**
 * Created by david on 25/04/2016.
 */
public class MultiServer implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText   = null;

    private InputStream input;
    private OutputStream output;

    public MultiServer(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
             input  = clientSocket.getInputStream();
             output = clientSocket.getOutputStream();

            String ss = readInput();

            RequestManager requestManager = new RequestManager(new Request(ss));

            long time = System.currentTimeMillis();

            output.write(requestManager.getResponse().getBytes());
            output.close();
            input.close();
            //System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }

    public String readInput(){
        String s;
        String ss = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            while ((s = in.readLine()).length() > 0)
                ss += s + "\n";

        }

        catch(IOException e){
            ss = "";
        }

        return ss;
    }

}
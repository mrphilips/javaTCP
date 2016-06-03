package main.java;// TCPServer.java
// A main.java.server program implementing TCP socket
import main.java.server.MultiServer;

import java.net.*;

public class Main {
    public static void main(String args[])
            throws Exception {
        ServerSocket ssock = new ServerSocket(8080);
        //System.out.println("Listening");

            while (true) {
                Socket sock = ssock.accept();
              //  System.out.println("Connected");
                new Thread(new MultiServer(sock,"<html><h1>Hello world</h1></html>")).start();
            }
    }
}





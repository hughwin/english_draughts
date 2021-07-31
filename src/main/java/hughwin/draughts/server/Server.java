package main.java.hughwin.draughts.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private final int PORT;

    public Server(int port){
        PORT = port;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket connectionSocket = serverSocket.accept();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

    }
}

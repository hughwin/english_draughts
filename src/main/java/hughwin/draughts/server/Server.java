package main.java.hughwin.draughts.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Server implements Runnable {

    private final int PORT;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int id = 0;
    private List<ClientRunner> clients = Collections.synchronizedList(new ArrayList<>());

    public Server(int port){
        PORT = port;
        try {
            serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while(true){
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("New client connected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package main.java.hughwin.draughts.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server implements Runnable {

    private final int PORT;
    private ServerSocket serverSocket;
    private static int id = 0;
    private List<ServerClient> clients = Collections.synchronizedList(new ArrayList<>());

    public Server(int port){
        PORT = port;
        System.out.println("Starting server...");
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        System.out.println("Listening on port " + PORT);
        while(true){
            Socket clientSocket;
            try {
                if(clients.size() < 2) {
                    clientSocket = serverSocket.accept();
                    System.out.println("New client connected");
                    clients.add(new ServerClient(clientSocket, id++));
                }
                else{
                    clientSocket = serverSocket.accept();
                    new ServerClient(clientSocket, id++).connectionRefused();
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

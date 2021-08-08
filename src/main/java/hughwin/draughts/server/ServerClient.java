package main.java.hughwin.draughts.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClient {

    private String name;
    private final int id;
    private Socket clientSocket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ServerClient(Socket clientSocket, int id) {
        this.clientSocket = clientSocket;
        this.id = id;
        try {
            this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connectionRefused(){
        System.out.println("Connection refused, too many clients");
        try {
            objectOutputStream.writeObject("refused");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

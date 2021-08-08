package main.java.hughwin.draughts;

import main.java.hughwin.draughts.controller.Client;
import main.java.hughwin.draughts.server.Server;


public class Main {

    public static final int PORT = 8888;

    public static void main(String[] args) {
        new Client();
        Thread serverThread = new Thread(new Server(PORT));
        serverThread.start();
    }
}

package main.java.hughwin.draughts;

import main.java.hughwin.draughts.controller.AppController;
import main.java.hughwin.draughts.server.Server;
import main.java.hughwin.draughts.view.Welcome;


public class Main {

    public static final int PORT = 8888;

    public static void main(String[] args) {
        new AppController();
        new Server(PORT);
    }
}

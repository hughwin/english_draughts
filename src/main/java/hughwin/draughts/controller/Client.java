package main.java.hughwin.draughts.controller;

import main.java.hughwin.draughts.Main;
import main.java.hughwin.draughts.view.AppView;
import main.java.hughwin.draughts.view.Board;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private final static int PORT = Main.PORT;
    private final static String LOCALHOST = "127.0.0.1";

    private AppView appView = new AppView(this);
    private String name = "";
    private Socket server;

    public Client(){
    }

    public void startGame(String name){
        try {
            System.out.println("Starting client");
            this.name = "name";
            server = new Socket(LOCALHOST, PORT);
            new Board();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void quitGame(){

    }

}

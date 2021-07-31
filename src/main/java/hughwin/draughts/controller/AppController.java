package main.java.hughwin.draughts.controller;

import main.java.hughwin.draughts.view.AppView;
import main.java.hughwin.draughts.view.Board;
import main.java.hughwin.draughts.view.Board;

public class AppController {

    private AppView appView = new AppView(this);

    public AppController(){
    }

    public void startGame(String name){
        new Board();
    }

    public void quitGame(){

    }

}

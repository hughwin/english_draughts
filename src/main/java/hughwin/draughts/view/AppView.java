package main.java.hughwin.draughts.view;

import main.java.hughwin.draughts.controller.AppController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AppView extends JFrame {
    private static final String WINDOW_TITLE = "Twenty One";
    private AppController appController;
    private JPanel mainPanel = new JPanel();

    public AppView(AppController appController) {
        super();
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Are You Sure to Close Application?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    appController.quitGame();
                    System.exit(0);
                }
            }
        };
        this.addWindowListener(exitListener);

        this.appController = appController;
        setTitle(WINDOW_TITLE);
        setSize(600, 400);
        add(mainPanel);
        mainPanel.add(new Welcome(this.appController), "home");

        setVisible(true);

    }

//    public GamePage getGamePage() {
//        return gamePage;
//    }

    public void setPageView(String constraint) {
    }
}

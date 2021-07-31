package main.java.hughwin.draughts.view;

import javax.swing.*;
import java.awt.*;
import main.java.hughwin.draughts.controller.AppController;

public class Welcome extends JPanel {

    private static final String TITLE = "<html><h1><strong><i>English Draughts!</i></strong></h1><hr></html>";
    // extra space necessary to stop it looking strange
    private static final String SUB_TITLE = "<html><i>Please select an option below! </i><html>";


    public Welcome(AppController appController) {


        String name = JOptionPane.showInputDialog(this, "What's your name?");

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel(TITLE), gbc);
        add(new JLabel(SUB_TITLE), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        JButton play = new JButton("Play Game");
        play.addActionListener(e -> appController.startGame(name));
        buttons.add(play, gbc);

        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));

        buttons.add(exit, gbc);

        gbc.weighty = 1;
        add(buttons, gbc);

    }

}

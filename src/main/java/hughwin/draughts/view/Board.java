package main.java.hughwin.draughts.view;

import javax.swing.*;
import java.awt.*;


public class Board {
    private JFrame frame = new JFrame();
    private JPanel backBoard = new JPanel();
    public static String type_BLANK = "BLANK";
    private String type_RED = "RED";
    private String type_BLACK = "BLACK";
    private int width = 100;
    private int height = 100;

    public Board() {


        int numRows = 8;
        int numCols = 8;

        frame.setSize(905, 905);
        backBoard.setSize(900, 900);
        frame.setResizable(false);
        frame.setTitle("English Draughts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        backBoard.setVisible(true);

        String type;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                //
                type = type_BLANK;
                if (c % 2 == 0) {
                    if (r == 0 || r == 2) {
                        type = type_RED;
                    } else if (r == 6) {
                        type = type_BLACK;
                    }
                } else {
                    if (r == 1) {
                        type = type_RED;
                    } else if (r == 5 || r == 7) {
                        type = type_BLACK;
                    }
                }
                backBoard.add(new BoardSquare(r, c, type));
            }
        }

        backBoard.repaint();
        frame.add(backBoard);
        frame.repaint();


    }

    private class BoardSquare extends JComponent {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private int x; //x position of the rectangle measured from top left corner
        private int y; //y position of the rectangle measured from top left corner

        private boolean isBlack = false;
        private boolean isRed = false;

        public BoardSquare(int p, int q, String type) {
            //this.setBorder(new LineBorder(Color.CYAN, 2));
            this.setPreferredSize(new Dimension(width, height));

            x = p;
            y = q;
            if (type.equals(type_BLACK)) {
                isBlack = true;
                isRed = false;
            } else if (type.equals(type_RED)) {
                isRed = true;
                isBlack = false;
            } else if (type.equals(type_BLANK)) {
                isBlack = false;
                isRed = false;
            }

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle box = new Rectangle(x, y, width, height);
            g2.draw(box);
            g2.setPaint(Color.BLUE);
            g2.fill(box);
            int ovalWidth = width - 15;
            if (isBlack) {
                g2.setColor(Color.black);
                g2.fillOval(x, y, ovalWidth, ovalWidth);
                g2.drawOval(x, y, ovalWidth, ovalWidth);
            } else if (isRed) {
                g2.setColor(Color.red);
                g2.fillOval(x, y, ovalWidth, ovalWidth);
                g2.drawOval(x, y, ovalWidth, ovalWidth);
            }

        }
    }


}

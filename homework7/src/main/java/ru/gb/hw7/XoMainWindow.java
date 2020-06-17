package ru.gb.hw7;

import javax.swing.*;

public class XoMainWindow extends JFrame {
    private static final int WIDTH = 507;
    private static final int HEIGHT = 555;
    private static final int POS_X = 650;
    private static final int POS_Y = 250;

    public XoMainWindow () {
        setSize(WIDTH, HEIGHT);
        setLocation(POS_X, POS_Y);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Крестики - нолики");

        setResizable(false);

        setVisible(true);
    }
}

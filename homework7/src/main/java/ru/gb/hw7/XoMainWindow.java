package ru.gb.hw7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoMainWindow extends JFrame {
    private static final int WIDTH = 507;
    private static final int HEIGHT = 555;
    private static final int POS_X = 650;
    private static final int POS_Y = 250;

    private final ActionListener exitAction = new ActionListener() {
        //@Override  //idea ругается на оверрайд - not allowed when implementing interface method... Из-за версии явы?
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

    private final ActionListener settingsWindowAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            settingsWindow.setVisible(true);
        }
    };

    private XoSettingsWindow settingsWindow;
    private XoFieldPanel fieldPanel;

    public XoMainWindow () {
        setSize(WIDTH, HEIGHT);
        setLocation(POS_X, POS_Y);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Крестики - нолики");

        setResizable(false);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(new XoListenerButton("Начать", settingsWindowAction));
        buttonPanel.add(new XoListenerButton("<html><body><b>Выйти</b></body></html>", exitAction));

        fieldPanel = new XoFieldPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        add(fieldPanel, BorderLayout.CENTER);

        this.settingsWindow = new XoSettingsWindow(this);

        setVisible(true);
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        this.fieldPanel.startGame(gameMode, fieldSize, winLength);
    }
}

package ru.gb.hw7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoSettingsWindow extends JFrame {
    private static final int WIDTH  = 350;
    private static final int HEIGHT = 270;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private static final String FIELD_SIZE_PREFIX   = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX   = "Длина линии выигрыша: ";

    private XoMainWindow mainWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVShum;

    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;

    public XoSettingsWindow(XoMainWindow mainWindow){
        setTitle("Начать игру");
        setSize(WIDTH, HEIGHT);

        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - HEIGHT / 2);
        setLocation(posX, posY);

        setResizable(false);
        this.mainWindow = mainWindow;

        setLayout(new GridLayout(10,1));

        addGameControls();
        addGameModeButtons();

        JButton buttonStart = new JButton("Начать новую игру");
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                callStartGame();
            }
        });
        add(buttonStart);
    }

    private void addGameModeButtons(){
        JLabel label = new JLabel("Выбери режим");
        add(label);

        humVSAI = new JRadioButton("Человек VS компьютер");
        humVShum = new JRadioButton("Человек VS человек");
        ButtonGroup group = new ButtonGroup();
        group.add(humVSAI);
        group.add(humVShum);
        humVShum.setSelected(true);

        add(humVSAI);
        add(humVShum);
    }

    private void addGameControls(){
        final JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        final JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        sliderFieldSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                labelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });

        sliderWinLength.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderWinLength.getValue();
                labelWinLength.setText(WIN_LENGTH_PREFIX + currentValue);
            }
        });

        add(labelFieldSize);
        add(sliderFieldSize);
        add(labelWinLength);
        add(sliderWinLength);
    }

    private void callStartGame(){
        int gameMode;

        if (humVShum.isSelected()){
            gameMode = XoFieldPanel.MODE_HUMVSNUM;
        } else if (humVSAI.isSelected()){
            gameMode = XoFieldPanel.MODE_HUMVSAI;
        } else {
            throw new RuntimeException("Режим не поддерживается");
        }

        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();

        mainWindow.startGame(gameMode, fieldSize, winLength);

        setVisible(false);
    }
}

package ru.gb.hw7;

import javax.swing.*;
import java.awt.*;

public class XoFieldPanel extends JPanel {
    public static final int MODE_HUMVSAI = 0;
    public static final int MODE_HUMVSNUM = 9;

    public XoFieldPanel() {
        setBackground(Color.CYAN);
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        System.out.printf("Начинаем игру:\n режим %d\nразмер поля %d\nдлина выигрыша %d", gameMode, fieldSize, winLength);
    }
}

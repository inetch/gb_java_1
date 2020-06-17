package ru.gb.hw7;

import javax.swing.*;
import java.awt.event.ActionListener;

public class XoListenerButton extends JButton {
    public XoListenerButton(String label, ActionListener listener) {
        setText(label);
        addActionListener(listener);
    }
}

package com.cactt4ck.sui;

import com.cactt4ck.sui.gui.PFrame;
import fr.skytale.rpeditor.RPEditor;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(PFrame::new);
    }

}

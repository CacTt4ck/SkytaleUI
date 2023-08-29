package com.cactt4ck.sui;

import com.cactt4ck.sui.gui.PFrame;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }*/
        FlatDarculaLaf.setup();

        System.out.println("Building window");
        SwingUtilities.invokeLater(PFrame::new);

        // ID du drive ROOT : 0AH3QNf4QT4dJUk9PVA
    }

}

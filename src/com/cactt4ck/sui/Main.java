package com.cactt4ck.sui;

import com.cactt4ck.sui.gui.PFrame;
import com.cactt4ck.sui.utils.AppConfig;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Main {

    public static final AppConfig CONFIG = new AppConfig();

    public static void main(String[] args) {
        if (CONFIG.getProperty("theme").equalsIgnoreCase("dark"))
            FlatDarculaLaf.setup();
        else
            FlatLightLaf.setup();

        System.out.println("Building window");
        SwingUtilities.invokeLater(PFrame::new);

        // ID du drive ROOT : 0AH3QNf4QT4dJUk9PVA
    }
}

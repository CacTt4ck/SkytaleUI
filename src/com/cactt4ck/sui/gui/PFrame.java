package com.cactt4ck.sui.gui;

import javax.swing.*;
import java.awt.*;

public class PFrame extends JFrame {

    public PFrame() {
        this.setSize(new Dimension(1280, 720));
        this.setTitle("SkytaleUI");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setContentPane(new PPanel());
        this.setVisible(true);
    }
}

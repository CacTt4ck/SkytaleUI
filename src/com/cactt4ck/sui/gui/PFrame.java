package com.cactt4ck.sui.gui;

import javax.swing.*;
import java.awt.*;

public final class PFrame extends JFrame {

    private final JPanel rootPanel, editionPanel;

    public PFrame() {
        this.rootPanel = new PPanel(this);
        this.editionPanel = new EditionPanel(this);

        this.setSize(new Dimension(1280, 720));
        this.setTitle("SkytaleUI");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/logo.png")).getImage().getScaledInstance(64,64, Image.SCALE_SMOOTH));
        this.setLocationRelativeTo(null);
        this.setContentPane(this.rootPanel);
        this.setVisible(true);
    }

    public void switchContentPane(Panels panel) {
        switch (panel) {
            case ROOT -> {
                this.setContentPane(this.rootPanel);
                this.repaint();
                this.revalidate();
            }
            case EDITION -> {
                this.setContentPane(this.editionPanel);
                this.repaint();
                this.revalidate();
            }
        }
    }
}

package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIRootMenuBar;
import fr.skytale.rpeditor.resourcepack.ResourcePack;

import javax.swing.*;
import java.awt.*;

public final class PFrame extends JFrame {

    private final JPanel rootPanel;
    private ResourcePack resourcePack;
    private SUIRootMenuBar menuBar;

    public PFrame() {
        this.rootPanel = new PPanel(this);

        this.setSize(new Dimension(1280, 720));
        this.setTitle("Resource Pack Editor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/logo.png")).getImage().getScaledInstance(64,64, Image.SCALE_SMOOTH));
        this.setLocationRelativeTo(null);

        this.menu();

        this.setContentPane(this.rootPanel);
        this.setVisible(true);
        System.out.println("Window built!");
    }

    // ---------------------------------------------------------------------- //

    public void switchContentPane(Panels panel) {
        switch (panel) {
            case ROOT -> {
                this.setContentPane(this.rootPanel);
                this.repaint();
                this.revalidate();
                System.out.println("Changing pane to ROOT");
            }
            case EDITION -> {
                this.setContentPane(new EditionPanel(this, this.resourcePack));
                this.repaint();
                this.revalidate();
                System.out.println("Changing pane to EDITION");
            }
        }
    }

    private void menu() {
        this.menuBar = new SUIRootMenuBar();
        //this.menuBar.getOpen().addActionListener(this.loadResourcePack());
        this.setJMenuBar(this.menuBar);
        //this.add(this.menuBar, BorderLayout.NORTH);
    }

    public ResourcePack getResourcePack() {
        return resourcePack;
    }

    public void setResourcePack(ResourcePack resourcePack) {
        this.resourcePack = resourcePack;
    }
}

package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.ProjectMenuBar;
import com.cactt4ck.sui.gui.components.SUIEditionMenuBar;
import com.cactt4ck.sui.gui.components.SUIRootMenuBar;
import fr.skytale.rpeditor.loaders.file.FileResourcePackLoader;
import fr.skytale.rpeditor.loaders.file.FileResourcePackOptions;
import fr.skytale.rpeditor.resourcepack.ResourcePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public final class PFrame extends JFrame {

    private final JPanel rootPanel;
    private ResourcePack resourcePack;
    private ProjectMenuBar menuBar;
    private SUIEditionMenuBar editionMenuBar;

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

    public void switchContentPane() {
        if (this.getContentPane() == this.rootPanel) {
            this.setContentPane(new EditionPanel(this, this.resourcePack));
            this.menuBar.getClose().setEnabled(true);
            this.menuBar.getOpen().setEnabled(false);
            this.repaint();
            this.revalidate();
            System.out.println("Changing pane to EDITION");
        }
        else {
            this.setContentPane(this.rootPanel);
            this.menuBar.getClose().setEnabled(false);
            this.menuBar.getOpen().setEnabled(true);
            this.repaint();
            this.revalidate();
            System.out.println("Changing pane to ROOT");
        }
    }

    private void menu() {
        this.menuBar = new ProjectMenuBar();
        this.menuBar.getOpen().addActionListener(this.loadResourcePack());
        this.menuBar.getClose().setEnabled(false);
        this.setJMenuBar(this.menuBar);
    }

    private File resourcePackPath() {
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.showOpenDialog(this);
        return filechooser.getSelectedFile();
    }

    private ActionListener loadResourcePack() {
        return actionEvent -> {
            FileResourcePackLoader fileResourcePackLoader = new FileResourcePackLoader();
            this.setResourcePack(fileResourcePackLoader.load(new File(this.resourcePackPath().getAbsolutePath()),
                    new FileResourcePackOptions(true)));
            this.switchContentPane();
        };
    }

    public ResourcePack getResourcePack() {
        return resourcePack;
    }

    public void setResourcePack(ResourcePack resourcePack) {
        this.resourcePack = resourcePack;
    }
}

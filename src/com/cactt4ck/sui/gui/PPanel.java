package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIRootMenuBar;
import fr.skytale.rpeditor.loaders.file.FileResourcePackLoader;
import fr.skytale.rpeditor.loaders.file.FileResourcePackOptions;
import fr.skytale.rpeditor.resourcepack.ResourcePack;
import fr.skytale.rpeditor.resourcepack.ResourcePackManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class PPanel extends JPanel {

    private JLabel title;
    private JButton button;
    private JSeparator separator;
    private JPanel titlePanel;
    private SUIRootMenuBar menuBar;
    private ResourcePack resourcePack;
    private final ResourcePackManager resourcePackManager;
    private PFrame rootFrame;

    public PPanel(PFrame rootFrame) {
        this.rootFrame = rootFrame;
        this.resourcePackManager = new ResourcePackManager();
        this.setLayout(new BorderLayout());
        this.init();
    }

    private void init() {
        this.title();
        //this.button();
        this.menu();
    }

    private void button() {
        this.button = new JButton("khfbsdjkfgv");
        this.add(this.button, BorderLayout.SOUTH);
    }

    private void title() {
        this.titlePanel = new JPanel(new BorderLayout());
        this.separator = new JSeparator();

        this.title = new JLabel("SkytaleUI");
        this.title.setFont(new Font("Monaco", Font.PLAIN, 52));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(this.titlePanel, BorderLayout.NORTH);
        this.titlePanel.add(this.title, BorderLayout.CENTER);
        this.titlePanel.add(this.separator, BorderLayout.SOUTH);
    }

    private void menu() {
        this.menuBar = new SUIRootMenuBar();
        this.menuBar.getOpen().addActionListener(this.loadResourcePack());
        this.titlePanel.add(this.menuBar, BorderLayout.NORTH);
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
            this.resourcePack = fileResourcePackLoader.load(new File(this.resourcePackPath().getAbsolutePath()), new FileResourcePackOptions(true));
            this.rootFrame.switchContentPane(Panels.EDITION);
        };
    }

}

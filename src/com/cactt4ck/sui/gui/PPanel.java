package com.cactt4ck.sui.gui;

import fr.skytale.rpeditor.loaders.file.FileResourcePackLoader;
import fr.skytale.rpeditor.resourcepack.ResourcePack;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PPanel extends JPanel {

    private JLabel title;
    private JButton button;
    private JSeparator separator;
    private JPanel titlePanel;
    private JMenuBar menuBar;
    private JMenu file, edit, help;
    private JMenuItem open, close, exit;
    private ResourcePack resourcePack;

    public PPanel() {
        this.setLayout(new BorderLayout());
        this.init();
    }

    private void init() {
        this.title();
        this.button();
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
        this.menuBar = new JMenuBar();

        this.file = new JMenu("File");
        this.edit = new JMenu("Edit");
        this.help = new JMenu("Help");

        this.open = new JMenuItem("Open");
        this.open.addActionListener(this.loadResourcePack());
        this.close = new JMenuItem("Close");
        JSeparator fileSeparator = new JSeparator(JSeparator.HORIZONTAL);
        this.exit = new JMenuItem("Exit");

        //-------------------------------------------------------------//

        this.file.add(this.open);
        this.file.add(this.close);
        this.file.add(fileSeparator);
        this.file.add(this.exit);

        this.menuBar.add(this.file);
        this.menuBar.add(this.edit);
        //this.menuBar.add(Box.createHorizontalGlue());
        this.menuBar.add(this.help);

        this.titlePanel.add(this.menuBar, BorderLayout.NORTH);
    }

    private File resourcePackPath() {
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.setFileFilter(new FileNameExtensionFilter("ZIP files", "zip"));
        filechooser.showOpenDialog(this);
        return filechooser.getSelectedFile();
    }

    private ActionListener loadResourcePack() {
        return actionEvent -> {
            FileResourcePackLoader fileResourcePackLoader = new FileResourcePackLoader();
            this.resourcePack = fileResourcePackLoader.load(new File(this.resourcePackPath().getAbsolutePath()), null);
        };
    }

}

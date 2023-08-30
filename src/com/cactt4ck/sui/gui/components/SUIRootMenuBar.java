package com.cactt4ck.sui.gui.components;

import com.cactt4ck.sui.gui.PPanel;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class SUIRootMenuBar extends JMenuBar {

    private final JMenu file, edit, help;
    private final JMenuItem open, close, exit;

    public SUIRootMenuBar() {

        this.file = new JMenu("File");
        this.edit = new JMenu("Edit");
        this.help = new JMenu("Help");

        this.open = new JMenuItem("Open");
        this.close = new JMenuItem("Close");
        JSeparator fileSeparator = new JSeparator(JSeparator.HORIZONTAL);
        this.exit = new JMenuItem("Exit");
        this.exit.addActionListener(e -> System.exit(1));

        //-------------------------------------------------------------//

        this.file.add(this.open);
        this.file.add(this.close);
        this.file.add(fileSeparator);
        this.file.add(this.exit);

        this.add(this.file);
        this.add(this.edit);
        this.add(this.help);
    }

    public JMenu getFile() {
        return file;
    }

    public JMenu getEdit() {
        return edit;
    }

    public JMenu getHelp() {
        return help;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public JMenuItem getClose() {
        return close;
    }

    public JMenuItem getExit() {
        return exit;
    }
}
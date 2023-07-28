package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIEditionMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditionPanel extends JPanel {

    private SUIEditionMenuBar menuBar;
    private PFrame rootFrame;

    public EditionPanel(PFrame rootFrame) {
        this.setLayout(new BorderLayout());
        this.rootFrame = rootFrame;
        this.init();
    }

    private void init() {
        this.menu();
    }

    private void menu() {
        this.menuBar = new SUIEditionMenuBar();
        this.menuBar.getCloseItem().addActionListener(this.closeProject());
        this.add(this.menuBar, BorderLayout.NORTH);
    }

    private ActionListener closeProject() {
        return actionEvent -> this.rootFrame.switchContentPane(Panels.ROOT);
    }
}

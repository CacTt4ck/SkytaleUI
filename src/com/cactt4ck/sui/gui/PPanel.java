package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIRootMenuBar;
import fr.skytale.rpeditor.loaders.file.FileResourcePackLoader;
import fr.skytale.rpeditor.loaders.file.FileResourcePackOptions;
import fr.skytale.rpeditor.resourcepack.ResourcePackManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class PPanel extends JPanel {

    private JLabel title;
    private JSeparator separator;
    private JPanel titlePanel;
    private final ResourcePackManager resourcePackManager;
    private final PFrame rootFrame;

    public PPanel(final PFrame rootFrame) {
        this.rootFrame = rootFrame;
        this.resourcePackManager = new ResourcePackManager();
        this.setLayout(new BorderLayout());
        this.init();
    }

    private void init() {
        this.title();
    }

    private void title() {
        this.titlePanel = new JPanel(new BorderLayout());
        this.separator = new JSeparator();

        this.title = new JLabel("Resource Pack Editor");
        this.title.setFont(new Font("Monaco", Font.PLAIN, 52));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(this.titlePanel, BorderLayout.NORTH);
        this.titlePanel.add(this.title, BorderLayout.CENTER);
        this.titlePanel.add(this.separator, BorderLayout.SOUTH);
    }

}

package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIEditionMenuBar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class EditionPanel extends JPanel {

    private SUIEditionMenuBar menuBar;
    private PFrame rootFrame;
    private JTree rpTree;
    private final File folder;

    public EditionPanel(PFrame rootFrame, File folder) {
        this.setLayout(new BorderLayout());
        this.rootFrame = rootFrame;
        this.folder = folder;
        this.init();
    }

    private void init() {
        this.menu();
        this.tree();
    }

    private void menu() {
        this.menuBar = new SUIEditionMenuBar();
        this.menuBar.getCloseItem().addActionListener(this.closeProject());
        this.add(this.menuBar, BorderLayout.NORTH);
    }

    private void tree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        this.createNodes(root, new File(this.folder.toURI()));
        this.rpTree = new JTree(new DefaultTreeModel(root));
        JScrollPane scrollPane = new JScrollPane(rpTree);
        this.add(scrollPane, BorderLayout.WEST);
    }

    // ---------------------------------------------------------------------- //

    private ActionListener closeProject() {
        return actionEvent -> this.rootFrame.switchContentPane(Panels.ROOT);
    }

    public void createNodes(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
            node.add(childNode);
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    createNodes(childNode, f);
                }
            }
        } else {
            node.add(new DefaultMutableTreeNode(file.getName()));
        }
    }
}

package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIEditionMenuBar;
import fr.skytale.rpeditor.resourcepack.ResourcePack;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class EditionPanel extends JPanel {

    private final JPanel rightPanel;
    private SUIEditionMenuBar menuBar;
    private PFrame rootFrame;
    private JTree rpTree;
    private final File folder;
    private final ResourcePack resourcePack;
    private final JSplitPane centerPanel;
    private JLabel rightPanelTitle;

    public EditionPanel(final PFrame rootFrame, ResourcePack resourcePack) {
        this.setLayout(new BorderLayout());
        this.centerPanel = new JSplitPane();

        this.rightPanel = new JPanel(new BorderLayout());
        this.centerPanel.setRightComponent(this.rightPanel);

        this.rootFrame = rootFrame;
        this.resourcePack = resourcePack;
        this.folder = this.resourcePack.getFolder();
        this.init();
    }

    private void init() {
        this.menu();
        this.tree();
        this.rightPanelComponents();
    }

    private void rightPanelComponents() {
        this.rightPanelTitle = new JLabel("Test");
        this.rightPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        this.rightPanel.add(this.rightPanelTitle, BorderLayout.NORTH);
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
        this.rpTree.addTreeSelectionListener(this.onClickTreeSelection());
        JScrollPane scrollPane = new JScrollPane(rpTree);

        this.centerPanel.setLeftComponent(scrollPane);

        this.add(this.centerPanel, BorderLayout.CENTER);
    }

    // ---------------------------------------------------------------------- //

    private ActionListener closeProject() {
        return e -> this.rootFrame.switchContentPane(Panels.ROOT);
    }

    private TreeSelectionListener onClickTreeSelection() {
        return e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) rpTree.getLastSelectedPathComponent();
            rightPanelTitle.setText(node.toString());
        };
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

package com.cactt4ck.sui.gui;

import com.cactt4ck.sui.gui.components.SUIEditionMenuBar;
import fr.skytale.rpeditor.resourcepack.ResourcePack;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class EditionPanel extends JPanel {

    private final JPanel rightPanel;
    private SUIEditionMenuBar menuBar;
    private PFrame rootFrame;
    private JTree rpTree;
    private final File folder;
    private File currentSelectedFile = null;
    private final ResourcePack resourcePack;
    private final JSplitPane centerPanel;
    private JLabel rightPanelTitle, rightPanelImage;

    public EditionPanel(final PFrame rootFrame, final ResourcePack resourcePack) {
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
        this.tree();
        this.rightPanelComponents();
    }

    private void rightPanelComponents() {
        this.rightPanelTitle = new JLabel("Test");
        this.rightPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        this.rightPanelImage = new JLabel(new ImageIcon(getClass().getResource("/assets/images/minecraft-icon-0.png")));

        this.rightPanel.add(this.rightPanelTitle, BorderLayout.NORTH);
        this.rightPanel.add(this.rightPanelImage, BorderLayout.CENTER);
    }

    private void tree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        this.createNodes(root, new File(this.folder.toURI()));
        this.rpTree = new JTree(new DefaultTreeModel(root));
        //this.rpTree.addTreeSelectionListener(this.onClickTreeSelection());
        this.rpTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // clic gauche
                super.mousePressed(e);
                int selectedRow = rpTree.getRowForLocation(e.getX(), e.getY());
                if (selectedRow == -1)
                    rpTree.clearSelection();

                TreePath selPath = rpTree.getPathForLocation(e.getX(), e.getY());
                DefaultMutableTreeNode node;
                if (selPath != null) {
                    node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
                    rightPanelTitle.setText(node.toString());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) { // clic droit
                super.mouseReleased(e);
                int selectedRow = rpTree.getRowForLocation(e.getX(), e.getY());
                if (selectedRow != -1)
                    if (e.isPopupTrigger()) {
                        JPopupMenu popupMenu = new JPopupMenu();
                        popupMenu.add("Je suis un");
                        popupMenu.add("Je suis deux");
                        popupMenu.add("Je suis trois");
                        popupMenu.add("Je suis quatre");
                        popupMenu.add("Je suis cinq");
                        popupMenu.show(rpTree, e.getX(), e.getY());
                    }
            }
        });
        JScrollPane scrollPane = new JScrollPane(rpTree);

        this.centerPanel.setLeftComponent(scrollPane);

        this.add(this.centerPanel, BorderLayout.CENTER);
    }

    // ---------------------------------------------------------------------- //

    private ActionListener closeProject() {
        return e -> this.rootFrame.switchContentPane();
    }

    private TreeSelectionListener onClickTreeSelection() {
        return e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) rpTree.getLastSelectedPathComponent();
            if (node == null)
                return;
            rightPanelTitle.setText(node.toString());

            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
            if (treeNode == null)
                return;
            String pathLog = this.folder.getPath();

            String[] splitted = pathLog.split("\\\\");
            String newString = "";
            for (int i = 0; i < splitted.length - 1; i++)
                newString += splitted[i] + "/";
            newString = newString.substring(0, newString.length() - 1);;
            for (TreeNode childNode : treeNode.getPath())
                newString += childNode.toString() + "/";

            this.currentSelectedFile = new File(newString);
            String filePath = this.currentSelectedFile.getPath();
            System.out.println(filePath);

            this.rightPanelImage.setIcon(new ImageIcon(this.currentSelectedFile.getPath()));
            this.rightPanel.repaint();
        };
    }

    public void createNodes(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
            node.add(childNode);
            File[] files = file.listFiles();
            if (files != null)
                for (File f : files)
                    createNodes(childNode, f);
        } else
            node.add(new DefaultMutableTreeNode(file.getName()));
    }

}

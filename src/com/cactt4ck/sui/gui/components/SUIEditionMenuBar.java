package com.cactt4ck.sui.gui.components;

import javax.swing.*;

public class SUIEditionMenuBar extends JMenuBar {

    /* Menus */
    private final JMenu fileMenu, actionMenu, helpMenu;

    /* Sub-Menus */
    private final JMenu modelSubMenu, categorySubMenu, textureSubMenu;
    private final JMenuItem closeItem,
            addModelItem, deleteModelItem, getInfoModelItem,
            addCategoryItem, removeCategoryItem, listCategoryItem,
            checkTextureItem, sharedTextureItem;

    public SUIEditionMenuBar() {
        this.fileMenu = new JMenu("File");
        this.closeItem = new JMenuItem("Close");
        this.fileMenu.add(this.closeItem);

        // ------------------------------------------------ //

        this.actionMenu = new JMenu("Action");

        this.modelSubMenu = new JMenu("Model");
        this.addModelItem = new JMenuItem("Add");
        this.deleteModelItem = new JMenuItem("Delete");
        this.getInfoModelItem = new JMenuItem("Get info");

        this.categorySubMenu = new JMenu("Category");
        this.addCategoryItem = new JMenuItem("Add");
        this.removeCategoryItem = new JMenuItem("Remove");
        this.listCategoryItem = new JMenuItem("List");

        this.textureSubMenu = new JMenu("Texture");
        this.checkTextureItem = new JMenuItem("Check");
        this.sharedTextureItem = new JMenuItem("Shared");

        // ------------------------------------------------ //

        this.helpMenu = new JMenu("Help");

        // ------------------------------------------------ //

        this.modelSubMenu.add(this.addModelItem);
        this.modelSubMenu.add(this.deleteModelItem);
        this.modelSubMenu.add(this.getInfoModelItem);

        this.categorySubMenu.add(this.addCategoryItem);
        this.categorySubMenu.add(this.removeCategoryItem);
        this.categorySubMenu.add(this.listCategoryItem);

        this.textureSubMenu.add(this.checkTextureItem);
        this.textureSubMenu.add(this.sharedTextureItem);

        // ------------------------------------------------ //

        this.actionMenu.add(this.modelSubMenu);
        this.actionMenu.add(this.categorySubMenu);
        this.actionMenu.add(this.textureSubMenu);

        // ------------------------------------------------ //

        this.add(fileMenu);
        this.add(actionMenu);
        this.add(helpMenu);
    }

    public JMenu getFileMenu() {
        return this.fileMenu;
    }

    public JMenu getActionMenu() {
        return this.actionMenu;
    }

    public JMenu getHelpMenu() {
        return this.helpMenu;
    }

    public JMenu getModelSubMenu() {
        return this.modelSubMenu;
    }

    public JMenu getCategorySubMenu() {
        return this.categorySubMenu;
    }

    public JMenu getTextureSubMenu() {
        return this.textureSubMenu;
    }

    public JMenuItem getCloseItem() {
        return this.closeItem;
    }

    public JMenuItem getAddModelItem() {
        return this.addModelItem;
    }

    public JMenuItem getDeleteModelItem() {
        return this.deleteModelItem;
    }

    public JMenuItem getGetInfoModelItem() {
        return this.getInfoModelItem;
    }

    public JMenuItem getAddCategoryItem() {
        return this.addCategoryItem;
    }

    public JMenuItem getRemoveCategoryItem() {
        return this.removeCategoryItem;
    }

    public JMenuItem getListCategoryItem() {
        return this.listCategoryItem;
    }

    public JMenuItem getCheckTextureItem() {
        return this.checkTextureItem;
    }

    public JMenuItem getSharedTextureItem() {
        return this.sharedTextureItem;
    }
}

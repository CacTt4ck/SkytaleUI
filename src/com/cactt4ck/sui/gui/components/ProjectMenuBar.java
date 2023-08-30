package com.cactt4ck.sui.gui.components;

import com.cactt4ck.sui.Main;
import com.cactt4ck.sui.utils.Utils;
import de.milchreis.uibooster.UiBooster;

import javax.swing.*;
import java.io.File;

public class ProjectMenuBar extends JMenuBar {

    private JPanel currentPane;
    private final JMenu file, edit, help;
    private final JMenuItem open, close, exit;
    private final JMenu modelSubMenu, categorySubMenu, textureSubMenu;
    private final JMenuItem addModelItem, deleteModelItem, getInfoModelItem,
            addCategoryItem, removeCategoryItem, listCategoryItem,
            checkTextureItem, sharedTextureItem;
    private final JMenuItem changeTheme;

    public ProjectMenuBar() {
        this.file = new JMenu("File");
        this.edit = new JMenu("Edit");
        this.help = new JMenu("Help");

        this.open = new JMenuItem("Open");
        this.close = new JMenuItem("Close");
        JSeparator fileSeparator = new JSeparator(JSeparator.HORIZONTAL);

        this.exit = new JMenuItem("Exit");
        this.exit.addActionListener(e -> System.exit(0));

        this.file.add(this.open);
        this.file.add(this.close);
        this.file.add(fileSeparator);
        this.file.add(this.exit);

        //-------------------------------------------------------------//

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

        this.modelSubMenu.add(this.addModelItem);
        this.modelSubMenu.add(this.deleteModelItem);
        this.modelSubMenu.add(this.getInfoModelItem);

        this.categorySubMenu.add(this.addCategoryItem);
        this.categorySubMenu.add(this.removeCategoryItem);
        this.categorySubMenu.add(this.listCategoryItem);

        this.textureSubMenu.add(this.checkTextureItem);
        this.textureSubMenu.add(this.sharedTextureItem);

        this.edit.add(this.modelSubMenu);
        this.edit.add(this.categorySubMenu);
        this.edit.add(this.textureSubMenu);

        //-------------------------------------------------------------//

        this.changeTheme = new JMenuItem("Change theme");
        this.changeTheme.addActionListener(e -> new UiBooster().showConfirmDialog(
                "Changer de theme entraine un redémarrage de l'application !",
                "Voulez-vous redémarrer ?",
                () -> {
                    if (Main.CONFIG.getProperty("theme").equalsIgnoreCase("dark"))
                        Main.CONFIG.setProperty("theme", "light");
                    else
                        Main.CONFIG.setProperty("theme", "dark");
                    Main.CONFIG.saveConfig();
                    Utils.restartApp();
                },
                null)
        );
        this.help.add(changeTheme);

        this.add(this.file);
        this.add(this.edit);
        this.add(this.help);
    }

    // ************************************************************************************** //

    public JPanel getCurrentPane() {
        return currentPane;
    }

    public void setCurrentPane(JPanel currentPane) {
        this.currentPane = currentPane;
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

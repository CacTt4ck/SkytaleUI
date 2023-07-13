package com.cactt4ck.sui.gui;

import javax.swing.*;
import java.awt.*;

public class PPanel extends JPanel {

    private JLabel title;
    private JButton button;

    public PPanel() {
        this.setLayout(new BorderLayout());
        this.init();
    }

    private void init() {
        this.title();
        this.button();
    }

    private void button() {
        this.button = new JButton("khfbsdjkfgv");
        this.add(this.button, BorderLayout.SOUTH);
    }

    private void title() {
        this.title = new JLabel("SkytaleUI");
        this.title.setFont(new Font("Monaco", Font.PLAIN, 52));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.title, BorderLayout.NORTH);
    }
}

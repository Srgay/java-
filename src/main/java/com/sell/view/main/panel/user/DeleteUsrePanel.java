package com.sell.view.main.panel.user;

import javax.swing.*;

public class DeleteUsrePanel {
    public  JPanel getPanel() {
        JPanel panel_2 = new JPanel();

        JButton button = new JButton("New button");
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
                gl_panel_2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(100)
                                .addComponent(button)
                                .addContainerGap(583, Short.MAX_VALUE))
        );
        gl_panel_2.setVerticalGroup(
                gl_panel_2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_2.createSequentialGroup()
                                .addGap(157)
                                .addComponent(button)
                                .addContainerGap(255, Short.MAX_VALUE))
        );
        panel_2.setLayout(gl_panel_2);
        return panel_2;
    }
}

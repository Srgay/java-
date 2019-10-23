package com.sell.view.main.panel.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserPanel  {
    public JPanel getPanel(){
        JPanel panel_11 = new JPanel();
        panel_11.setOpaque(false);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setBackground(Color.RED);

        JTextPane textPane = new JTextPane();

        JLabel label = new JLabel("New label");
        label.setForeground(Color.RED);
        label.setBackground(Color.RED);

        JTextPane textPane_1 = new JTextPane();

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GroupLayout gl_panel_11 = new GroupLayout(panel_11);
        gl_panel_11.setHorizontalGroup(
                gl_panel_11.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_11.createSequentialGroup()
                                .addGap(160)
                                .addComponent(lblNewLabel_1)
                                .addGap(36)
                                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addGap(74)
                                .addComponent(label)
                                .addGap(44)
                                .addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel_11.createSequentialGroup()
                                .addGap(117)
                                .addComponent(btnNewButton))
        );
        gl_panel_11.setVerticalGroup(
                gl_panel_11.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_11.createSequentialGroup()
                                .addGap(99)
                                .addGroup(gl_panel_11.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panel_11.createSequentialGroup()
                                                .addGap(6)
                                                .addComponent(lblNewLabel_1))
                                        .addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel_11.createSequentialGroup()
                                                .addGap(6)
                                                .addComponent(label))
                                        .addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(98)
                                .addComponent(btnNewButton))
        );
        panel_11.setLayout(gl_panel_11);
        return panel_11;
    }
}

package com.sell.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class ImageFrame extends JFrame {

    public ImageFrame() {

        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\Pictures\\vlcsnap-2019-06-08-10h42m45s483 (2).png"));
        {
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            JMenu mnNewMenu = new JMenu("用户管理");
            menuBar.add(mnNewMenu);

            JMenuItem mntmNewMenuItem_1 = new JMenuItem("添加用户");
            mnNewMenu.add(mntmNewMenuItem_1);

            JMenuItem menuItem_14 = new JMenuItem("删除用户");
            mnNewMenu.add(menuItem_14);

            JMenuItem mntmNewMenuItem_3 = new JMenuItem("修改用户");
            mnNewMenu.add(mntmNewMenuItem_3);

            JMenuItem mntmNewMenuItem = new JMenuItem("查询用户");
            mnNewMenu.add(mntmNewMenuItem);

            JMenu mnNewMenu_1 = new JMenu("库存管理");
            menuBar.add(mnNewMenu_1);

            JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
            mnNewMenu_1.add(mntmNewMenuItem_5);

            JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
            mnNewMenu_1.add(mntmNewMenuItem_4);

            JMenu menu = new JMenu("进货管理");
            menuBar.add(menu);

            JMenuItem menuItem = new JMenuItem("新增库存");
            menu.add(menuItem);

            JMenuItem menuItem_2 = new JMenuItem("删除库存");
            menu.add(menuItem_2);

            JMenuItem menuItem_3 = new JMenuItem("New menu item");
            menu.add(menuItem_3);

            JMenuItem menuItem_4 = new JMenuItem("New menu item");
            menu.add(menuItem_4);

            JMenu menu_2 = new JMenu("销售管理");
            menuBar.add(menu_2);

            JMenuItem menuItem_5 = new JMenuItem("New menu item");
            menu_2.add(menuItem_5);

            JMenu menu_3 = new JMenu("New menu");
            menu_2.add(menu_3);

            JMenuItem menuItem_6 = new JMenuItem("New menu item");
            menu_3.add(menuItem_6);

            JMenuItem menuItem_7 = new JMenuItem("New menu item");
            menu_2.add(menuItem_7);

            JMenuItem menuItem_8 = new JMenuItem("New menu item");
            menu_2.add(menuItem_8);

            JMenuItem menuItem_9 = new JMenuItem("New menu item");
            menu_2.add(menuItem_9);

            JMenu menu_1 = new JMenu("系统退出");
            menuBar.add(menu_1);

            JMenuItem menuItem_1 = new JMenuItem("New menu item");
            menu_1.add(menuItem_1);

            JMenu menu_4 = new JMenu("New menu");
            menu_1.add(menu_4);

            JMenuItem menuItem_10 = new JMenuItem("New menu item");
            menu_4.add(menuItem_10);

            JMenuItem menuItem_11 = new JMenuItem("New menu item");
            menu_1.add(menuItem_11);

            JMenuItem menuItem_12 = new JMenuItem("New menu item");
            menu_1.add(menuItem_12);

            JMenuItem menuItem_13 = new JMenuItem("New menu item");
            menu_1.add(menuItem_13);
        }
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 781, 440);
        getContentPane().add(panel);
        getContentPane().remove(panel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setBackground(Color.RED);

        JTextPane textPane = new JTextPane();

        JLabel label = new JLabel("New label");
        label.setVisible(false);
        label.setForeground(Color.RED);
        label.setBackground(Color.RED);

        JTextPane textPane_1 = new JTextPane();

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(117)
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(btnNewButton)
                                        .addComponent(lblNewLabel_1))
                                .addGap(36)
                                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addGap(74)
                                .addComponent(label)
                                .addGap(44)
                                .addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(99)
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label)
                                        .addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1))
                                .addGap(98)
                                .addComponent(btnNewButton)
                                .addContainerGap(191, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\pc\\Pictures\\vlcsnap-2019-06-08-10h42m45s483 (2).png"));
        lblNewLabel.setText("");
        lblNewLabel.setBounds(0, 0, 865, 657);
        getContentPane().add(lblNewLabel);
    }


    public static void main(String[] args) {
        JFrame aFrame = new ImageFrame();
        aFrame.setSize(800, 400);

        aFrame.setVisible(true);
    }
}
package com.sell.view;


import com.sell.view.main.panel.user.AddUserPanel;
import com.sell.view.main.panel.user.DeleteUsrePanel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class mainFrame extends JFrame {

    public mainFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/a2.jpg"));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("用户管理");
        mnNewMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });
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
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 781, 440);
        panel.setOpaque(false);
        getContentPane().add(panel);





        JPanel panel_3 = new JPanel();

        JPanel panel_4 = new JPanel();

        JPanel panel_5 = new JPanel();

        JPanel panel_6 = new JPanel();

        JPanel panel_7 = new JPanel();

        JPanel panel_8 = new JPanel();

        JPanel panel_9 = new JPanel();

        JPanel panel_10 = new JPanel();
        panel.setLayout(new CardLayout(0, 0));
        panel.add(AddUserPanel.getPanel(), "name_8513494725000");
        panel.add(DeleteUsrePanel.getPanel(), "name_8513524280699");
        panel.add(panel_3, "name_8513542176600");
        panel.add(panel_4, "name_8513560689000");
        panel.add(panel_5, "name_8513580187199");
        panel.add(panel_6, "name_8513597671100");
        panel.add(panel_7, "name_8513615657400");
        panel.add(panel_8, "name_8513663372100");
        panel.add(panel_9, "name_8513678796700");
        panel.add(panel_10, "name_8513696449900");

        JLabel lblNewLabel = new JLabel(new ImageIcon("img/a2.jpg"));
        lblNewLabel.setText("");
        lblNewLabel.setBounds(0, 0, 865, 657);
        getContentPane().add(lblNewLabel);
    }
    public static void main(String[] args) {
        JFrame aFrame = new mainFrame();
        aFrame.setSize(1021, 600);
        aFrame.setLocationRelativeTo(null);
        aFrame.setVisible(true);
    }
}
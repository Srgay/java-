package com.sell.view;


import com.sell.view.main.actionPerformed.MainAction;
import com.sell.view.main.panel.buy.BuyPanel;
import com.sell.view.main.panel.order.OrderPanel;
import com.sell.view.main.panel.stock.StockPanel;
import com.sell.view.main.panel.user.UserPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Component
public class MainFrame extends JFrame implements ActionListener {

    private JMenuItem menuItem_11, menuItem_12, menuItem_13, menuItem_14,
            menuItem_21, menuItem_22,
            menuItem_31, menuItem_32, menuItem_33, menuItem_34,
            menuItem_51, menuItem_52, menuItem_53;
    private JPanel panel;
    @Autowired
    private MainAction mainAction;
    @Autowired
    private UserPanel userPanel;
    @Autowired
    private BuyPanel buyPanel;
    @Autowired
    private StockPanel stockPanel;
    @Autowired
    private OrderPanel orderPanel;

    public MainFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/a2.jpg"));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure closing this software?", "warning", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("用户管理");
        menuBar.add(mnNewMenu);

        menuItem_11 = new JMenuItem("添加用户");
        mnNewMenu.add(menuItem_11);
        menuItem_11.addActionListener(this);


        JMenu mnNewMenu_1 = new JMenu("商品销售");
        menuBar.add(mnNewMenu_1);

        menuItem_21 = new JMenuItem("商品销售");
        mnNewMenu_1.add(menuItem_21);
        menuItem_21.addActionListener(this);


        JMenu menu = new JMenu("进货管理");
        menuBar.add(menu);

        menuItem_31 = new JMenuItem("进货管理1");
        menu.add(menuItem_31);
        menuItem_31.addActionListener(this);


        JMenu menu_2 = new JMenu("订单管理");
        menuBar.add(menu_2);

        menuItem_51 = new JMenuItem("订单管理");
        menu_2.add(menuItem_51);
        menuItem_51.addActionListener(this);


        getContentPane().setLayout(null);

        //放置菜单功能的容器
        panel = new JPanel();
        panel.setBounds(0, 0, 1024, 600);
        panel.setOpaque(false);
        getContentPane().add(panel);

        panel.setLayout(new CardLayout(0, 0));

        //背景图片
        JLabel lblNewLabel = new JLabel(new ImageIcon("img/a2.png"));
        lblNewLabel.setText("");
        lblNewLabel.setBounds(0, 0, 1024, 600);
        getContentPane().add(lblNewLabel);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem_11) {
            mainAction.action(panel, userPanel.getPanel());
        }
        if (e.getSource() == menuItem_21) {
            mainAction.action(panel, buyPanel.getPanel());
        }
        if (e.getSource() == menuItem_31) {
            mainAction.action(panel, stockPanel.getPanel());
        }
        if (e.getSource() == menuItem_51) {
            mainAction.action(panel, orderPanel.getPanel());
        }
       /* if (e.getSource() == menuItem_11) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_12) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_13) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_14) {
            mainAction.action(panel, queryUserPanel.getPanel());
        }

        if (e.getSource() == menuItem_21) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_22) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_23) {
            mainAction.action(panel, .getPanel());
        }

        if (e.getSource() == menuItem_31) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_32) {
            mainAction.action(panel, .getPanel());
        }

        if (e.getSource() == menuItem_41) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_42) {
            mainAction.action(panel, .getPanel());
        }
        if (e.getSource() == menuItem_43) {
            mainAction.action(panel, .getPanel());
        }

        */


    }

    public static void main(String[] args) {
        JFrame aFrame = new MainFrame();
        aFrame.setSize(1021, 600);
        aFrame.setLocationRelativeTo(null);
        aFrame.setVisible(true);
    }
}
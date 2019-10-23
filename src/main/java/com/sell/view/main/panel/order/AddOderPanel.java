package com.sell.view.main.panel.order;

import javax.swing.*;

public class AddOderPanel {
    private JLabel nameLabel, passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton, registButton;

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        nameLabel = new JLabel("用户名 :");
        nameField = new JTextField(24);
        passwordLabel = new JLabel("  密码 :");
        passwordField = new JPasswordField(18);
        loginButton = new JButton("登录");
        registButton = new JButton("注册");

        //内容窗格默认布局管理器是FlowLayout
        panel.setLayout(null);
        panel.add(nameLabel).setBounds(40, 40, 80, 30);
        panel.add(nameField).setBounds(100, 40, 80, 30);
        panel.add(passwordLabel).setBounds(40, 100, 80, 30);
        panel.add(passwordField).setBounds(100, 100, 80, 30);
        panel.add(loginButton).setBounds(40, 160, 60, 25);
        panel.add(registButton).setBounds(120, 160, 60, 25);

        return panel;
    }
}

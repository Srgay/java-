package com.sell.view.main.panel.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class AddOrderPanel {
    private  JLabel nameLabel, passwordLabel;
    private   JTextField nameField;
    private   JPasswordField passwordField;
    private  JButton Button, registButton;
    private  JPanel contentPane;
    private   JTextField textField;
    private   JTextField textField_1;
    private  JTextField textField_2;
    private  JTextField textField_3;
    public  JPanel getPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("属性一");
        JLabel label = new JLabel("属性二");

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        Button=new JButton();

        panel.add(textField).setBounds(40, 40, 80, 30);
        panel.add(textField_1).setBounds(100, 40, 80, 30);
        panel.add(Button).setBounds(40, 160, 60, 25);
        panel.setOpaque(true);



        return panel;
    }
}

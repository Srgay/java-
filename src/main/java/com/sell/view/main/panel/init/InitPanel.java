package com.sell.view.main.panel.init;

import com.sell.view.main.actionPerformed.MainAction;
import com.sell.view.main.panel.buy.BuyPanel;
import com.sell.view.main.panel.buy.util.SettUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class InitPanel {

    private JTable cartTable, buyTable;
    private JButton jb_add, sett_add;
    private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5;
    private JPanel panel_11;
    private JLabel sett;
    @Autowired
    private SettUtil settutil;
    @Autowired
    private MainAction mainAction;
    @Autowired
    private JPanel mainPanel;
    @Autowired
    private BuyPanel buyPanel;

    public JPanel getPanel() {
        panel_11 = new JPanel();
        cartTable = new JTable();
        buyTable = new JTable();
        jb_add = new JButton();

        //主界面
        panel_11.setLayout(null);
        panel_11.setOpaque(false);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(450, 0, 66, 21);
        panel_11.add(lblNewLabel);
        //查询子模块
        querypanel();
        return panel_11;
    }


    public void querypanel() {

        jb_add = new JButton("查询");
        jb_add.setBounds(250+270 + 102, 25 + 50, 66, 21);
        panel_11.add(jb_add);

        textField = new JTextField();
        textField.setBounds(250 + 60, 25 + 50, 266, 21);
        panel_11.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel(new ImageIcon("img/search.png"));
        lblNewLabel.setBounds(250 + 40, 25 + 50, 20, 21);
        panel_11.add(lblNewLabel);


        jb_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mainAction.action(mainPanel, buyPanel.getPanel());
            }
        });
        panel_11.add(jb_add);
    }
    public String getname(){
        return textField.getText();
    }

}


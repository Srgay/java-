package com.sell.view.main.actionPerformed;

import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
public class MainAction {
    public void action(JPanel panel,JPanel panelto) {
        System.out.println("用户面板添加");
        System.out.println(panelto);
        panel.removeAll();
        panelto.setOpaque(false);
        panel.add(panelto);
        panel.validate();
        panel.repaint();
    }
}
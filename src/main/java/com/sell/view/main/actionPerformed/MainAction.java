package com.sell.view.main.actionPerformed;

import com.sell.view.main.panel.order.AddOrderPanel;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
public class MainAction {
    public void action(JPanel panel,JPanel panelto) {
        System.out.println("用户面板添加");
        System.out.println(panelto);
        panel.removeAll();
        panel.add(panelto);
        panel.validate();
        panel.repaint();
    }
}
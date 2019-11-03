package com.sell.view.main.panel.buy.util;

import com.sell.entity.Orderr;
import com.sell.entity.Stock;
import com.sell.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.Calendar;

@Component
public class SettUtil {
    private JTable cartTable, buyTable;
    private JLabel sett;
    @Autowired
    private StockService stockService;
    private Object Exception;

    public void updateTotal() {
        Integer total = 0;
        for (int i = 0; i < buyTable.getRowCount(); i++) {
            String name = (String) buyTable.getValueAt(i, 0);
            Integer number = Integer.valueOf((String) buyTable.getValueAt(i, 1));
            for (int j = 0; j < cartTable.getRowCount(); j++) {
                if (cartTable.getValueAt(j, 1).equals(name)) {
                    total += Integer.valueOf((String) cartTable.getValueAt(j, 3)) * number;
                    break;
                }
            }
        }
        sett.setText(String.valueOf(total));
    }

    @Transactional
    public Orderr addorder(){
        Orderr order = new Orderr();
        String id = String.valueOf(Calendar.getInstance().getTimeInMillis());
        StringBuffer item = new StringBuffer();
        for (int i = 0; i < buyTable.getRowCount(); i++) {
            String name = (String) buyTable.getValueAt(i, 0);
            String number = (String) buyTable.getValueAt(i, 1);
            String sid = null,price = null,newstock=null;
           /* for (int j = 0; j < cartTable.getRowCount(); j++) {
                if (cartTable.getValueAt(j, 1).equals(name)) {
                    sid = (String) cartTable.getValueAt(j, 0);
                   newstock=(String) cartTable.getValueAt(j,2);
                    price=(String) cartTable.getValueAt(j,3);
                    break;
                }
            }*/
            sid =stockService.queryOne(new Stock(null,name,null,null)).getId();
            newstock=String.valueOf(stockService.queryOne(new Stock(null,name,null,null)).getStock()-Integer.valueOf(number));
            price=stockService.queryOne(new Stock(null,name,null,null)).getPrice();
            Stock stock=new Stock(sid,name,Integer.valueOf(newstock),price);
            stockService.update(stock);
            item.append(name + "*" + number);
            if (i != buyTable.getSelectedRow() - 2) {
                item.append("，");
            }
        }
        order.setId(id);
        order.setItem(item.toString());
        return order;
    }

    public JTable getCartTable() {
        return cartTable;
    }

    public void setCartTable(JTable cartTable) {
        this.cartTable = cartTable;
    }

    public JTable getBuyTable() {
        return buyTable;
    }

    public void setBuyTable(JTable buyTable) {
        this.buyTable = buyTable;
    }

    public JLabel getSett() {
        return sett;
    }

    public void setSett(JLabel sett) {
        this.sett = sett;
    }
}

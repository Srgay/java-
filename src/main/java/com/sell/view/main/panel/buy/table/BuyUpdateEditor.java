package com.sell.view.main.panel.buy.table;


import com.sell.entity.Stock;
import com.sell.service.UserService;
import com.sell.view.main.panel.buy.BuyPanel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 自定义一个往列里边添加按钮的单元格编辑器。最好继承DefaultCellEditor，不然要实现的方法就太多了。
 */
@org.springframework.stereotype.Component
public class BuyUpdateEditor extends DefaultCellEditor implements ActionListener {
    /**
     * serialVersionUID
     */
    @Autowired
    private UserService userService;
    private static final long serialVersionUID = -6546334664166791132L;
    @Autowired
    private BuyPanel buyPanel;
    private JPanel panel;
    private  JPanel panel_11;

    private JButton button;
    private JTable cartTable,buyTable;

    public BuyUpdateEditor() {
        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。
        super(new JTextField());
        this.cartTable = cartTable;
        // 设置点击几次激活编辑。
        this.setClickCountToStart(1);

        this.initButton();

        this.initPanel();

        // 添加按钮。
        this.panel.add(this.button);
    }

    private void initButton() {
        this.button = new JButton();

        // 设置按钮的大小及位置。
        this.button.setBounds(0, 0, 150, 25);
        this.button.addActionListener(this);


    }

    private void initPanel() {
        this.panel = new JPanel();

        // panel使用绝对定位，这样button就不会充满整个单元格。
        this.panel.setLayout(null);
    }


    /**
     * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格）
     */
    @Override
    public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, int row, int column) {
        // 只为按钮赋值即可。也可以作其它操作。
        this.button.setText("增加");
        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。

        return this.panel;
    }

    /**
     * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。
     */
    @Override
    public Object getCellEditorValue() {
        return this.button.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            action();
        }
    }

    private int action() {
        // 触发取消编辑的事件，不会调用tableModel的setValue方法。
        //MyButtonEditor.this.fireEditingCanceled();
        int rowb = buyTable.getSelectedRow();
        Stock stock = getObject(rowb);
        System.out.println("增加数量" + stock.toString());
        DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        DefaultTableModel dtb = (DefaultTableModel) buyTable.getModel();

        //减少数量

        for (int i = 0; i < cartTable.getRowCount(); i++) {
            String aa = (String) cartTable.getValueAt(i, 1);
            if (stock.getName().equals(aa)) {
                if(Integer.valueOf((String) cartTable.getValueAt(i, 2))<1){
                    JOptionPane.showMessageDialog(null, "库存不足");
                }else{
                    cartTable.setValueAt(String.valueOf(Integer.valueOf((String)cartTable.getValueAt(i, 2)) -1), i, 2);
                    buyTable.setValueAt(String.valueOf(stock.getStock() +1), rowb, 1);
                    dtb.fireTableStructureChanged();
                    buyPanel.sin();
                }

                break;
            }
        }
        return 1;
    }

    public Stock getObject(int row) {
        int a=row;
        Stock stock = new Stock(null, (String) buyTable.getValueAt(row, 0), Integer.valueOf((String) buyTable.getValueAt(row, 1)),(String) buyTable.getValueAt(row, 2));
        return stock;
    }
    public void settable(JTable table) {
        this.cartTable = table;
    }
    public void setPanel(JPanel panel) {
        this.panel_11 = panel;
    }
    public void setbtable(JTable table) {
        this.buyTable = table;
    }
}

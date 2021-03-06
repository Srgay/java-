package com.sell.view.main.panel.buy.table;

import com.sell.entity.Stock;
import com.sell.service.OrderService;
import com.sell.view.main.panel.buy.BuyPanel;
import com.sell.view.main.panel.buy.util.SettUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

@org.springframework.stereotype.Component
public class BuyAddEditor extends DefaultCellEditor implements ActionListener {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6546334664166791132L;

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyPanel buyPanel;
    @Autowired
    private SettUtil settUtil;

    private JPanel panel;

    private JButton button;
    private JTable cartTable, buyTable;

    public BuyAddEditor() {
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
        this.button.setText("添加");
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
        Stock stock = getObject(cartTable.getSelectedRow());
        System.out.println("添加" + stock.toString());
        DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        DefaultTableModel dtb = (DefaultTableModel) buyTable.getModel();
        int row = cartTable.getSelectedRow();
       /* dtm.removeRow(row);
        dtm.fireTableRowsDeleted(0,cartTable.getRowCount());*/
        Integer st=Integer.valueOf((String) cartTable.getValueAt(row,2));
        if (st<1) {
            //若库存不足，提示用户
            JOptionPane.showMessageDialog(null, "库存不足");
            return 1;
        } else {
            //若库存够，则添加
            Vector re = new Vector();
            re.add(cartTable.getValueAt(row, 1));
            re.add("1");
            for (int i = 0; i < buyTable.getRowCount(); i++) {
                String aa = (String) buyTable.getValueAt(i, 0);
                if (re.get(0).equals(aa)) {
                    buyTable.setValueAt(String.valueOf(Integer.valueOf((String)buyTable.getValueAt(i, 1)) + 1), i, 1);
                    cartTable.setValueAt(String.valueOf(st-1),row,2);
                    //dtm.fireTableRowsUpdated(0,cartTable.getRowCount());
                    settUtil.updateTotal();
                    return 1;
                }
            }
            dtm.setValueAt(String.valueOf(st-1),row,2);
            dtm.fireTableRowsUpdated(0,cartTable.getRowCount());
            dtb.addRow(re);
            dtb.fireTableRowsDeleted(0, buyTable.getRowCount());
            settUtil.updateTotal();
        }
        return 1;
    }

    public Stock getObject(int row) {
        String[] val = new String[4];
        for (int i = 0; i < 4; i++) {
            val[i] = (String) cartTable.getValueAt(row, i);
        }
        Stock stock = new Stock(val[0], val[1], Integer.valueOf(val[2]),val[3]);
        return stock;
    }

    public void settable(JTable table) {
        this.cartTable = table;
    }

    public void setbtable(JTable table) {
        this.buyTable = table;
    }
}


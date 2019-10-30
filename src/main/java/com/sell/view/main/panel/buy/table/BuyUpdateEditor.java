package com.sell.view.main.panel.buy.table;


import com.sell.entity.Buyer;
import com.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
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

    private JPanel panel;

    private JButton button;
    private JTable cartTable;

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
        this.button.setText("修改");
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

    private void action() {
        // 触发取消编辑的事件，不会调用tableModel的setValue方法。
        //MyButtonEditor.this.fireEditingCanceled();
        Buyer user = getObject(cartTable.getSelectedRow());
        System.out.println("修改"+user.toString());
        userService.update(user);
        // 这里可以做其它操作。
        // 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。

    }

    public Buyer getObject(int row) {
        String[] val = new String[7];
        for (int i = 0; i < 7; i++) {
            val[i] = (String) cartTable.getValueAt(row, i);
        }
        Buyer user = new Buyer(val[0], val[1], val[2], Integer.valueOf(val[3]), val[4], val[5], val[6]);
        return user;
    }

    public void settable(JTable table) {
        this.cartTable = table;
    }
}

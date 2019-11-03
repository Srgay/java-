package com.sell.view.main.panel.order;

import com.sell.entity.Orderr;
import com.sell.service.OrderService;
import com.sell.util.otov;
import com.sell.view.main.panel.order.table.OrderDeleteEditor;
import com.sell.view.main.panel.order.table.OrderDeleteRender;
import com.sell.view.main.panel.order.table.OrderUpdateEditor;
import com.sell.view.main.panel.order.table.OrderUpdateRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Component
public class OrderPanel {

    private JTable cartTable;
    private JButton jb_add;
    private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5;
    private  JPanel panel_11;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderUpdateEditor orderUpdateEditor;
    @Autowired
    private OrderUpdateRender orderUpdateRender;
    @Autowired
    private OrderDeleteEditor orderDeleteEditor;
    @Autowired
    private OrderDeleteRender orderDeleteRender;


    public JPanel getPanel() {
        panel_11 = new JPanel();
        cartTable = new JTable();
        jb_add = new JButton();

        //主界面
        panel_11.setLayout(null);
        panel_11.setOpaque(true);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 66, 21);
        panel_11.add(lblNewLabel);
        //表格显示子模块
        try {
            initjtable();
        }catch (java.lang.IndexOutOfBoundsException e1){
            JOptionPane.showMessageDialog(panel_11, "未查询到任何订单", "警告",JOptionPane.WARNING_MESSAGE);

        }

        //查询子模块
        querypanel();


        return panel_11;
    }

    public void initjtable(){
        String[] res1;
        String[][] res;
        List l = orderService.queryAll();
        int m,n;
        try {
            m = l.size();
            n = otov.tov(l.get(0)).size();
        }catch (java.lang.IndexOutOfBoundsException e1){
            m=0;n=0;
        }
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i]=java.util.Arrays.copyOf(arr1,arr1.length+2);
            res[i][0]=arr1[2];
            res[i][1]=arr1[0];
            res[i][2]=arr1[1];
            res[i][arr1.length]="0";
            res[i][arr1.length+1]="0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1=java.util.Arrays.copyOf(arr1,arr1.length+2);
        res1[0]=arr1[2];
        res1[1]=arr1[0];
        res1[2]=arr1[1];
        res1[arr1.length]="0";
        res1[arr1.length+1]="0";

        cartTable.setModel(new DefaultTableModel(res,res1) {


            @Override
            public void setValueAt(Object aValue, int row, int column) {
                System.out.println(aValue + "  setValueAt");
                Vector<Object> rowVector = (Vector) this.dataVector.elementAt(row);
                rowVector.setElementAt(aValue, column);
                this.fireTableCellUpdated(row, column);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
                if (column == this.getRowCount()||column ==this.getRowCount()-1) {
                    return true;
                } else {
                    return true;
                }
            }

        });
        orderUpdateEditor.settable(cartTable);
        orderDeleteEditor.settable(cartTable);
        cartTable.getColumnModel().getColumn(n).setCellEditor(orderUpdateEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(orderUpdateRender);
        cartTable.getColumnModel().getColumn(n+1).setCellEditor(orderDeleteEditor);
        cartTable.getColumnModel().getColumn(n+1).setCellRenderer(orderDeleteRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
        panel_11.add(new JScrollPane(cartTable)).setBounds(102, 100, 800, 300);
    }
    public void filljtable(){
        String[] res1;
        String[][] res;
        String[] r=new String[5];
        Integer f=0;
        Integer price=0;
        try{
            price=Integer.valueOf(textField_2.getText().trim());
        }catch (Exception e){
            price= null;
        }
        if(!textField.getText().trim().isEmpty()){
            r[0]= textField.getText().trim();
        }else{
            r[0]=null;
        }
        if(!textField_1.getText().trim().isEmpty()){
            r[1]= textField_1.getText().trim();
        }else{
            r[1]=null;
        }

        Orderr order=new Orderr(r[0],r[1],price);
        List l=orderService.query(order);
        int m=0,n=0;
        m = l.size();
        n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i]=java.util.Arrays.copyOf(arr1,arr1.length+2);
            res[i][0]=arr1[2];
            res[i][1]=arr1[0];
            res[i][2]=arr1[1];
            res[i][arr1.length]="0";
            res[i][arr1.length+1]="0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1=java.util.Arrays.copyOf(arr1,arr1.length+2);
        res1[0]=arr1[2];
        res1[1]=arr1[0];
        res1[2]=arr1[1];
        res1[arr1.length]="0";
        res1[arr1.length+1]="0";

        cartTable.setModel(new DefaultTableModel(res, res1) {


            @Override
            public void setValueAt(Object aValue, int row, int column) {
                System.out.println(aValue + "  setValueAt");
                Vector<Object> rowVector = (Vector) this.dataVector.elementAt(row);
                rowVector.setElementAt(aValue, column);
                this.fireTableCellUpdated(row, column);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
                if (column == this.getRowCount()||column ==this.getRowCount()-1) {
                    return true;
                } else {
                    return true;
                }
            }
        });
        orderUpdateEditor.settable(cartTable);
        orderDeleteEditor.settable(cartTable);
        cartTable.getColumnModel().getColumn(n).setCellEditor(orderUpdateEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(orderUpdateRender);
        cartTable.getColumnModel().getColumn(n+1).setCellEditor(orderDeleteEditor);
        cartTable.getColumnModel().getColumn(n+1).setCellRenderer(orderDeleteRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
    }
    public void sin(){
        cartTable.getColumnModel().getColumn(3).setCellEditor(orderUpdateEditor);
        cartTable.getColumnModel().getColumn(3).setCellRenderer(orderUpdateRender);
        cartTable.getColumnModel().getColumn(3+1).setCellEditor(orderDeleteEditor);
        cartTable.getColumnModel().getColumn(3+1).setCellRenderer(orderDeleteRender);
    }
    public void querypanel(){

        jb_add = new JButton("查询");
        jb_add.setBounds(270+102, 25+50, 66, 21);
        panel_11.add(jb_add);

        textField = new JTextField();
        textField.setBounds(0+112, 25+50, 66, 21);
        panel_11.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("id");
        lblNewLabel.setBounds(0+112, 50, 66, 21);
        panel_11.add(lblNewLabel);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(90+112, 25+50, 66, 21);
        panel_11.add(textField_1);
        JLabel lblNewLabel1 = new JLabel("item");
        lblNewLabel1.setBounds(90+112, 50, 66, 21);
        panel_11.add(lblNewLabel1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(180+112, 25+50, 66, 21);
        panel_11.add(textField_2);
        JLabel lblNewLabel2 = new JLabel("price");
        lblNewLabel2.setBounds(180+112, 50, 66, 21);
        panel_11.add(lblNewLabel2);

        jb_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                //清空之前显示
                dtm.setRowCount(0);
                try {
                    filljtable();
                    System.out.println("重绘");
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(panel_11, "未查询到", "警告",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel_11.add(jb_add);
    }
}


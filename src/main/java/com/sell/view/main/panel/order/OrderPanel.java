package com.sell.view.main.panel.order;

import com.sell.entity.Buyer;
import com.sell.service.UserService;
import com.sell.util.otov;
import com.sell.view.main.panel.order.table.OrderUpdateEditor;
import com.sell.view.main.panel.order.table.OrderDeleteRender;
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
    private UserService userService;
    @Autowired
    private OrderUpdateEditor updateEditor;
    @Autowired
    private OrderDeleteRender updateRender;
    @Autowired
    private OrderUpdateEditor deleteEditor;
    @Autowired
    private OrderDeleteRender deleteRender;

    public JPanel getPanel() {
        panel_11 = new JPanel();
        cartTable = new javax.swing.JTable();
        jb_add = new javax.swing.JButton();

        //主界面
        panel_11.setLayout(null);
        panel_11.setOpaque(true);

        //表格显示子模块
        initjtable();

        //查询子模块
        querypanel();


        return panel_11;
    }

    public void initjtable(){
        String[] res1;
        String[][] res;
        List l = userService.queryAll();
        int m = l.size(), n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i]=java.util.Arrays.copyOf(arr1,arr1.length+2);
            res[i][0]=arr1[5];
            res[i][1]=arr1[4];
            res[i][2]=arr1[0];
            res[i][3]=arr1[6];
            res[i][4]=arr1[3];
            res[i][5]=arr1[2];
            res[i][6]=arr1[1];

            res[i][arr1.length]="0";
            res[i][arr1.length+1]="0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1=java.util.Arrays.copyOf(arr1,arr1.length+2);
        res1[0]=arr1[5];
        res1[1]=arr1[4];
        res1[2]=arr1[0];
        res1[3]=arr1[6];
        res1[4]=arr1[3];
        res1[5]=arr1[2];
        res1[6]=arr1[1];
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
        updateEditor.settable(cartTable);
        deleteEditor.settable(cartTable);
        cartTable.getColumnModel().getColumn(n).setCellEditor(updateEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(updateRender);
        cartTable.getColumnModel().getColumn(n+1).setCellEditor(deleteEditor);
        cartTable.getColumnModel().getColumn(n+1).setCellRenderer(deleteRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
        panel_11.add(new JScrollPane(cartTable)).setBounds(102, 100, 800, 300);
    }
    public void filljtable(){
        String[] res1;
        String[][] res;
        String[] r=new String[5];
        Integer f=0;
        Integer age=0;
        try{
            age=Integer.valueOf(textField_2.getText().trim());
        }catch (Exception e){
            age= null;
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
        if(!textField_3.getText().trim().isEmpty()){
            r[2]= textField_3.getText().trim();
        }else{
            r[2]=null;
        }
        if(!textField_4.getText().trim().isEmpty()){
            r[3]= textField_4.getText().trim();
        }else{
            r[3]=null;
        }
        if(!textField_5.getText().trim().isEmpty()){
            r[4]= textField_5.getText().trim();
        }else{
            r[4]=null;
        }
        Buyer user=new Buyer(null,r[0],r[1],age, r[2],r[3],r[4]);
        List l=userService.query(user);
        int m = l.size(), n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i]=java.util.Arrays.copyOf(arr1,arr1.length+2);
            res[i][0]=arr1[5];
            res[i][1]=arr1[4];
            res[i][2]=arr1[0];
            res[i][3]=arr1[6];
            res[i][4]=arr1[3];
            res[i][5]=arr1[2];
            res[i][6]=arr1[1];
            res[i][arr1.length]="0";
            res[i][arr1.length+1]="0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1=java.util.Arrays.copyOf(arr1,arr1.length+2);
        res1[0]=arr1[5];
        res1[1]=arr1[4];
        res1[2]=arr1[0];
        res1[3]=arr1[6];
        res1[4]=arr1[3];
        res1[5]=arr1[2];
        res1[6]=arr1[1];
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
        updateEditor.settable(cartTable);
        deleteEditor.settable(cartTable);
        cartTable.getColumnModel().getColumn(n).setCellEditor(updateEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(updateRender);
        cartTable.getColumnModel().getColumn(n+1).setCellEditor(deleteEditor);
        cartTable.getColumnModel().getColumn(n+1).setCellRenderer(deleteRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
    }
    public void querypanel(){

        jb_add = new JButton("查询");
        jb_add.setBounds(560+102, 25+50, 66, 21);
        panel_11.add(jb_add);

        textField = new JTextField();
        textField.setBounds(0+112, 25+50, 66, 21);
        panel_11.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("name");
        lblNewLabel.setBounds(0+112, 50, 66, 21);
        panel_11.add(lblNewLabel);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(90+112, 25+50, 66, 21);
        panel_11.add(textField_1);
        JLabel lblNewLabel1 = new JLabel("password");
        lblNewLabel1.setBounds(90+112, 50, 66, 21);
        panel_11.add(lblNewLabel1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(180+112, 25+50, 66, 21);
        panel_11.add(textField_2);
        JLabel lblNewLabel2 = new JLabel("age");
        lblNewLabel2.setBounds(180+112, 50, 66, 21);
        panel_11.add(lblNewLabel2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(270+112, 25+50, 66, 21);
        panel_11.add(textField_3);
        JLabel lblNewLabel3 = new JLabel("sex");
        lblNewLabel3.setBounds(270+112, 50, 66, 21);
        panel_11.add(lblNewLabel3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(360+112, 25+50, 66, 21);
        panel_11.add(textField_4);
        JLabel lblNewLabel4 = new JLabel("phone");
        lblNewLabel4.setBounds(360+112, 50, 66, 21);
        panel_11.add(lblNewLabel4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(450+112, 25+50, 66, 21);
        panel_11.add(textField_5);
        JLabel lblNewLabel5 = new JLabel("address");
        lblNewLabel5.setBounds(450+112, 50, 66, 21);
        panel_11.add(lblNewLabel5);

        jb_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                //清空之前显示
                dtm.setRowCount(0);
                filljtable();
                System.out.println("重绘");
            }
        });
        panel_11.add(jb_add);
    }
}


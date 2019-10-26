package com.sell.view.main.panel.user;

import com.sell.service.UserService;
import com.sell.util.otov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * @author __USER__
 */
@Component
public class buy {

    /**
     * Creates new form OrderGoodsFrm
     */
    @Autowired
    private UserService userService;
    @Autowired
    private QueryEditor queryEditor;
    @Autowired
    private QueryRender queryRender;

    public JPanel getPanel() {
        JPanel panel_11 = new JPanel();
        jScrollPane2 = new javax.swing.JPanel();
        cartTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        iamgeLb = new javax.swing.JLabel();
        jb_add = new javax.swing.JButton();
        jb_ok = new javax.swing.JButton();
        jb_delete = new javax.swing.JButton();
        totalMoneyTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalNumTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JPanel();
        goodsTable = new javax.swing.JTable();

        panel_11.setLayout(null);
        initjtable();
        panel_11.add(cartTable).setBounds(40, 40, 800, 300);


        totalMoneyTxt.setEditable(false);

        jLabel1.setText("\u603b\u91d1\u989d\uff1a");

        jLabel2.setText("\u603b\u6570\u91cf\uff1a");

        totalNumTxt.setEditable(false);

        panel_11.add(goodsTable).setBounds(400, 400, 80, 30);

        return panel_11;
    }

    private void fillCartTable() {
        //修改商品总数和总金额
        int rowNum = cartTable.getRowCount();//计算行数
        int totalNum = 0;//总数量
        float totalMoney = 0;//总金额
        //累加总数量和总金额
        for (int i = 0; i < rowNum; i++) {
            totalNum += Integer.parseInt((String) cartTable.getValueAt(i, 2));
            totalMoney += Float.parseFloat((String) cartTable.getValueAt(i, 4));
        }
        //文本框赋值
        this.totalNumTxt.setText(Integer.toString(totalNum));
        this.totalMoneyTxt.setText(Float.toString(totalMoney));
    }

    private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        int row = cartTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择要删除的行！");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
            //删除选择的行
            dtm.removeRow(row);
        }
        fillCartTable();
    }

    private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        //获取选中的行
        int row = goodsTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选择一种套餐");
            return;
        }
        //在表单中购物车table中显示加入的数据
        int i = 0, flag = 0;//标记是否已经存在
        int rowNum = cartTable.getRowCount();
        for (i = 0; i < rowNum; i++) {
            if (goodsTable.getValueAt(row, 0)
                    .equals(cartTable.getValueAt(i, 0))) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            Vector v = new Vector();
            v.add((String) goodsTable.getValueAt(row, 0));
            v.add((String) goodsTable.getValueAt(row, 1));
            v.add("1");
            v.add((String) goodsTable.getValueAt(row, 3));
            v.add((String) goodsTable.getValueAt(row, 3));
            dtm.addRow(v);
        } else {

            int goodsNum = Integer
                    .parseInt((String) cartTable.getValueAt(i, 2)) + 1;//获取当前数量
            float goodsPrice = Float.parseFloat((String) cartTable.getValueAt(
                    i, 3));//获取当前单价

            goodsPrice = goodsPrice
                    + Float.parseFloat((String) cartTable.getValueAt(i, 4));//获取数量修改以后的总价
            this.cartTable.setValueAt(Integer.toString(goodsNum), i, 2);
            this.cartTable.setValueAt(Float.toString(goodsPrice), i, 4);
        }
        fillCartTable();
    }

    private void goodsTableMousePressed(java.awt.event.MouseEvent evt) {
        //获取选中的行
        int row = goodsTable.getSelectedRow();

        String picturePath = (String) goodsTable.getValueAt(row, 4);
        /*if (StringUtil.isNotEmpty(picturePath)) {
            Icon icon = new ImageIcon(picturePath);
            this.iamgeLb.setIcon(icon);
        } else {
            this.iamgeLb.setIcon(null);
        }*/

    }
    private void initjtable(){
        String[] res1;
        String[][] res;
        List l = userService.queryAll();
        int m = l.size(), n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).values()).toArray(new String[0]);
            res[i]=java.util.Arrays.copyOf(arr1,arr1.length+2);
            res[i][arr1.length]="0";
            res[i][arr1.length+1]="0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1=java.util.Arrays.copyOf(arr1,arr1.length+2);
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
        queryEditor.settable(cartTable);
        cartTable.getColumnModel().getColumn(n).setCellEditor(queryEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(queryRender);
        cartTable.getColumnModel().getColumn(n+1).setCellEditor(queryEditor);
        cartTable.getColumnModel().getColumn(n+1).setCellRenderer(queryRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JTable cartTable;
    private javax.swing.JTable goodsTable;
    private javax.swing.JLabel iamgeLb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jScrollPane1;
    private javax.swing.JPanel jScrollPane2;
    private javax.swing.JButton jb_add;
    private javax.swing.JButton jb_delete;
    private javax.swing.JButton jb_ok;
    private javax.swing.JTextField totalMoneyTxt;
    private javax.swing.JTextField totalNumTxt;

    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
        buy buy = new buy();
        buy.getPanel().setVisible(true);
    }


}

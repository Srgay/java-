package com.sell.view.main.panel.buy;

import com.sell.entity.Stock;
import com.sell.service.BuyService;
import com.sell.service.StockService;
import com.sell.util.otov;
import com.sell.view.main.panel.buy.table.*;
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
public class BuyPanel {

    private JTable cartTable, buyTable;
    private JButton jb_add;
    private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5;
    private JPanel panel_11;
    @Autowired
    private BuyService buyService;
    @Autowired
    private StockService stockService;
    @Autowired
    private BuyAddEditor buyAddEditor;
    @Autowired
    private BuyAddRender buyAddRender;
    @Autowired
    private BuyDeleteEditor buyDeleteEditor;
    @Autowired
    private BuyDeleteRender buyDeleteRender;
    @Autowired
    private BuyUpdateEditor buyUpdateEditor;
    @Autowired
    private BuyUpdateRender buyUpdateRender;

    public JPanel getPanel() {
        panel_11 = new JPanel();
        cartTable = new JTable();
        buyTable = new JTable();
        jb_add = new JButton();

        //主界面
        panel_11.setLayout(null);
        panel_11.setOpaque(true);

        JLabel lblNewLabel = new JLabel("2");
        lblNewLabel.setBounds(0, 0, 66, 21);
        panel_11.add(lblNewLabel);
        //表格显示子模块
        initjtable();
        initbtable();
        //查询子模块
        querypanel();


        return panel_11;
    }

    public void initjtable() {
        String[] res1;
        String[][] res;
        List l = stockService.queryAll();
        int m = l.size(), n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i] = java.util.Arrays.copyOf(arr1, arr1.length + 1);
            res[i][0] = arr1[1];
            res[i][1] = arr1[0];
            res[i][2] = arr1[2];

            res[i][arr1.length] = "0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1 = java.util.Arrays.copyOf(arr1, arr1.length + 1);
        res1[0] = arr1[1];
        res1[1] = arr1[0];
        res1[2] = arr1[2];
        res1[arr1.length] = "0";

        cartTable.setModel(new DefaultTableModel(res, res1) {


            /*@Override
            public void setValueAt(Object aValue, int row, int column) {
                System.out.println(aValue + "  setValueAt");
                Vector<Object> rowVector = (Vector) this.dataVector.elementAt(row);
                rowVector.setElementAt(aValue, column);
                this.fireTableCellUpdated(row, column);
            }*/

            @Override
            public boolean isCellEditable(int row, int column) {
                // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
                if (column == 3) {
                    return true;
                } else {
                    return false;
                }
            }

        });
        buyAddEditor.settable(cartTable);
        buyAddEditor.setbtable(buyTable);
        buyDeleteEditor.settable(cartTable);
        buyDeleteEditor.setbtable(buyTable);
        cartTable.getColumnModel().getColumn(n).setCellEditor(buyAddEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(buyAddRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
        panel_11.add(new JScrollPane(cartTable)).setBounds(0, 100, 500, 300);
    }

    public void filljtable() {
        String[] res1;
        String[][] res;
        String[] r = new String[5];
        Integer f = 0;
        Integer count = 0;
        if (!textField.getText().trim().isEmpty()) {
            r[0] = textField.getText().trim();
        } else {
            r[0] = null;
        }
        Stock stock = new Stock(null, r[0], null);
        List l = stockService.query(stock);
        int m = l.size(), n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i] = java.util.Arrays.copyOf(arr1, arr1.length + 1);
            res[i][0] = arr1[1];
            res[i][1] = arr1[0];
            res[i][2] = arr1[2];
            res[i][arr1.length] = "0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1 = java.util.Arrays.copyOf(arr1, arr1.length + 1);
        res1[0] = arr1[1];
        res1[1] = arr1[0];
        res1[2] = arr1[2];
        res1[arr1.length] = "0";

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
                if (column == 3) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        cartTable.getColumnModel().getColumn(n).setCellEditor(buyAddEditor);
        cartTable.getColumnModel().getColumn(n).setCellRenderer(buyAddRender);
        cartTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。*/
    }

    public void initbtable() {


        String[] res1 = new String[]{"name", "count", "", ""};
        String[][] res = null;
        buyTable.setModel(new DefaultTableModel(res, res1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
                if (column == 2 || column == 3) {
                    return true;
                } else {
                    return false;
                }
            }

        });
        buyTable.getColumnModel().getColumn(2).setCellEditor(buyUpdateEditor);
        buyTable.getColumnModel().getColumn(2).setCellRenderer(buyUpdateRender);
        buyTable.getColumnModel().getColumn(3).setCellEditor(buyDeleteEditor);
        buyTable.getColumnModel().getColumn(3).setCellRenderer(buyDeleteRender);
        buyTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
        panel_11.add(new JScrollPane(buyTable)).setBounds(524, 100, 500, 300);
    }

    public void fillbtable() {
        String[] res1;
        String[][] res;
        String[] r = new String[5];
        Integer f = 0;
        Integer count = 0;
        try {
            count = Integer.valueOf(textField_2.getText().trim());
        } catch (Exception e) {
            count = null;
        }
        if (!textField.getText().trim().isEmpty()) {
            r[0] = textField.getText().trim();
        } else {
            r[0] = null;
        }
        if (!textField_1.getText().trim().isEmpty()) {
            r[1] = textField_1.getText().trim();
        } else {
            r[1] = null;
        }
        Stock stock = new Stock(r[0], r[1], count);
        List l = stockService.query(stock);
        int m = l.size(), n = otov.tov(l.get(0)).size();
        res = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] arr1 = new ArrayList<String>(otov.tov(l.get(i)).values()).toArray(new String[0]);
            res[i] = java.util.Arrays.copyOf(arr1, arr1.length + 2);
            res[i][0] = arr1[1];
            res[i][1] = arr1[0];
            res[i][2] = arr1[2];
            res[i][arr1.length] = "0";
            res[i][arr1.length + 1] = "0";
        }

        String[] arr1 = new ArrayList<String>(otov.tov(l.get(0)).keySet()).toArray(new String[0]);
        res1 = java.util.Arrays.copyOf(arr1, arr1.length + 2);
        res1[0] = arr1[1];
        res1[1] = arr1[0];
        res1[2] = arr1[2];
        res1[arr1.length] = "0";
        res1[arr1.length + 1] = "0";

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
                if (column == this.getRowCount() || column == this.getRowCount() - 1) {
                    return true;
                } else {
                    return true;
                }
            }
        });
        buyTable.getColumnModel().getColumn(2).setCellEditor(buyUpdateEditor);
        buyTable.getColumnModel().getColumn(2).setCellRenderer(buyUpdateRender);
        buyTable.getColumnModel().getColumn(3).setCellEditor(buyDeleteEditor);
        buyTable.getColumnModel().getColumn(3).setCellRenderer(buyDeleteRender);
        buyTable.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。*/
    }

    public void querypanel() {

        jb_add = new JButton("查询");
        jb_add.setBounds(270 + 102, 25 + 50, 66, 21);
        panel_11.add(jb_add);

        textField = new JTextField();
        textField.setBounds(0 + 112, 25 + 50, 66, 21);
        panel_11.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("name");
        lblNewLabel.setBounds(0 + 112, 50, 66, 21);
        panel_11.add(lblNewLabel);


        jb_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                //清空之前显示
                dtm.setRowCount(0);
                try {
                    filljtable();
                    System.out.println("重绘");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(panel_11, "未查询到", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel_11.add(jb_add);
    }
}


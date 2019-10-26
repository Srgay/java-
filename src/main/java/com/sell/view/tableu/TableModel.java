package com.sell.view.tableu;


import com.sell.util.otov;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TableModel extends DefaultTableModel {
    private String[][] res;

    public TableModel(List<Object> l) {
        int m=l.size(),n=otov.tov(l.get(1)).size();
        res=new String[m][n];
        for (int i=0;i<m;i++){
            res[i]= new ArrayList<String>(otov.tov(l.get(1)).values()).toArray(new String[0]);
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        return res[row][column];
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

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
        if (column == 2) {
            return true;
        } else {
            return true;
        }
    }
}

package com.sell.view.main.panel.stock;

import com.sell.entity.Stock;
import com.sell.service.StockService;
import com.sell.view.main.panel.stock.table.StockDeleteEditor;
import com.sell.view.main.panel.stock.table.StockDeleteRender;
import com.sell.view.main.panel.stock.table.StockUpdateEditor;
import com.sell.view.main.panel.stock.table.StockUpdateRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class AddStockPanel {

    private JTable cartTable;
    private JButton jb_add;
    private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5;
    private  JPanel panel_11;
    @Autowired
    private StockService stockService;
    @Autowired
    private StockUpdateEditor stockUpdateEditor;
    @Autowired
    private StockUpdateRender stockUpdateRender;
    @Autowired
    private StockDeleteEditor stockDeleteEditor;
    @Autowired
    private StockDeleteRender stockDeleteRender;

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

        //查询子模块
        querypanel();


        return panel_11;
    }

    public void querypanel(){

        jb_add = new JButton("增加");
        jb_add.setBounds(360+102, 25+50, 66, 21);
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
        JLabel lblNewLabel1 = new JLabel("name");
        lblNewLabel1.setBounds(90+112, 50, 66, 21);
        panel_11.add(lblNewLabel1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(180+112, 25+50, 66, 21);
        panel_11.add(textField_2);
        JLabel lblNewLabel2 = new JLabel("stock");
        lblNewLabel2.setBounds(180+112, 50, 66, 21);
        panel_11.add(lblNewLabel2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(270+112, 25+50, 66, 21);
        panel_11.add(textField_3);
        JLabel lblNewLabel3 = new JLabel("price");
        lblNewLabel3.setBounds(270+112, 50, 66, 21);
        panel_11.add(lblNewLabel3);

        jb_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] r=new String[5];
                Integer f=0;
                Integer count=0;
                try{
                    count=Integer.valueOf(textField_2.getText().trim());
                }catch (Exception a){
                    count= null;
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
                    r[3]= textField_3.getText().trim();
                }else{
                    r[3]=null;
                }
                Stock stock=new Stock(r[0],r[1],count,r[3]);
                try {
                    if(stockService.addStock(stock)==1){
                        JOptionPane.showMessageDialog(null, "增加成功");
                        System.out.println("增加成功");
                    }
                }catch (org.springframework.dao.DuplicateKeyException e1){
                    JOptionPane.showMessageDialog(null, "id已存在", "warning", JOptionPane.WARNING_MESSAGE);
                }catch (org.springframework.dao.DataIntegrityViolationException e1){
                    JOptionPane.showMessageDialog(null, "请完善信息", "warning", JOptionPane.WARNING_MESSAGE);
                }



            }
        });
        panel_11.add(jb_add);
    }
}


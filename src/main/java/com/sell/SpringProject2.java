package com.sell;


import com.sell.service.UserService;
import com.sell.view.Login;
import com.sell.view.MainFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.*;


@SpringBootApplication
@MapperScan(value = "com.sell.dao")
public class SpringProject2 implements CommandLineRunner {
    @Autowired
    private Login login;
    @Autowired
    private UserService userService;
    @Autowired
    private MainFrame mainFrame;
    @Override
    public void run(String... args) throws Exception {
        try {
            UIManager.put("ToolBar.isPaintPlainBackground", Boolean.TRUE);
            UIManager.put("RootPane.setupButtonVisible", false);
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch(Exception e) { //TODO exception }  catch (Exception e) {
            //TODO exception
        }

       // login.setSize(300, 300);
        //login.setLocationRelativeTo(null);
        //login.setVisible(true);
        mainFrame.setTitle("鲜花销售管理信息系统");
        mainFrame.setSize(1021, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);


    }

    public static void main(String[] args) {
        SpringApplication.run(SpringProject2.class, args);
    }
}
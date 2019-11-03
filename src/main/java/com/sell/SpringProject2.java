package com.sell;


import com.sell.service.UserService;
import com.sell.view.LogOnFrm;
import com.sell.view.MainFrame;
import com.sell.view.main.actionPerformed.MainAction;
import com.sell.view.main.panel.init.InitPanel;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.swing.*;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.sell.dao")
public class SpringProject2 implements CommandLineRunner {
    @Autowired
    private LogOnFrm logOnFrm;
    @Autowired
    private UserService userService;
    @Autowired
    private MainFrame mainFrame;
    @Autowired
    private InitPanel initPanel;
    @Autowired
    private MainAction mainAction;
    @Autowired
    private JPanel mainPanel;

    @Override
    public void run(String... args) throws Exception {
        try {
            UIManager.put("ToolBar.isPaintPlainBackground", Boolean.TRUE);
            UIManager.put("RootPane.setupButtonVisible", false);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch(Exception e) { //TODO exception }  catch (Exception e) {
            //TODO exception
        }

        /*mainFrame.setTitle("“奥林匹克”体育器材销售信息系统");
        mainFrame.setSize(1021, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainAction.action(mainPanel, initPanel.getPanel());*/
        logOnFrm.setLocationRelativeTo(null);
        logOnFrm.setVisible(true);


    }

    public static void main(String[] args) {
        SpringApplication.run(SpringProject2.class, args);
    }
}
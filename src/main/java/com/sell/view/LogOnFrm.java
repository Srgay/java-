package com.sell.view;

import com.sell.entity.Buyer;
import com.sell.service.UserService;
import com.sell.view.main.actionPerformed.MainAction;
import com.sell.view.main.panel.init.InitPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@Component
public class LogOnFrm extends javax.swing.JFrame {
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_logon;
    private javax.swing.JButton jb_register;
    private javax.swing.JButton jb_reset;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userNameTxt;
    @Autowired
    private UserService userService;
    @Autowired
    private Regist regist;
    @Autowired
    private MainFrame mainFrame;
    @Autowired
    private InitPanel initPanel;
    @Autowired
    private MainAction mainAction;
    @Autowired
    private JPanel mainPanel;

    public static Buyer s_currentUser = null;//保存登陆用户的参数

    /**
     * Creates new form LogOnFrm
     */
    public LogOnFrm() {
        //改变系统默认字体
        Font font = new Font("Dialog", Font.PLAIN, 12);
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭界面时退出JVM虚拟机
        final JFrame a = this;
        addWindowListener(new WindowAdapter() {       //点击关闭界面的叉号时跳出询问窗口
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure closing this software?", "warning", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {

                }
            }
        });
        initComponents();
        //设置frame居中显示
        this.setLocationRelativeTo(null);
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_logon = new javax.swing.JButton();
        jb_register = new javax.swing.JButton();
        userNameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        jb_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("销售系统");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24));
        jLabel1.setIcon(new javax.swing.ImageIcon(
                "img/icon.png")); // NOI18N
        jLabel1
                .setText("“奥林匹克”体育器材销售信息系统");

        jLabel2.setIcon(new javax.swing.ImageIcon(
                "img/userName.png")); // NOI18N
        jLabel2.setText("\u7528\u6237\u540d\uff1a");

        jLabel3.setIcon(new javax.swing.ImageIcon(
                "img/password.png")); // NOI18N
        jLabel3.setText("\u5bc6  \u7801\uff1a");

        jb_logon.setIcon(new javax.swing.ImageIcon(
                "img/login.png")); // NOI18N
        jb_logon.setText("\u767b\u9646");
        jb_logon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_logonActionPerformed(evt);
            }
        });

        jb_register.setIcon(new javax.swing.ImageIcon(
                "img/register.png")); // NOI18N
        jb_register.setText("\u6ce8\u518c\u7528\u6237");
        jb_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_registerActionPerformed(evt);
            }
        });

        jb_reset.setIcon(new javax.swing.ImageIcon(
                "img/reset.png")); // NOI18N
        jb_reset.setText("\u91cd\u7f6e");
        jb_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout
                .setHorizontalGroup(layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                        .createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(
                                                layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                layout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                layout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                jLabel2)
                                                                                        .addComponent(
                                                                                                jLabel3))
                                                                        .addGap(
                                                                                33,
                                                                                33,
                                                                                33)
                                                                        .addGroup(
                                                                                layout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                        .addComponent(
                                                                                                passwordTxt)
                                                                                        .addComponent(
                                                                                                userNameTxt,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                193,
                                                                                                Short.MAX_VALUE)))
                                                        .addGroup(
                                                                layout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                layout
                                                                                        .createSequentialGroup()
                                                                                        .addGap(
                                                                                                8,
                                                                                                8,
                                                                                                8)
                                                                                        .addComponent(
                                                                                                jb_logon)
                                                                                        .addGap(
                                                                                                18,
                                                                                                18,
                                                                                                18)
                                                                                        .addComponent(
                                                                                                jb_reset)
                                                                                        .addGap(
                                                                                                18,
                                                                                                18,
                                                                                                18)
                                                                                        .addComponent(
                                                                                                jb_register))
                                                                        .addComponent(
                                                                                jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                304,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(54, Short.MAX_VALUE)));
        layout
                .setVerticalGroup(layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout
                                        .createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(
                                                jLabel1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addGroup(
                                                layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(
                                                                userNameTxt,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(
                                                layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(
                                                                passwordTxt,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(
                                                layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jb_logon)
                                                        .addComponent(jb_reset)
                                                        .addComponent(
                                                                jb_register))
                                        .addContainerGap(55, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    //显示注册页面
    private void jb_registerActionPerformed(java.awt.event.ActionEvent evt) {
        regist.setSize(280, 560);
        regist.setVisible(true);
    }

    //登陆验证显示登陆以后界面
    private void jb_logonActionPerformed(java.awt.event.ActionEvent evt) {
        String userName = this.userNameTxt.getText();
        String password = new String(this.passwordTxt.getPassword());
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        } else if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        } else {
            Buyer user = userService.login(userName, password);
            if (user.getAge() != null) {
                s_currentUser = user;
                this.setVisible(false);
                mainFrame.setTitle("“奥林匹克”体育器材销售信息系统");
                mainFrame.setSize(1021, 600);
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
                mainAction.action(mainPanel, initPanel.getPanel());
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码输入错误，请重新输入", "warning", JOptionPane.WARNING_MESSAGE);
                userNameTxt.setText("");
                passwordTxt.setText("");
            }
        }
    }

    //重置文本框内容
    private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
        this.passwordTxt.setText("");
        this.userNameTxt.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogOnFrm().setVisible(true);
            }
        });
    }
}


package com.sell.view;

//模块功能：新用户注册

import com.sell.entity.Buyer;
import com.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import java.lang.Integer;
@Component
public class Regist extends JFrame implements ActionListener {
	private JLabel idLabel,nameLabel,passwordLabel,ageLabel,sexLabel,phoneLabel,addressLabel;
	private JTextField idField,nameField,passwordField,ageField,sexField,phoneField,addressField;
	private JButton submitButton,resetButton;
	@Autowired
	private UserService userService;

    public Regist(){
	    super();
	    this.setTitle("新用户信息注册");
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭界面时退出JVM虚拟机
		addWindowListener(new WindowAdapter(){       //点击关闭界面的叉号时跳出询问窗口
			  public void windowClosing(WindowEvent e){
				int n= JOptionPane.showConfirmDialog(null, "Are you sure closing this software?","warning", JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION)
					System.exit(0);
			  }
		 });
		  init();
	   }
	
	  private void init(){
		idLabel=new JLabel("用户id:");
		nameLabel=new JLabel("用户名:");
		passwordLabel=new JLabel("密  码:");
		ageLabel=new JLabel("年  龄:");
		sexLabel=new JLabel("性  别:");
		phoneLabel=new JLabel("电  话:");
		addressLabel=new JLabel("地  址:");
		
		idField=new JTextField(24);
		nameField=new JTextField(24);
		passwordField=new JTextField(24);
		ageField=new JTextField(24);
		sexField=new JTextField(24);
		phoneField=new JTextField(24);
		addressField=new JTextField(24);
		
		submitButton=new JButton("确定");
		resetButton=new JButton("重置");

		//内容窗格默认布局管理器是FlowLayout
		this.setLayout(null);
		this.add(idLabel).setBounds(40, 40, 80, 30);
		this.add(idField).setBounds(100, 40, 80, 30);
		this.add(nameLabel).setBounds(40, 100, 80, 30);
		this.add(nameField).setBounds(100, 100, 80, 30);
		this.add(passwordLabel).setBounds(40, 160, 80, 30);
		this.add(passwordField).setBounds(100, 160, 80, 30);
		this.add(ageLabel).setBounds(40, 220, 80, 30);
		this.add(ageField).setBounds(100, 220, 80, 30);
		this.add(sexLabel).setBounds(40, 280, 80, 30);
		this.add(sexField).setBounds(100, 280, 80, 30);
		this.add(phoneLabel).setBounds(40, 340, 80, 30);
		this.add(phoneField).setBounds(100, 340, 80, 30);
		this.add(addressLabel).setBounds(40, 400, 80, 30);
		this.add(addressField).setBounds(100, 400, 80, 30);
		
		this.add(submitButton).setBounds(40, 460, 60, 25);		
		this.add(resetButton).setBounds(120, 460, 60, 25);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);		
	  }
	
	 public void submitButton_actionPerformed(){
		String userId=idField.getText().trim();
		String userName=nameField.getText().trim();
		String passWord=passwordField.getText().trim();
		String userAge=ageField.getText().trim();
		int Age= Integer.parseInt(userAge);
		String userSex=sexField.getText().trim();
		String userPhone=phoneField.getText().trim();
		String userAddress=addressField.getText().trim();
		Buyer buyer = new Buyer(userId,userName,passWord,Integer.valueOf(userAge),userSex,userPhone,userAddress);
		 if(userId.equals("") ||userName.equals("") || passWord.equals("")||userAge.equals("")||userSex.equals("")||userPhone.equals("")||userAddress.equals("")){
			JOptionPane.showMessageDialog(this, "请完善登录信息", "warning", JOptionPane.WARNING_MESSAGE);
		}else{
			 int i=userService.regist(buyer);
		 	if (i==1){
				JOptionPane.showMessageDialog(this, "成功", "warning", JOptionPane.WARNING_MESSAGE);
			}
			}			
		}
	
	public void resetButton_actionPerformed() {


	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submitButton){
			submitButton_actionPerformed();
		}else if(e.getSource() == resetButton){
			resetButton_actionPerformed();
		}
	}
}
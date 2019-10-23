package com.sell.view;

//模块功能：登录成功以后，显示整个系统的主界面（此为最重要界面）

import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class MainFrame extends JFrame implements ActionListener
{
	MenuBar menubarxxx=new MenuBar();
	
	Menu menux1=new Menu("用户管理");
	Menu menux2=new Menu("库存管理");
	Menu menux3=new Menu("进货管理");
	Menu menux4=new Menu("销售管理");
	Menu menux5=new Menu("系统退出");
	
	MenuItem menuitemx101=new MenuItem("添加用户");
	MenuItem menuitemx102=new MenuItem("删除用户");
	MenuItem menuitemx103=new MenuItem("修改用户");
	MenuItem menuitemx104=new MenuItem("查询用户");
	
	Menu menux6=new Menu("退出系统");
	MenuItem menuitem501=new MenuItem("保存preview");
	MenuItem menuitem502=new MenuItem("不存printOUT");

	public MainFrame()
	{
		super();
		menubarxxx.add(menux1);
		menubarxxx.add(menux2);
		menubarxxx.add(menux3);
		menubarxxx.add(menux4);
		menubarxxx.add(menux5);
		
		menux1.add(menuitemx101);
		menux1.add(menuitemx102);
		menux1.add(menuitemx103);
		menux1.add(menuitemx104);
		
		menux1.add(menux6);
		
		menux6.add(menuitem501);
		menux6.add(menuitem502);
		
		this.setMenuBar(menubarxxx);
		menuitem502.addActionListener(this); 
        //将按钮注册给按钮事件的监听者	

	 }
   public void actionPerformed(ActionEvent e)
                              //当按钮按下后的执行方法
	  {
		System.out.println("成功了！");
		System.exit(0);       //退出当前的销售信息系统
	  }

	public static void main(String[] args) {
		Icon picture1=new ImageIcon("a2.JPG");
		JLabel logo=new JLabel();
		logo.setIcon(picture1);
		JFrame f=new MainFrame();
		f.setSize(700, 300);
		f.setTitle("鲜花销售管理信息系统");
		f.add(logo);
		f.show();
	}
}
package com.sell;


import com.sell.service.RegistService;
import com.sell.service.UserService;
import com.sell.view.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(value = "com.sell.dao")
public class SpringProject2 implements CommandLineRunner {
    @Autowired
    private Login login;
    @Autowired
    private RegistService registService;
    @Override
    public void run(String... args) throws Exception {
       /* try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
        ;*/
        System.out.println(registService);
        login.setSize(300, 300);
        login.setVisible(true);


    }

    public static void main(String[] args) {
        SpringApplication.run(SpringProject2.class, args);
    }
}
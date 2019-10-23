package com.sell.service.impl;

import com.sell.dao.BuyerMapper;
import com.sell.entity.Buyer;
import com.sell.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistServiceImpl implements RegistService {

    @Autowired
    private BuyerMapper buyerMapper;
    /**
     * @Description: No such property: code for class: Script1
     * @Param:
     * @return: com.com.sell.entity.User
     * @Author: Mr.Wang
     * @Date: 2019/10/22
     */
    public int regist(Buyer user) {

        //user= buyerMapper.selectLogin(userName,passWord);
        //user.setName(userName);
        //user.setPassword(passWord);
        int f = buyerMapper.insert(user);
        System.out.println(f);
        return f;
    }
}

package com.sell.service.impl;

import com.sell.dao.BuyerMapper;
import com.sell.entity.Buyer;
import com.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BuyerMapper buyerMapper;

    /**
     * @Description: No such property: code for class: Script1
     * @Param:
     * @return: com.com.sell.entity.User
     * @Author: Mr.Wang
     * @Date: 2019/10/22
     * @param userName
     * @param passWord
     */
    public Buyer login(String userName, String passWord) {

        /*user= buyerMapper.selectLogin(userName,passWord);*/
        Buyer user = new Buyer();
        user.setName(userName);
        user.setPassword(passWord);
        user = buyerMapper.selectOne(user);

        return user;
    }

}

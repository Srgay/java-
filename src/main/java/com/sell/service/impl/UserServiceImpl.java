package com.sell.service.impl;

import com.sell.dao.BuyerMapper;
import com.sell.entity.Buyer;
import com.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


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
    public int regist(Buyer user) {

        //user= buyerMapper.selectLogin(userName,passWord);
        //user.setName(userName);
        //user.setPassword(passWord);
        int f = buyerMapper.insert(user);
        System.out.println(f);
        return f;
    }
    public List<Buyer> query(Buyer user) {
        List<Buyer> userlist = null;
        userlist = buyerMapper.select(user);
        return userlist;
    }
    public List<Buyer> queryAll() {
        List<Buyer> userlist = null;
        userlist = buyerMapper.selectAll();
        return userlist;
    }
    public int update(Buyer user) {
        int i=0;
        try {
            Example example = new Example(Buyer.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", user.getId());
            i=buyerMapper.updateByExampleSelective(user, example);
            return i;
        }catch (Exception e){
            return i;
        }
    }
    public int delete(Buyer user) {
        int i=0;
        try {
            i=buyerMapper.deleteByPrimaryKey(user);
            return i;
        }catch (Exception e){
            return i;
        }
    }

}

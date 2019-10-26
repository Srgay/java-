package com.sell.service;

import com.sell.entity.Buyer;

import java.util.List;

public interface UserService {

    public Buyer login(String userName, String passWord) ;
    public int regist(Buyer user) ;
    public List<Buyer> query(Buyer user);
    public List<Buyer> queryAll() ;
    public int update(Buyer user);
    public int delete(Buyer user);
}

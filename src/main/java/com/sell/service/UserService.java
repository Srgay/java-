package com.sell.service;

import com.sell.entity.Buyer;

public interface UserService {

    public Buyer login(String userName, String passWord) ;
    public int regist(Buyer user) ;
}

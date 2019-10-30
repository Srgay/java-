package com.sell.service;

import com.sell.entity.Orderr;

import java.util.List;

public interface OrderService {
    public List<Orderr> query(Orderr order);
    public List<Orderr> queryAll() ;
    public int addStock(Orderr order);
    public int update(Orderr order);
    public int delete(Orderr order);

}

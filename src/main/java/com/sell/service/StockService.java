package com.sell.service;

import com.sell.entity.Stock;

import java.util.List;

public interface StockService {
    public List<Stock> queryByName(String name);
    public List<Stock> query(Stock stock);
    public List<Stock> queryAll() ;
    public int addStock(Stock stock);
    public int update(Stock stock);
    public int delete(Stock stock);
}

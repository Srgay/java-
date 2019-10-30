package com.sell.dao;

import com.sell.entity.Stock;

import java.util.List;

public interface StockMapper {
    int deleteByPrimaryKey(String id);

    int insert(Stock record);

    Stock selectByPrimaryKey(String id);

    List<Stock> selectAll();

    int updateByPrimaryKey(Stock record);
}
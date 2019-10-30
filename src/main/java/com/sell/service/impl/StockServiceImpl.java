package com.sell.service.impl;

import com.sell.dao.StockMapper;
import com.sell.entity.Buyer;
import com.sell.entity.Stock;
import com.sell.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;
    @Override
    public List<Stock> query(Stock stock) {
        List<Stock> stockslist = null;
        stockslist = stockMapper.select(stock);
        return stockslist;
    }

    @Override
    public List<Stock> queryAll() {
        List<Stock> stockslist = null;
        stockslist = stockMapper.selectAll();
        return stockslist;
    }

    @Override
    public int addStock(Stock stock) {
        int f=stockMapper.insert(stock);
        return f;
    }

    @Override
    public int update(Stock stock) {
        int i=0;
        try {
            Example example = new Example(Buyer.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", stock.getId());
            i=stockMapper.updateByExampleSelective(stock, example);
            return i;
        }catch (Exception e){
            return i;
        }
    }

    @Override
    public int delete(Stock stock) {
        int i=0;
        try {
            i=stockMapper.deleteByPrimaryKey(stock);
            return i;
        }catch (Exception e){
            return i;
        }
    }
}

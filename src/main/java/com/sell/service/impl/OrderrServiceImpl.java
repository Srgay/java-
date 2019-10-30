package com.sell.service.impl;

import com.sell.dao.OrderrMapper;
import com.sell.entity.Buyer;
import com.sell.entity.Orderr;
import com.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderrServiceImpl implements OrderService {
    @Autowired
    private OrderrMapper orderrMapper;
    @Override
    public List<Orderr> query(Orderr order) {
        List<Orderr> orderList=null;
        orderList = orderrMapper.select(order);
        return orderList;
    }

    @Override
    public List<Orderr> queryAll() {
        List<Orderr> orderList=null;
        orderList = orderrMapper.selectAll();
        return orderList;
    }

    @Override
    public int addStock(Orderr order) {
        return 0;
    }

    @Override
    public int update(Orderr order) {
        int i=0;
        try {
            Example example = new Example(Buyer.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", order.getId());
            i=orderrMapper.updateByExampleSelective(order, example);
            return i;
        }catch (Exception e){
            return i;
        }
    }

    @Override
    public int delete(Orderr order) {
        int i=0;
        try {
            i=orderrMapper.deleteByPrimaryKey(order);
            return i;
        }catch (Exception e){
            return i;
        }
    }
}

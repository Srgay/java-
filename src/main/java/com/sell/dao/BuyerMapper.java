package com.sell.dao;

import com.sell.entity.Buyer;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BuyerMapper extends Mapper<Buyer> {

    Buyer selectLogin(@Param("userName") String username, @Param("password") String password);

}
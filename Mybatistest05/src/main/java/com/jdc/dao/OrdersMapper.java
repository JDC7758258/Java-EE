package com.jdc.dao;

import com.jdc.pojo.Orders;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {
    //一对多式：注解式多表查询
    @Select("select * from tb_orders where user_id = #{uid}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "number", column = "number")
    })
    public List<Orders> selectOrdersByUserId(int id);

    //多对多式：注解式多表查询
    @Select("select * from tb_orders where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(property = "productList", column = "id",
                    many = @Many(select = "com.jdc.dao.ProductMapper.selectProductByOrdersId"))
    })
    public Orders selectOrderById(int id);

}

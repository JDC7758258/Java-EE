package com.jdc.dao;

import com.jdc.pojo.Person;
import org.apache.ibatis.annotations.*;

public interface PersonMapper {

    //一对一式：注解式多表查询
    @Select("select * from tb_person where id = #{id}")
    @Results(@Result(column = "card_id", property = "card",
            one = @One(select = "com.jdc.dao.IdCardMapper.selectIdCardById")))
    public Person selectPersonById(int id);
}

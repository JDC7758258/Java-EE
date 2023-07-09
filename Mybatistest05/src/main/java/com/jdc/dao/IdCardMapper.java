package com.jdc.dao;

import com.jdc.pojo.IdCard;
import org.apache.ibatis.annotations.Select;

public interface IdCardMapper {

    @Select("select * from tb_idcard where id = #{id}")
    public IdCard selectIdCardById(int id);
}

package com.jdc.dao;

import com.jdc.pojo.IClass;
import com.jdc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IClassMapperTest {

    @Test
    void selectIClassById() {
        SqlSession session = MyBatisUtils.sqlSession();
        IClassMapper classMapper = session.getMapper(IClassMapper.class);
        IClass iClass = classMapper.selectIClassById(2);
        System.out.println(iClass);
        session.close();
    }
}
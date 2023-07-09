package com.jdc.mapper;

import com.jdc.pojo.Category;
import com.jdc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void findCategoryWithProductTest(){
        SqlSession session = MyBatisUtils.sqlSession();
        Category category = session.selectOne("com.jdc.mapper.CategoryMapper.findCategoryWithProduct", 2);
        session.close();
        System.out.println(category);
    }
}

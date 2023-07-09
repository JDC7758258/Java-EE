package com.jdc.test;

import com.jdc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class UserTest {
    @Test
    public void findById() throws Exception {
        //1.获取核心配置文件
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne("com.jdc.pojo.User.findById", 1);
            System.out.println(user);
        } finally {
            //释放资源
            sqlSession.close();
        }
    }

    @Test
    public void findTotal() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is, "test");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Integer total = sqlSession.selectOne("com.jdc.pojo.User.findTotal");
            System.out.println("数据的总数量:" + total);
        } finally {
            sqlSession.close();
        }
    }
}
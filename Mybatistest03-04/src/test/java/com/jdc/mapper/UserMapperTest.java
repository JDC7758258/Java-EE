package com.jdc.mapper;

import com.jdc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserMapperTest {

    UserMapper userMapper = null;
    SqlSession sqlSession = null;
    @Before
    public  void setUp() throws Exception {

        //1.获取核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();

        //4.获取接口的动态代理对象
        //执行方法时，要找到哪一条sql语句来执行？sql的唯一标识是namespace.statementId
        userMapper = sqlSession.getMapper(UserMapper.class);

    }

    //数据库操作：查id
    @Test
    public void testFindById() {
        try {
            this.setUp();
        } catch (Exception e){
            System.out.println(e);
        }
        User user = userMapper.findById(2);
        System.out.println(user);
        sqlSession.close();
    }

    //数据库操作：total 总
    @Test
    public void testFindTotal() {
        try {
            this.setUp();
        } catch (Exception e){
            System.out.println(e);
        }
        Integer total = userMapper.findTotal();
        System.out.println(total);
        sqlSession.close();
    }

    //数据库操作：增
    @Test
    public void addUser() {

        User user = new User();
        user.setUage(20);
        //user.setUid(3);
        user.setUname("龙青春");

        System.out.println("数据插入之前的用户id:"+user.getUid());
        userMapper.addUser(user);
        System.out.println("数据插入之后的用户id:"+user.getUid());

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //数据库操作：改
    @Test
    public void updateUser(){
        User user = new User();
        user.setUage(25);
        user.setUid(3);
        user.setUname("陈铭典");
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    //数据库操作：删
    @Test
    public void deleteUser(){
        userMapper.deleteUser(3);
        sqlSession.commit();
        sqlSession.close();
    }
}
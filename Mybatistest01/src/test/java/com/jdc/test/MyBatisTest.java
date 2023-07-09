package com.jdc.test;

import com.jdc.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Before
    public void init() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void findAllStudentTest(){
        List<Student> studentList = sqlSession.selectList("com.jdc.mapper.StudentMapper.findAllStudent");
        for (Student s:studentList){
            System.out.println(s);
        }
    }

    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
}

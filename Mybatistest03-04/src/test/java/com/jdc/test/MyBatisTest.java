package com.jdc.test;

import com.jdc.pojo.Book;
import com.jdc.pojo.Person;
import com.jdc.pojo.Student;
import com.jdc.pojo.Users;
import com.jdc.utils.MyBatisUtils;
import com.mysql.jdbc.exceptions.MySQLDataException;
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

    @Test
    public void findPersonByIdTest(){
        SqlSession session = MyBatisUtils.sqlSession();
        Person person = session.selectOne("com.jdc.mapper.PersonMapper.findPersonById", 2);
        System.out.println(person.getId());
        System.out.println("*****需要使用另外一张表的数据");
        System.out.println(person.getCard());
        session.close();
    }

    @Test
    public void findPersonById2Test(){
        SqlSession session = MyBatisUtils.sqlSession();
        Person person = session.selectOne("com.jdc.mapper.PersonMapper.findPersonById2", 2);
        System.out.println(person);
//        System.out.println("*****需要使用另外一张表的数据");
//        System.out.println(person.getCard());
        session.close();
    }

    @Test
    public void findUserWithOrdersById(){
        SqlSession session = MyBatisUtils.sqlSession();
        Users users = session.selectOne("com.jdc.mapper.UsersMapper.findUserWithOrdersById",1);
        System.out.println(users);
        session.close();
    }

    @Test
    public void findOrderWithProductById(){
        SqlSession session = MyBatisUtils.sqlSession();
        Object order = session.selectOne("com.jdc.mapper.OrdersMapper.findOrdersById", 1);
        System.out.println(order);
        session.close();
    }

    @Test
    public void findOrderWithProductById2(){
        SqlSession session = MyBatisUtils.sqlSession();
        Object order = session.selectOne("com.jdc.mapper.OrdersMapper.findOrdersById2", 1);
        System.out.println(order);
        session.close();
    }

    //一级缓存实现
    @Test
    public void findBookByIdTest1(){
        SqlSession session = MyBatisUtils.sqlSession();

        System.out.println("*****第一次查询*****");
        //第一次查询
        Book book = session.selectOne("com.jdc.mapper.BookMapper.findBookById", 1);
        System.out.println(book);

        //执行操作
        Book updateBook = new Book();
        updateBook.setId(2);
        updateBook.setBookName("数值分析");
        updateBook.getPrice();
        session.update("com.jdc.mapper.BookMapper.updateBook",updateBook);

        System.out.println("*****第二次查询*****");
        //第二次查询
        Book book2 = session.selectOne("com.jdc.mapper.BookMapper.findBookById", 1);
        System.out.println(book2);

        session.close();
    }

    //二级缓存实现
    @Test
    public void findBookByIdTest2() {
        SqlSession sqlSession1 = MyBatisUtils.sqlSession();
        SqlSession sqlSession2 = MyBatisUtils.sqlSession();
        SqlSession sqlSession3 = MyBatisUtils.sqlSession();

        //第一次查询
        System.out.println("*****第一次查询*****");
        Book book = sqlSession1.selectOne("com.jdc.mapper.BookMapper.findBookById", 1);
        System.out.println(book);
        //释放sqlSession 将数据写入二级缓存
        sqlSession1.close();

        //执行操作
        Book updateBook = new Book();
        updateBook.setId(2);
        updateBook.setBookName("数值分析44");
        updateBook.getPrice();
        sqlSession3.update("com.jdc.mapper.BookMapper.updateBook", updateBook);
        sqlSession3.commit();
        sqlSession3.close();

        //第二次查询
        System.out.println("*****第二次查询*****");
        Book book2 = sqlSession2.selectOne("com.jdc.mapper.BookMapper.findBookById", 1);
        System.out.println(book2);

        sqlSession2.close();
    }
}

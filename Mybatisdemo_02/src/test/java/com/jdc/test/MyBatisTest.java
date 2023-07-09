package com.jdc.test;

import com.jdc.pojo.Employee;
import com.jdc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {

    //数据库操作：查找
    @Test
    public void findByIdTest(){
        SqlSession sqlSession = MyBatisUtils.sqlSession();
        Employee employee = sqlSession.selectOne("com.jdc.mapper.EmployeeMapper.findEmployeeById",1);
        System.out.println(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    //数据库操作：插入
    @Test
    public void saveTest(){
        Employee employee = new Employee();
        employee.setId(6);
        employee.setAge(50);
        employee.setName("陈铭典");
        employee.setPosition("经理");
        SqlSession sqlSession = MyBatisUtils.sqlSession();
        sqlSession.update("com.jdc.mapper.EmployeeMapper.save",employee);
        sqlSession.commit();
        sqlSession.close();
    }

    //数据库操作：修改
    @Test
    public void updateEmployeeByIdTest(){
        Employee employee = new Employee();
        employee.setId(5);
        employee.setAge(55);
        employee.setName("典典");
        employee.setPosition("员工");
        SqlSession sqlSession = MyBatisUtils.sqlSession();
        sqlSession.update("com.jdc.mapper.EmployeeMapper.updateEmployeeById",employee);
        sqlSession.commit();
        sqlSession.close();
    }

    //数据库操作：删除
    @Test
    public void deleteEmployeeByIdTest(){
        SqlSession sqlSession = MyBatisUtils.sqlSession();
        sqlSession.update("com.jdc.mapper.EmployeeMapper.deleteEmployeeById",4);
        sqlSession.commit();
        sqlSession.close();
    }

}

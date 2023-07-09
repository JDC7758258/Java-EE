package com.jdc.test;

import com.jdc.mapper.CustomerMapper;
import com.jdc.pojo.Customer;
import com.jdc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void findCustomerByUsernameAndJobsTest() {
        SqlSession session = MyBatisUtils.getSession();
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");

//        List<Customer> customers = customerMapper.findCustomerByUsernameAndJobs( customer);
        List<Customer> customers = session.selectList("com.jdc.mapper.CustomerMapper.findCustomerByUsernameAndJobs", customer);
        for (Customer c : customers) {
            System.out.println(c);
        }
        session.close();
    }

    @Test
    public void findCustomerByUsernameOrJobsTest() {
        SqlSession session = MyBatisUtils.getSession();
        //CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
//        List<Customer> customers = customerMapper.findCustomerByUsernameAndJobs( customer);
        List<Customer> customers = session.selectList("com.jdc.mapper.CustomerMapper.findCustomerByUsernameOrJobs", customer);
        for (Customer c : customers) {
            System.out.println(c);
        }
        session.close();
    }
@Test
    public void updateCustomerBySet(){
        SqlSession session = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("12354789359");
        int rows = session.update("com.jdc.mapper.CustomerMapper.updateCustomerBySet", customer);
        if(rows>0){
            System.out.println("修改了"+rows+"条数据");
        } else {
            System.out.println("没有修改数据");
        }
        session.commit();
        session.close();
    }

    @Test
    public void selectByArray(){
        SqlSession session = MyBatisUtils.getSession();
        Integer[] ids = {1,2,3};
        List<Customer> customers = session.selectList("com.jdc.mapper.CustomerMapper.selectByArray", ids);
        for (Customer c : customers) {
            System.out.println(c);
        }
        session.close();
    }

    @Test
    public void selectByList(){
        SqlSession session = MyBatisUtils.getSession();
        //Integer[] ids = {2,3};
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(3);
        List<Customer> customers = session.selectList("com.jdc.mapper.CustomerMapper.selectByList", ids);
        for (Customer c : customers) {
            System.out.println(c);
        }
        session.close();
    }

    @Test
    public void selectByMap(){
        SqlSession session = MyBatisUtils.getSession();
        Map<String,Object> map = new HashMap<String, Object>();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("id",ids);
        map.put("jobs","teacher");
        List<Customer> customers = session.selectList("com.jdc.mapper.CustomerMapper.selectByMap", map);
        for (Customer c : customers) {
            System.out.println(c);
        }
        session.close();
    }
}

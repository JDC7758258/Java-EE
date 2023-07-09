package com.jdc.mapper;

import com.jdc.pojo.Student;
import com.jdc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MyBatisTest {
    @Test
    public void findStudentByNameAndMajorTest(){
        SqlSession sqlSession = MyBatisUtils.sqlSession();
        Student student = new Student();
        student.setName("张三");
        student.setMajor("数学");
        List<Student> studentList = sqlSession.selectList("com.jdc.mapper.StudentMapper.findStudentByNameMajor", student);
        for(Student s:studentList){
            System.out.println(s);
        }
        sqlSession.close();
    }

    @Test
    public void findStudentByList(){
        SqlSession sqlSession = MyBatisUtils.sqlSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        List<Student> studentList = sqlSession.selectList("com.jdc.mapper.StudentMapper.findStudentByList", ids);
        for(Student s:studentList){
            System.out.println(s);
        }
        sqlSession.close();
    }
}

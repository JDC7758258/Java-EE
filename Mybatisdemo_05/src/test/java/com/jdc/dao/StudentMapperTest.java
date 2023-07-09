package com.jdc.dao;

import com.jdc.pojo.Student;
import com.jdc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @Test
    void selectStudent() {

        SqlSession session = MyBatisUtils.sqlSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.selectStudent(2);
        System.out.println(student);
        session.close();
    }
    @Test
    public void updateStudent(){
        SqlSession session = MyBatisUtils.sqlSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setName("李军");
        student.setAge(21);
        student.setId(4);
        int num = studentMapper.updateStudent(student);
        if (num>0){
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        session.commit();
        session.close();

    }
}
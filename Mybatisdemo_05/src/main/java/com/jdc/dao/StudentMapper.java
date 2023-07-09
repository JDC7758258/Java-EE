package com.jdc.dao;

import com.jdc.pojo.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student where id=#{id}")
    public Student selectStudent(int id);

    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    public int updateStudent(Student student);

    @Select("select * from student where cid=#{cid}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    public List<Student> selectStudentsById(int cid);
}

package com.jdc.dao;

import com.jdc.pojo.IClass;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IClassMapper {

    @Select("select * from class where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "className", column = "className"),
            @Result(property = "studentList", column = "id",
                    many = @Many(select = "com.jdc.dao.StudentMapper.selectStudentsById"))
    })
    public IClass selectIClassById(int id);
}

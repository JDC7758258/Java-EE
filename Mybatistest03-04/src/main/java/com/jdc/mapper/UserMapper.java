package com.jdc.mapper;

import com.jdc.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 接口式开发
 * 1.方法的名称需要保证和映射文件中的sql语句的statmentId一致
 * 2.namespace的值必须是接口的全路径
 */

public interface UserMapper {
//    public User findById(int id);
    public User findById(int id);

    public Integer findTotal();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}

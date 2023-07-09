package com.jdc.dao;

import com.jdc.pojo.Worker;
import org.apache.ibatis.annotations.Select;

public interface WorkerMapper {

    @Select("select * from tb_worker where id=#{id}")
    public Worker findWorker(int id);
}

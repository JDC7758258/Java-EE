package com.jdc.dao;

import com.jdc.pojo.Worker;
import com.jdc.utils.MyBatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkerMapperTest {

    private WorkerMapper workerMapper;
    private SqlSession session;

    @Before
    public void setUp(){
        session = MyBatisUtils.sqlSession();
        workerMapper = session.getMapper(WorkerMapper.class);
    }
    @Test
    public void testFindWorker() {
        Worker worker = workerMapper.findWorker(1);
        System.out.println(worker);
    }

    @After
    public void release(){
        session.close();
    }
}
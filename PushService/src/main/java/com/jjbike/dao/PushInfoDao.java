package com.jjbike.dao;

import com.jjbike.entity.push.PushInfo;
import com.jjbike.mapper.IPushInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PushInfoDao {
    private final SqlSession sqlSession;
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private IPushInfo iPushInfo;


    public PushInfoDao(SqlSession sqlSession) {
        this.sqlSession=sqlSession;
        iPushInfo=sqlSession.getMapper(IPushInfo.class);
    }

    public List<PushInfo> selectListByConditions(@Param(value = "condition") String condition){
        return iPushInfo.selectListByConditions(condition);
    }
}

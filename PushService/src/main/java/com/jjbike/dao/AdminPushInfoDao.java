package com.jjbike.dao;

import com.jjbike.entity.push.AdminPushInfo;
import com.jjbike.mapper.IAdminPushInfo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminPushInfoDao {
    private final SqlSession sqlSession;
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    private IAdminPushInfo iAdminPushInfo;

    public AdminPushInfoDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public AdminPushInfo selectAdminPushInfoByAdminId(String adminId){

        return iAdminPushInfo.findByAdminId(adminId);
    }



}

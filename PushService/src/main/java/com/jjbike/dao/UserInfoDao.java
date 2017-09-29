package com.jjbike.dao;


import com.jjbike.entity.push.UserInfo;
import com.jjbike.mapper.IUserInfo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDao {
    private final SqlSession sqlSession;
    private final Logger logger = LoggerFactory.getLogger(UserInfoDao.class);
    private IUserInfo iUserInfo;

    public UserInfoDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        iUserInfo = this.sqlSession.getMapper(IUserInfo.class);
    }

    public UserInfo getUserInfoById(String id){
        return iUserInfo.get(id);
    }

}

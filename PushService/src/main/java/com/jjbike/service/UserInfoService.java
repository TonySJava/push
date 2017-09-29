package com.jjbike.service;

import com.jjbike.dao.UserInfoDao;
import com.jjbike.entity.push.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoService {
    private UserInfoDao userInfoDao;

    @Autowired
    public UserInfoService(UserInfoDao userInfoDao){
        this.userInfoDao=userInfoDao;
    }


    public UserInfo getUserInfoById(String id){
        return userInfoDao.getUserInfoById(id);
    }

}

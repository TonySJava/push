package com.jjbike.service;


import com.jjbike.dao.PushInfoDao;
import com.jjbike.entity.push.PushInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushInfoService {
    private PushInfoDao pushInfoDao;

    @Autowired
    public PushInfoService(PushInfoDao pushInfoDao){
        this.pushInfoDao=pushInfoDao;
    }
    public List<PushInfo> selectListByConditions(@Param(value = "condition") String condition){
        return pushInfoDao.selectListByConditions(condition);
    }

}

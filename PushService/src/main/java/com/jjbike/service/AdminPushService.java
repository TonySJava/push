package com.jjbike.service;


import com.jjbike.dao.AdminPushInfoDao;
import com.jjbike.entity.push.AdminPushInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPushService {
    @Autowired
    private AdminPushInfoDao adminPushInfoDao;
    @Autowired
    public AdminPushService(AdminPushInfoDao adminPushInfoDao) {
        this.adminPushInfoDao = adminPushInfoDao;
    }

    public AdminPushInfo findByAdminId(String adminId){
        AdminPushInfo aa = adminPushInfoDao.selectAdminPushInfoByAdminId(adminId);
        return aa;
    }


}

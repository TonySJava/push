package com.jjbike.mapper;

import com.jjbike.entity.push.AdminPushInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IAdminPushInfo {
    Integer add(AdminPushInfo adminPushInfo);

    List<AdminPushInfo> list();

    AdminPushInfo findById(Integer id);

    AdminPushInfo isExisted(AdminPushInfo adminPushInfo);

    Integer count();

    AdminPushInfo findByAdminId(String adminId);

    Integer update(AdminPushInfo adminPushInfo);

    Integer delete(Integer id);
}

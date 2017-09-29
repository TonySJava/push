package com.jjbike.mapper;

import com.jjbike.entity.push.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserInfo {
    UserInfo get(String id);
}

package com.jjbike.mapper;


import com.jjbike.entity.push.PushInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IPushInfo {
    List<PushInfo> selectListByConditions(@Param(value = "condition") String condition);

}

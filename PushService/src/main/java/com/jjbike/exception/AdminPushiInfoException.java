package com.jjbike.exception;

import com.jjbike.enums.AdminPushiEnum;

public class AdminPushiInfoException extends BaseException{
    public AdminPushiInfoException(AdminPushiEnum adminPushiEnum ) {
        super(adminPushiEnum.getCode(),adminPushiEnum.getMsg());
        this.setCode(adminPushiEnum.getCode());
    }
}

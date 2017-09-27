package com.jjbike.exception;


import com.jjbike.enums.UserEnum;

public class UserException extends BaseException {
    public UserException(UserEnum userEnum) {
        super(userEnum.getCode(), userEnum.getMsg());
        this.setCode(userEnum.getCode());
    }

}

package com.jjbike.controller;


import com.jjbike.entity.Result;
import com.jjbike.entity.push.UserInfo;
import com.jjbike.service.UserInfoService;
import com.jjbike.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    private UserInfoService userInfoService;
    @Autowired
    public UserInfoController(UserInfoService userInfoService){
        this.userInfoService=userInfoService;
    }
    @GetMapping("/get")
    public Result findById( @RequestParam("id") String id){

        UserInfo userInfo=userInfoService.getUserInfoById(id);
        if (userInfo!=null){
            return ResultUtil.success(userInfo);
        }else {
            return ResultUtil.error(101,"失败！");
        }
    }


}

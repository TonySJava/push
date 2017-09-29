package com.jjbike.controller;


import com.jjbike.entity.push.AdminPushInfo;
import com.jjbike.entity.Result;
import com.jjbike.enums.AdminPushiEnum;
import com.jjbike.exception.AdminPushiInfoException;
import com.jjbike.service.AdminPushService;
import com.jjbike.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminPush")
@Api("userController相关api")
public class AdminPushController {
    private AdminPushService adminPushService;

    @Autowired
    public AdminPushController(AdminPushService adminPushService) {
        this.adminPushService = adminPushService;
    }

    @ApiOperation("根据ID查询用户信息")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "Long", required = true, value = "用户ID")
    @GetMapping(value = "/findById/{adminId}")
    public Result findById(@PathVariable("adminId") String adminId) throws AdminPushiInfoException {
        System.out.println(adminId);
        AdminPushInfo adminPushInfo = adminPushService.findByAdminId(adminId);
        if (adminPushInfo == null) {
            throw new AdminPushiInfoException(AdminPushiEnum.NOT_FOUND);
        }

        return ResultUtil.success(adminPushInfo);
    }





}

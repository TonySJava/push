package com.jjbike.service;


import com.jjbike.entity.push.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getUserInfoById() throws Exception{
        UserInfo userInfo=userInfoService.getUserInfoById("2c94bf815aa65346015aa66428cb000d");
        Assert.assertEquals("2c94bf815aa65346015aa66428cb000d",userInfo.getId());
        Assert.assertEquals("逐渐",userInfo.getRealName());

    }
}

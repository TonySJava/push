package com.jjbike.service;

import com.jjbike.entity.push.PushInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushInfoServiceTest {
    @Autowired
    private PushInfoService pushInfoService;

    @Test
    public void selectListByConditions()throws Exception{
        String groupName="老用户";
        List<PushInfo> pushInfos=pushInfoService.selectListByConditions(groupName);
        Assert.assertEquals(1,pushInfos.size());
        Assert.assertEquals("982de255b46d9a78c83396ac307ab97e",pushInfos.get(0).getDeviceToken());

    }
}

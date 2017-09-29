package com.jjbike.controller;


import com.gexin.rp.sdk.base.IPushResult;
import com.jjbike.entity.push.GtPushInfo;
import com.jjbike.entity.Result;
import com.jjbike.utils.ResultUtil;
import com.jjbike.utils.geTuiUtils.GtPushUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/gtPush")
@Api("GtPushController相关api")
public class GtPushController {


    @PostMapping("/pushSingle")
    public Result PushSingle(GtPushInfo gtPushInfo) {
        String cId = gtPushInfo.getcId();
        String appKey = gtPushInfo.getAppKey();
        String appId = gtPushInfo.getAppId();
        String masterSecret = gtPushInfo.getMasterSecret();
        String title = gtPushInfo.getTitle();
        String text = gtPushInfo.getText();
        System.out.println(gtPushInfo.toString());
        if (cId != null && appId != null && appKey != null && masterSecret != null) {
            IPushResult ret = GtPushUtils.pushSingle(cId, appId, appKey, title, text, masterSecret);
            System.out.println(ret.getResponse().toString());
            Map reMap = ret.getResponse();
            if (reMap.get("result").equals("ok")){
                return ResultUtil.success(reMap);
            } else {
                return ResultUtil.error(101,"失败!");
            }
        } else {
            return ResultUtil.error(101,"失败!");
        }
    }



    @GetMapping("/pushSingleIos")
    public Result PushSingleIos(String cId, String appKey, String appId, String masterSecret, String title, String text){
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null){
            IPushResult ret= GtPushUtils.pushMessageToSingleIOSSimple(appKey,appId,masterSecret,cId,title,text);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (reMap.get("result").equals("ok")){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败！");
        }
    }

    @GetMapping("/pushSingleAnd")
    public Result PushSingleAnd(String cId,String appKey,String appId,String masterSecret,String title,String text){
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null){
            IPushResult ret= GtPushUtils.pushMessageToSingleAndroidSimple(appKey,appId,masterSecret,cId,title,text);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (reMap.get("result").equals("ok")){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败！");
        }
    }


    @GetMapping("/pushUrlIos")
    public Result PushUrlIos(String cId,String appKey,String appId,String masterSecret,String url,String title,String text){
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null){
            IPushResult ret=GtPushUtils.pushUrlToSingleIOSSimple(appKey,appId,masterSecret,cId,title,text,url);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (reMap.get("result").equals("ok")){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败！");
        }
    }

    @PostMapping("/pushUrlAnd")
    public Result PushUrlAnd(GtPushInfo gtPushInfo){
        Map<String, Object> map = new HashMap<>();
        String cId = gtPushInfo.getcId();
        String appKey = gtPushInfo.getAppKey();
        String appId = gtPushInfo.getAppId();
        String masterSecret = gtPushInfo.getMasterSecret();
        String url = gtPushInfo.getUrl();
        String title = gtPushInfo.getTitle();
        String text = gtPushInfo.getText();
        map.put("url", url);
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null){
            IPushResult ret=GtPushUtils.pushUrlToSingleAndroidSimple(appKey,appId,masterSecret,cId,title,text,url);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (reMap.get("result").equals("ok")){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败！");
        }
    }

    @ApiOperation("单推IOS嵌入url")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId", required = true, value = "用户cid", dataType = "GtPushInfo"),
            @ApiImplicitParam(name = "appKey", required = true, value = "appKey", dataType = "GtPushInfo"),
            @ApiImplicitParam(name = "appId", required = true, value = "appId", dataType = "GtPushInfo"),
            @ApiImplicitParam(name = "masterSecret", required = true, value = "appKey", dataType = "GtPushInfo"),
            @ApiImplicitParam(name = "title", value = "appKey", dataType = "GtPushInfo"),
            @ApiImplicitParam(name = "text", value = "text", dataType = "GtPushInfo"),
    })
    @PostMapping("/pushContentUrlIos")
    public Result PushContentUrlIos(GtPushInfo gtPushInfo) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String cId = gtPushInfo.getcId();
        String appKey = gtPushInfo.getAppKey();
        String appId = gtPushInfo.getAppId();
        String masterSecret = gtPushInfo.getMasterSecret();
        String url = gtPushInfo.getUrl();
        String title = gtPushInfo.getTitle();
        String text = gtPushInfo.getText();
        map.put("url", url);
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null&&cId!=""&&appId!=""&&appKey!=""&&masterSecret!=""){
            IPushResult ret=GtPushUtils.pushMessageToSingleIOS(appKey,appId,masterSecret,cId,title,text,map);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (("ok").equals(reMap.get("result"))){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败");
        }


    }

    /**
     * 单推安卓嵌入url
     * @param gtPushInfo
     * @return
     * @throws IOException
     */
    @PostMapping("/pushContentUrlAnd")
    public Result PushContentUrlAnd(GtPushInfo gtPushInfo) throws IOException {

        Map<String, Object> map = new HashMap<>();
        String cId = gtPushInfo.getcId();
        String appKey = gtPushInfo.getAppKey();
        String appId = gtPushInfo.getAppId();
        String masterSecret = gtPushInfo.getMasterSecret();
        String url = gtPushInfo.getUrl();
        String title = gtPushInfo.getTitle();
        String text = gtPushInfo.getText();
        map.put("url",url);
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null&&cId!=""&&appId!=""&&appKey!=""&&masterSecret!=""){
            IPushResult ret=GtPushUtils.pushMessageToSingleAndroid(appKey,appId,masterSecret,cId,title,text,map);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (("ok").equals(reMap.get("result"))){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败");
        }


    }

    @PostMapping("/pushContentUrl")
    public Result PushContentUrl(GtPushInfo gtPushInfo) throws IOException {

        Map<String, Object> map = new HashMap<>();
        String cId = gtPushInfo.getcId();
        String appKey = gtPushInfo.getAppKey();
        String appId = gtPushInfo.getAppId();
        String masterSecret = gtPushInfo.getMasterSecret();
        String url = gtPushInfo.getUrl();
        String title = gtPushInfo.getTitle();
        String text = gtPushInfo.getText();
        map.put("url",url);
        if (cId!=null&&appId!=null&&appKey!=null&&masterSecret!=null&&cId!=""&&appId!=""&&appKey!=""&&masterSecret!=""){
            IPushResult ret=GtPushUtils.pushMessageToSingleAndroid(appKey,appId,masterSecret,cId,title,text,map);
            IPushResult result=GtPushUtils.pushMessageToSingleIOS(appKey,appId,masterSecret,cId,title,text,map);
            System.out.println(ret.getResponse().toString());
            System.out.println(result.getResponse().toString());
            Map reMap=ret.getResponse();
            Map resultMap=result.getResponse();
            if (("ok").equals(reMap.get("result"))&&("ok").equals(resultMap.get("result"))){
                Map resMap=new HashMap();
                resMap.put("result1",reMap);
                resMap.put("result2",resultMap);
                return ResultUtil.success(resMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败");
        }

    }
    @PostMapping("/pushAll")
    public Result PushAll(GtPushInfo gtPushInfo) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String appKey = gtPushInfo.getAppKey();
        String appId = gtPushInfo.getAppId();
        String masterSecret = gtPushInfo.getMasterSecret();
        String url = gtPushInfo.getUrl();
        String title = gtPushInfo.getTitle();
        String text = gtPushInfo.getText();
        map.put("url",url);
        List<String> areaNos=gtPushInfo.getAreaNos();
        if (appId!=null&&appKey!=null&&masterSecret!=null&&appId!=""&&appKey!=""&&masterSecret!=""){
            IPushResult ret=GtPushUtils.pushAll(appKey,appId,masterSecret,title,text,map,areaNos);
            System.out.println(ret.getResponse().toString());
            Map reMap=ret.getResponse();
            if (("ok").equals(reMap.get("result"))){
                return ResultUtil.success(reMap);
            }else {
                return ResultUtil.error(101,"失败");
            }
        }else {
            return ResultUtil.error(101,"失败");
        }
    }



}

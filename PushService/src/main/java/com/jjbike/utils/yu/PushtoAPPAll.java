//package com.jjbike.utils.yu;
//
///**
// * Created by Administrator on 2017-07-11.
// */
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import com.gexin.rp.sdk.base.IPushResult;
//import com.gexin.rp.sdk.base.impl.AppMessage;
//import com.gexin.rp.sdk.base.uitls.AppConditions;
//import com.gexin.rp.sdk.http.IGtPush;
//import com.gexin.rp.sdk.template.NotificationTemplate;
//import com.gexin.rp.sdk.template.TransmissionTemplate;
//import com.thinkgem.jeesite.common.mapper.JsonMapper;
//import com.thinkgem.jeesite.common.utils.StringUtils;
//import com.thinkgem.jeesite.modules.electric.entity.tpushplan.TPushPlan;
//import com.thinkgem.jeesite.modules.electric.utils.apppush.pushtool.Constant;
//import com.thinkgem.jeesite.modules.electric.utils.apppush.pushtool.TempleteUtil;
//
//public class PushtoAPPAll {
//    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
//    public static Map<String,IPushResult> pushToAPPAll(TPushPlan tPushPlan) throws Exception {
//     //创建模板
//      Map shareInfo=new HashMap();
//      String aUrl=null;
//      if(tPushPlan.getActivitiesInfo()!=null && StringUtils.isNotBlank(tPushPlan.getActivitiesInfo().getActivityPath())){
//        shareInfo.put("sharePlatform",tPushPlan.getActivitiesInfo().getSharePlatform());
//        shareInfo.put("shareTitle",tPushPlan.getActivitiesInfo().getShareTitle());
//        shareInfo.put("sharePic",tPushPlan.getActivitiesInfo().getSharePic());
//        shareInfo.put("shareContent",tPushPlan.getActivitiesInfo().getShareContent());
//        shareInfo.put("activityPath",tPushPlan.getActivitiesInfo().getActivityPath());
//      }
//      aUrl=JsonMapper.toJsonString(shareInfo);
//      if(StringUtils.isNotBlank(aUrl) && shareInfo.size()>0){
//        aUrl=Constant.APPHEADER+aUrl;
//      }else{
//        aUrl="";
//      }
//
//      IPushResult result1=  pushToAPPAllToAndroid(tPushPlan,aUrl);
//        IPushResult result2=  pushToAPPAllToIOS(tPushPlan,shareInfo);
//      Map<String,IPushResult> resultList=new HashMap<>();
//      resultList.put(Constant.APP_PHONE_TYPE_ANDROID,result1);
//      resultList.put(Constant.APP_PHONE_TYPE_IOS,result2);
//      return  resultList;
//    }
//    public static IPushResult pushToAPPAllToIOS(TPushPlan tPushPlan,Map param) throws Exception {
//     //创建个推HTTP实例
//     IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
//     TransmissionTemplate template= TempleteUtil.transmissionTempToIOS(tPushPlan.getAppPushContent(),param);
//     //创建消息实体
//     AppMessage message=new AppMessage();
//     message.setData(template);
//     message.setOffline(true);
//     //离线有效时间，单位为毫秒，可选
//     message.setOfflineExpireTime(0);
//     //推送给App的目标用户需要满足的条件
//     AppConditions cdt = new AppConditions();
//     List<String> appIdList = new ArrayList<>();
//     appIdList.add(Constant.APPID);
//     message.setAppIdList(appIdList);
//     //手机类型
//     List<String> phoneTypeList = new ArrayList<>();
//     phoneTypeList.add(Constant.APP_PHONE_TYPE_IOS);
//     //省份
//     List<String> provinceList = new ArrayList<>();
//        if(tPushPlan!=null && StringUtils.isNotBlank(tPushPlan.getArea().getPushCode())){
//            provinceList.add(tPushPlan.getArea().getPushCode());
//        }
//     //自定义tag
//     List<String> tagList = new ArrayList<>();
//     cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
//     cdt.addCondition(AppConditions.REGION, provinceList);
//     cdt.addCondition(AppConditions.TAG,tagList);
//     message.setConditions(cdt);
//     IPushResult pushResult=push.pushMessageToApp(message);
//     System.out.println("全推任务Id="+pushResult.getTaskId()+"接收到的消息体："+pushResult.getResponse());
//     return  pushResult;
// }
//    public static IPushResult pushToAPPAllToAndroid(TPushPlan tPushPlan,String aUrl) throws Exception {
//       //创建个推HTTP实例
//       IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
//       //创建模板
//       NotificationTemplate template=TempleteUtil.notificationTemplateToAndroid(tPushPlan.getAppPushContent(),aUrl);//"11#"+JsonMapper.toJsonString(shareInfo)
//       //创建消息实体
//       AppMessage message=new AppMessage();
//       message.setData(template);
//       message.setOffline(true);
//       //离线有效时间，单位为毫秒，可选
//       message.setOfflineExpireTime(24 * 1000 * 3600);
//       //推送给App的目标用户需要满足的条件
//       AppConditions cdt = new AppConditions();
//       List<String> appIdList = new ArrayList<>();
//       appIdList.add(Constant.APPID);
//       message.setAppIdList(appIdList);
//       //手机类型
//       List<String> phoneTypeList = new ArrayList<>();
//       phoneTypeList.add(Constant.APP_PHONE_TYPE_ANDROID);
//        //省份
//        List<String> provinceList = new ArrayList<>();
//        if(tPushPlan!=null && StringUtils.isNotBlank(tPushPlan.getArea().getPushCode())){
//            if(!"0".equals(tPushPlan.getArea().getPushCode())){
//                provinceList.add(tPushPlan.getArea().getPushCode());
//            }
//        }
//
//       //自定义tag
//       List<String> tagList = new ArrayList<>();
//       cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
//       cdt.addCondition(AppConditions.REGION, provinceList);
//       cdt.addCondition(AppConditions.TAG,tagList);
//       message.setConditions(cdt);
//       IPushResult pushResult=push.pushMessageToApp(message);
//       System.out.println("全推任务Id="+pushResult.getTaskId()+"接收到的消息体："+pushResult.getResponse());
//       return  pushResult;
// }
//
//
////
////    public static void main(String args[]){
////        String str="热浪来袭！赳赳单车提醒您,高温天气出行注意避暑防晒";
////        try {
//////            IPushResult result1=  pushToAPPAllToIOS(str);
//////            IPushResult result2=  pushToAPPAllToAndroid(str);
//////            System.out.println(result.getResponse());
//////            System.out.println("任务ID"+result.getTaskId());
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
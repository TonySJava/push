//package com.jjbike.utils.yu;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import com.gexin.rp.sdk.base.IPushResult;
//import com.gexin.rp.sdk.base.impl.ListMessage;
//import com.gexin.rp.sdk.base.impl.Target;
//import com.gexin.rp.sdk.http.IGtPush;
//import com.gexin.rp.sdk.template.NotificationTemplate;
//import com.gexin.rp.sdk.template.TransmissionTemplate;
//import com.thinkgem.jeesite.common.utils.StringUtils;
//import com.thinkgem.jeesite.modules.electric.entity.tpushplan.TPushPlan;
//import com.thinkgem.jeesite.modules.electric.utils.apppush.pushtool.Constant;
//import com.thinkgem.jeesite.modules.electric.utils.apppush.pushtool.TempleteUtil;
//
//public class PushToCidList {
//    /**
//     * 批量群推
//     * @param pushPlan 发送内容
//     * @param cIds 设备ID的list 1-50个
//     * @return
//     */
//    public static IPushResult pushToCidList(TPushPlan pushPlan, List<String> cIds){//批量推送的数量在1至50之间（包括50）
//        if(cIds!=null && cIds.size()>0 && cIds.size()<=50){
//            IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
//           // NotificationTemplate template= TempleteUtil.notificationTemplateDemo(pushPlan.getAppPushContent());
//           TransmissionTemplate template= TempleteUtil.transmissionTemplateDemo(pushPlan.getAppPushContent());
//            ListMessage message = new ListMessage();
//            message.setData(template);
//            // 设置消息离线，并设置离线时间
//            message.setOffline(true);
//            // 离线有效时间，单位为毫秒，可选
//            message.setOfflineExpireTime(24 * 1000 * 3600);
//            List targets = new ArrayList();
//            String taskId="";
//            if(StringUtils.isNotBlank(pushPlan.getContentId())){
//                taskId = pushPlan.getContentId();
//            }else{
//                taskId = push.getContentId(message);
//            }
//            for(String cId:cIds){
//                Target target1 = new Target();
//                target1.setAppId(Constant.APPID);
//                target1.setClientId(cId);
//                targets.add(target1);
//            }
//            return push.pushMessageToList(taskId, targets);
//        }else{
//            return null;
//        }
//    }
//
////    public static void main(String[] args) {
////        String content="6# 炎炎夏日，赳赳单车助您轻松出行！";
////        List<String> list=new ArrayList<>();
////        list.add("625c538d0bc733ae9f4847f23fa8dc1c");
////        IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
////        NotificationTemplate template= TempleteUtil.notificationTemplateDemo(content);//TempleteUtil.transmissionTemplateDemo(pushPlan.getAppPushContent());
////        ListMessage message = new ListMessage();
////        message.setData(template);
////        // 设置消息离线，并设置离线时间
////        message.setOffline(true);
////        // 离线有效时间，单位为毫秒，可选
////        message.setOfflineExpireTime(24 * 1000 * 3600);
////        List targets = new ArrayList();
////        String taskId="";
////        taskId = push.getContentId(message);
////        for(String cId:list){
////            Target target1 = new Target();
////            target1.setAppId(Constant.APPID);
////            target1.setClientId(cId);
////            targets.add(target1);
////        }
////        IPushResult pushResult= push.pushMessageToList(taskId, targets);
////        Map map=pushResult.getResponse();
////        System.out.println(pushResult.getResponse());
////    }
//
//}

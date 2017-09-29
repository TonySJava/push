package com.jjbike.utils.geTuiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gexin.rp.sdk.base.uitls.AppConditions;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;


/**
 * @author harry.zhang
 * @version 1.0
 * @Description: 个推工具类
 * @CreateDate: 2017年7月12日
 */
public class GtPushUtils {

    public static Logger logger = LoggerFactory.getLogger(GtPushUtils.class);


    /**
     * 停止
     *
     * @param host         标题
     * @param appkey       内容
     * @param mastersecret 链接
     * @param taskid       任务id
     * @return IPushResult
     */

    public static boolean stopTask(String host, String appkey, String mastersecret, String taskid) {
        IGtPush push = new IGtPush(host, appkey, mastersecret);
        boolean result = push.stop(taskid);
        return result;
    }

    public static IPushResult pushSingle(String cId,String appId,String appKey,String title,String text,String masterSecret){
//        IGtPush push = new IGtPush(appKey, masterSecret, false);
//        TransmissionTemplate template=MessgeTemplate.getTransmissionTemplateIOSSimple(appId,appKey,title,text);
        IGtPush push = new IGtPush(appKey,masterSecret,false);
            TransmissionTemplate template =MessgeTemplate.transmissionTemplateToSingle(appId,appKey,text,title);
            SingleMessage message = new SingleMessage();
            message.setOffline(true);
            // 离线有效时间，单位为毫秒，可选
            message.setOfflineExpireTime(24 * 3600 * 1000);
            message.setData(template);
            message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
            Target target = new Target();
            target.setAppId(appId);
            target.setClientId(cId);
            // 用户别名推送，cid和用户别名只能2者选其一
            IPushResult ret = push.pushMessageToSingle(message, target);
//            System.out.println(ret.getResponse().toString());
            if (ret != null) {
                logger.info(ret.getResponse().toString());
            } else {
                logger.error("消息服务器异常  pushMessageToAllIOS messge fail");
            }
            return ret;

    }

    /**
     * 全推
     *
     * @param title 标题
     * @param text  内容
     * @param map   链接
     * @return IPushResult
     */
    public static IPushResult pushAll(String appKey, String appId, String masterSecret, String title, String text, Map map, List<String> areaNos) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        AppMessage toAppmessage = AppPushMessage.getAppMessageAllIOS(appId, appKey, title, text, map);
        AppConditions cdt = new AppConditions();
        List<String> appIdList = new ArrayList<String>();
        appIdList.add(appId);
        toAppmessage.setAppIdList(appIdList);
        //手机类型
        List<String> phoneTypeList = new ArrayList<String>();
        phoneTypeList.add("ANDROID");
        phoneTypeList.add("IOS");
        //省份
        List<String> provinceList = new ArrayList<String>();
        for (String city : areaNos) {
            provinceList.add(city);
        }
        //自定义tag
//      List<String> tagList = new ArrayList<String>();
        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
        cdt.addCondition(AppConditions.REGION, provinceList);
//      cdt.addCondition(AppConditions.TAG, tagList);
        toAppmessage.setConditions(cdt);
        IPushResult ret = push.pushMessageToApp(toAppmessage);
        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToAllIOS messge fail");
        }
        return ret;
    }

    /**
     * 推送所有用户Android
     *
     * @param title 标题
     * @param text  内容
     * @param url   链接
     * @return IPushResult
     */
    public static IPushResult pushMessageToAllAndroid(String appKey, String appId, String masterSecret, String title, String text, String url,String...areaNo) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, false);
        AppMessage toAppmessage = AppPushMessage.getAppMessageAllAndroid(appId, appKey, title, text, url);
        AppConditions cdt = new AppConditions();
        List<String> appIdList = new ArrayList<String>();
        appIdList.add(appId);
        toAppmessage.setAppIdList(appIdList);
        //手机类型
//        List<String> phoneTypeList = new ArrayList<String>();
        //省份
        List<String> provinceList = new ArrayList<String>();
        for (String city : areaNo) {
            provinceList.add(city);
        }
        //自定义tag
//        List<String> tagList = new ArrayList<String>();
//        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
        cdt.addCondition(AppConditions.REGION, provinceList);
//        cdt.addCondition(AppConditions.TAG, tagList);
        toAppmessage.setConditions(cdt);
        IPushResult ret = push.pushMessageToApp(toAppmessage);
        if (ret != null) {

            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToAllAndroid messge fail");
        }
        return ret;

    }

    /**
     * 推送所有用户IOS
     *
     * @param title 标题
     * @param text  内容
     * @param map   链接
     * @return IPushResult
     */
    public static IPushResult pushMessageToAllIOS(String appKey, String appId, String masterSecret, String title, String text, Map map, String... areaNo) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        AppMessage toAppmessage = AppPushMessage.getAppMessageAllIOS(appId, appKey, title, text, map);
        AppConditions cdt = new AppConditions();
        List<String> appIdList = new ArrayList<String>();
        appIdList.add(appId);
        toAppmessage.setAppIdList(appIdList);
        //手机类型
//        List<String> phoneTypeList = new ArrayList<String>();
        //省份
        List<String> provinceList = new ArrayList<String>();
        for (String city : areaNo) {
            provinceList.add(city);
        }
        //自定义tag
//        List<String> tagList = new ArrayList<String>();

//        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
        cdt.addCondition(AppConditions.REGION, provinceList);
//        cdt.addCondition(AppConditions.TAG, tagList);
        toAppmessage.setConditions(cdt);
        IPushResult ret = push.pushMessageToApp(toAppmessage);
        if (ret != null) {

            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToAllIOS messge fail");
        }
        return ret;

    }

    /**
     * 推送指定用户Android
     *
     * @param cid
     * @param title         标题
     * @param text          内容
     * @param customContent 透传信息
     * @return IPushResult
     */
    public static IPushResult pushMessageToSingleAndroid(String appKey, String appId, String masterSecret, String cid, String title, String text, Map<String, Object> customContent) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        SingleMessage message = AppPushMessage.getAppMessageSingleAndroid(appId, appKey, title, text, customContent);

        IPushResult ret = null;
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        try {
            ret = push.pushMessageToSingle(message, target);
            logger.info(ret.getResponse().toString());
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("pushMessageToSingleAndroid messge fail", e);
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        return ret;

    }

    /**
     * 推送url指定用户IOS
     *
     * @param cid
     * @param title 标题
     * @param text  内容
     * @param
     * @return IPushResult
     */
    public static IPushResult pushUrlToSingleIOSSimple(String appKey, String appId, String masterSecret, String cid, String title, String text, String url) {

        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, false);
        SingleMessage message = new SingleMessage();
        LinkTemplate template = MessgeTemplate.getlinkTemplateIOS(appId, appKey, title, text, url);
        message.setData(template);
        IPushResult ret = null;
        // 配置推送目标
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("消息服务器响应异常", e.getMessage());
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }

        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToSingleIOS messge fail");
        }
        return ret;

    }

    /**
     * 推送url指定用户Android
     *
     * @param cid
     * @param title 标题
     * @param text  内容
     * @param
     * @return IPushResult
     */
    public static IPushResult pushUrlToSingleAndroidSimple(String appKey, String appId, String masterSecret, String cid, String title, String text, String url) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
//		SingleMessage message = AppPushMessage.getAppMessageSingleAndroidSimple(appId, appKey, title, text);
        SingleMessage message = new SingleMessage();
        LinkTemplate template = MessgeTemplate.getlinkTemplateAndroid(appId, appKey, title, text, url);
        message.setData(template);
        IPushResult ret = null;
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        try {
            ret = push.pushMessageToSingle(message, target);
            logger.info(ret.getResponse().toString());
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("pushMessageToSingleAndroid messge fail", e);
            ret = push.pushMessageToSingle(message, target, e.getRequestId());

        }
        return ret;

    }

    /**
     * 推送指定用户Android
     *
     * @param cid
     * @param title 标题
     * @param text  内容
     * @param
     * @return IPushResult
     */
    public static IPushResult pushMessageToSingleAndroidSimple(String appKey, String appId, String masterSecret, String cid, String title, String text) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        SingleMessage message = AppPushMessage.getAppMessageSingleAndroidSimple(appId, appKey, title, text);

        IPushResult ret = null;
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        try {
            ret = push.pushMessageToSingle(message, target);
            logger.info(ret.getResponse().toString());
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("pushMessageToSingleAndroid messge fail", e);
            ret = push.pushMessageToSingle(message, target, e.getRequestId());

        }
        return ret;

    }

    /**
     * 对指定用户推送消息IOS
     *
     * @param cid
     * @param title         标题
     * @param text          内容
     * @param customContent 透传信息
     * @return IPushResult
     */
    public static IPushResult pushMessageToSingleIOS(String appKey, String appId, String masterSecret, String cid, String title, String text, Map<String, Object> customContent) {

        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, false);
        SingleMessage message = AppPushMessage.getAppMessageSingleIOS(appId, appKey, title, text, customContent);
        IPushResult ret = null;
        // 配置推送目标
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("消息服务器响应异常", e.getMessage());
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }

        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToSingleIOS messge fail");
        }
        return ret;

    }

    public static IPushResult pushMessageToSingleIOSSimple(String appKey, String appId, String masterSecret, String cid, String title, String text) {

        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, false);
        SingleMessage message = AppPushMessage.getAppMessageSingleIOSSimple(appId, appKey, title, text);
        IPushResult ret = null;
        // 配置推送目标
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("消息服务器响应异常", e.getMessage());
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }

        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToSingleIOS messge fail");
        }
        return ret;

    }


    /**
     * 推送指定别名用户Android
     *
     * @param alias
     * @param title         标题
     * @param text          内容
     * @param customContent 透传信息
     * @return IPushResult
     */
    public static IPushResult pushMessageToSingleAliasAndroid(String appKey, String appId, String masterSecret, String alias, String title, String text, Map<String, Object> customContent) {
        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        SingleMessage message = AppPushMessage.getAppMessageSingleAndroid(appId, appKey, title, text, customContent);

        IPushResult ret = null;
        Target target = new Target();
        target.setAppId(appId);
        target.setAlias(alias);
        try {
            ret = push.pushMessageToSingle(message, target);
            logger.info(ret.getResponse().toString());
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("pushMessageToSingleAndroid messge fail", e);
            ret = push.pushMessageToSingle(message, target, e.getRequestId());

        }
        return ret;

    }

    /**
     * 对指定别名用户推送消息IOS
     *
     * @param alias
     * @param title         标题
     * @param text          内容
     * @param customContent 透传信息
     * @return IPushResult
     */
    public static IPushResult pushMessageToSingleAliasIOS(String appKey, String appId, String masterSecret, String alias, String title, String text, Map<String, Object> customContent) {

        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        SingleMessage message = AppPushMessage.getAppMessageSingleIOS(appId, appKey, title, text, customContent);
        IPushResult ret = null;
        // 配置推送目标
        Target target = new Target();
        target.setAppId(appId);
        target.setAlias(alias);
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            logger.error("消息服务器响应异常", e.getMessage());
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }

        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToSingleIOS messge fail");
        }
        return ret;

    }

    /**
     * 对指定列表用户推送消息Android
     *
     * @param cids
     * @param title         标题
     * @param text          内容
     * @param customContent 透传信息
     * @return IPushResult
     */
    public static IPushResult pushMessageToListAndroid(String appKey, String appId, String masterSecret, List<String> cids, String title, String text, Map<String, Object> customContent) {

        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        ListMessage message = AppPushMessage.getAppMessageListAndroid(appId, appKey, title, text, customContent);
        // 配置推送目标
        List<Target> targets = new ArrayList<Target>();
        for (String cid : cids) {
            Target target = new Target();
            target.setAppId(appId);
            target.setClientId(cid);
            targets.add(target);
        }
        // taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);
        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToListAndroid messge fail");
        }
        return ret;

    }

    /**
     * 对指定列表用户推送消息IOS
     *
     * @param cids
     * @param title         标题
     * @param text          内容
     * @param customContent 透传信息
     * @return IPushResult
     */
    public static IPushResult pushMessageToListIOS(String appKey, String appId, String masterSecret, List<String> cids, String title, String text, Map<String, Object> customContent) {

        // 此处true为https域名，false为http，默认为false。Java语言推荐使用此方式
        // IGtPush push = new IGtPush(host, appkey, master);
        // host为域名，根据域名区分是http协议/https协议
        IGtPush push = new IGtPush(appKey, masterSecret, true);
        ListMessage message = AppPushMessage.getAppMessageListIOS(appId, appKey, title, text, customContent);
        // 配置推送目标
        List<Target> targets = new ArrayList<Target>();
        for (String cid : cids) {
            Target target = new Target();
            target.setAppId(appId);
            target.setClientId(cid);
            targets.add(target);
        }
        // taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);
        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.error("消息服务器异常  pushMessageToListIOS messge fail");
        }
        return ret;

    }


}

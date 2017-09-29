//package com.jjbike.utils.yu;
//
//import com.gexin.rp.sdk.base.IPushResult;
//import com.gexin.rp.sdk.base.impl.SingleMessage;
//import com.gexin.rp.sdk.base.impl.Target;
//import com.gexin.rp.sdk.http.IGtPush;
//import com.gexin.rp.sdk.template.NotificationTemplate;
//import com.gexin.rp.sdk.template.TransmissionTemplate;
//import com.thinkgem.jeesite.modules.electric.utils.apppush.pushtool.Constant;
//import com.thinkgem.jeesite.modules.electric.utils.apppush.pushtool.TempleteUtil;
//
//import java.io.IOException;
//
//public class AppPush {
//
//	public static void pushsingle(String cid, String content) {
//
//		IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY,
//				Constant.MASTER);
//		try {
//			push.connect();
//			TransmissionTemplate template = TempleteUtil.transmissionTemplateDemo(content);
//		//	NotificationTemplate template= TempleteUtil.notificationTemplateDemo(content);
//			SingleMessage message = new SingleMessage();
//			message.setOffline(false);
//			// 离线有效时间，单位为毫秒，可选
//			message.setOfflineExpireTime(24 * 3600 * 1000);
//			message.setData(template);
//			message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
//			Target target = new Target();
//			target.setAppId(Constant.APPID);
//			target.setClientId(cid);
//			// 用户别名推送，cid和用户别名只能2者选其一
//			IPushResult ret = push.pushMessageToSingle(message, target);
//			//System.out.println(ret.getResponse().toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//
//
//
//
//	/*public static void main(String args[]) {
//		System.out.println("zhangyu------------------");
//		// pushsingle("029067ddeaeaab32a2122f6c90267899","nihao!zhangyuceshi");
//	}
//*/
//}

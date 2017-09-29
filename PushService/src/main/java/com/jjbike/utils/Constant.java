/**
 * 
 */
package com.jjbike.utils;

import java.math.BigDecimal;

public class Constant {

	
	/**
	 * 给用户发推送
	 */
	public static final String PUSHTOUSERS = "PUSHTOUSERS";
	
	
	/**
	 * 给用户发短信
	 */
	public static final String SMSTOUSERSBYUERIDS = "SMSTOUSERSBYUERIDS";
	
	/**
	 * 给用户发短信
	 */
	public static final String SMSTOUSERSBYPHONES = "SMSTOUSERSBYPHONES";
	
	
	/**
	 * 红押金提现
	 */
	public static final String REFUND = "REFUND";
	
	/**
	 * 红包提现
	 */
	public static final String LUCKYMONEYDRAWINGS = "LUCKYMONEYDRAWINGS";
	
	/**
	 * 红包转账
	 */
	public static final String LUCKYMONEYTRANSFER = "LUCKYMONEYTRANSFER";
	
	
	/**
	 * 广告获得现金红包
	 */
	public static final String ADGETLUCKYMONEY = "ADGETLUCKYMONEY";
	
	
	
	/************************ 站点模块接口名 *****************************/

	public static final String GETPOSSTATIONINFO = "GETPOSSTATIONINFO";
	
	/********************************* 活动模块 *****************************/

	/************************ 系统模块接口名 *****************************/
	/**
	 * 获取验证码接口
	 */
	public static final String GETVERIFYCODE = "GETVERIFYCODE";

	/**
	 * 美食和景点
	 */
//	public static final String FOODANDSPOTS = "FOODANDSPOTS";
	
	/****************** 验证码短信配置 ********************/
	/**
	 * 普讯服务器接口地址
	 */
	public static final String SMS_ADDRESS = "http://202.91.244.252/qd/SMSSendYD?usr=";

	/**
	 * 普讯用户账号
	 */
	//public static final String SMS_USER = "7188";
	public static final String SMS_USER = "5312";

	/**
	 * 普讯密码
	 */
	//public static final String SMS_PWD = "qyuan@7188zj";
	public static final String SMS_PWD = "JIU5312jiu";
	
	public static final String CHECKPHONEKEY = "3bd2b90c88abc01053adf8cac6695ef3";

	/****************** socket编程 ********************/

	/**
	 * 本机端口 联通
	 */
	public static final String SOCKET_IP = "127.0.0.1";

	public static String TCFLAG = "0";
	
	public static final String BORROWFLAG = "6";
	
	public static final String RECESSIONFLAG = "7";
	/**
	 * 程序端口号
	 */
	public static final int SOCKET_PORT = 4009;
	
	public static final String LIMITMONEY = "200";
	
	public static final String CLIMITMONEY = "2";

	/**************************** 银联支付配置信息 *****************************/

	/**
	 * 银联编码
	 */
	public static final String UNOPENCODING = "GBK";

	/**
	 * 商户号码
	 */
	public static final String UNOPMERID = "自己定义";
	
	public static final String COMPANYPHONE = "0572-2055372";	

	/**
	 * 银联接口版本号
	 */
	public static final String UNOPVERSION = "5.0.0";

	// 后台服务对应的写法参照 FrontRcvResponse.java
	public static final String FRONTURL = "";

	/************************ 个推信息 正式 *************************/
//	// 个推ID
//	public static final String APPID = "7p3DNaqLEs9SHibAhV1yk5";
//	// 个推密钥
//	public static final String APPKEY = "9rdE0noxIr8m521E5FIOl4";
//	public static final String MASTER = "mH0H8nKaCsAcuueRFkTpl2";
	// 头信息
	public static final String APP_PHONE_TYPE_ANDROID = "ANDROID";
	// 手机类型 苹果
	public static final String APP_PHONE_TYPE_IOS= "IOS";
	// 手机类型 安卓
	// 接口地址
	public static final String HOST = "http://sdk.open.api.igexin.com/apiex.htm";
	//个推标题栏
	public  static final  String APPTITLE="";
	public  static final  String APPHEADER="11#";
	public  static final  String APPHEADERNUM="11";

	/*********************************APP个推测试****************************************/
////	// 个推ID
	public static final String APPID = "CWUEuP6kQH8LSlVnGphZL6";

	// 个推密钥
	public static final String APPKEY = "Zz2WfGfpXt9KoLAQY9QaZ";

	// 头信息
	public static final String MASTER = "VZbva4fWj267ESiVZWOR34";

	/*********************************赳猎人个推测试****************************************/


	/****************************** 微信支付信息 ******************************/
	// 移动应用ID（骐远--骐客）
	public static final String WXAPPID = "wx5a008c78857c70ec";

	// 商户ID（骐远--骐客）
	public static final String WXMCH_ID = "1461111202";

	// 商品显示主题
	public static final String WXBODY = "赳赳单车";

/*	// 微信支付回调地址
	public static final String WXNOTIFY_URL = CommonUtils.getWebRootUrl() + "weixin_callback";
	
	// 微信退款回调地址
	public static final String WXREFUNDNOTIFY_URL = CommonUtils.getWebRootUrl() + "weixin_refund_callback";*/

	// 货币类型
	public static final String WXFEE_TYPE = "CNY";

	// 商家密钥
	public static final String WXKEY = "43DBE8BC489BDC916DE00807BCB4B7D0";

	// 微信接口地址
	public static final String WXPOSTURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	// 拓展字段
	public static final String WXPACKAGE = "Sign=WXPay";
	
/*	// 微信退款证书路径
	public static final String WXCERTPATH = CommonUtils.getWxCertPath();*/
	
	/**
	 * 还车后上位机服务器调取接口加密标签
	 */
	public static final String CHECKSIGN = "zjqy20141229";
	
	public static final String CHECKVERSION = "V1.0";
	
	public static final String QRCODEPASSWORD = "qykj@288522602885288522602885@!!";
	
	//实名认证接口
	public static final String DEF_CHATSET = "UTF-8";
	
    public static final int DEF_CONN_TIMEOUT = 30000;
    
    public static final int DEF_READ_TIMEOUT = 30000;
    
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    public static final String AUTHENTICATIONKEY ="29204da4bfa01e37bcb14bb952e7f8f5";
    
    public static final String Algorithm = "DESede";

	/***************************************************Jedis配置**********************************************************/
	public static final  String PHONE_VALIDE_CODE_PRIX="PHONE_";
	public static final  String TRANS_HEAT_MAP_KEY_START="TRANS_HEAT_MAP_KEY_START_";
	public static final  String TRANS_HEAT_MAP_KEY_START_ADMIN="TRANS_HEAT_MAP_KEY_START_1_";
	public static final  String  TRANS_HEAT_MAP_KEY_END="TRANS_HEAT_MAP_KEY_END_";
	public static final String AREA_STATIS="AREA_STATIS_";
	public static final String BIKE_STATUS_LOWVOL_="BIKE_STATUS_LOWVOL_";
	public static final String BIKE_STATUS_LOWVOL_ADMIN_="BIKE_STATUS_LOWVOL_1_";
	public static final String BIKE_STATUS_SCROPER_="BIKE_STATUS_SCROPER_";
	public static final String BIKE_STATUS_SCROPER_ADMIN_="BIKE_STATUS_SCROPER_1_";
	public static String BIKE_STATUS_LOWVOL_KEY="";
	public static String BIKE_STATUS_SCROPER_KEY="";
	/***************************************************OSS配置**********************************************************/
	public static final  String OSS_ENDPOINT = "oss-cn-shanghai.aliyuncs.com";
	public static final String OSS_ACCESSID = "LTAIXtzzxKiWP3By";
	public static final String OSS_ACCESSKEY = "S0AhvjObf3DlKjIsfgY5UNgnTrBMTZ";
	public static final String OSS_ACCESS_SECRET="S0AhvjObf3DlKjIsfgY5UNgnTrBMTZ";
	public static final String OSS_BUCKET = "jjdcjavaweb";
	public static final String OSS_COMM_DIR = "comm_dir";
	/***************************************************城市黑名单配置**********************************************************/
	public static final  String CITY_BALCKLIST_REDIS_HEADER = "black_list_";

}

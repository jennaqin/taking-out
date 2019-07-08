package com.keshe.luntan.utils;


import com.keshe.luntan.entity.ResultMsg;

public enum ResultEnum {
	//通用ResultMsg
	RESULT_SUCCESS(1000,"请求成功"),

	AREA_ID_ERROR(2001,"地区ID格式错误"),
	AREA_NAME_ERROR(2001,"地区名称格式错误"),
	COMMENT_ID_ERROR(2001,"评论ID格式错误"),
	POSTSID_ERROR(2001,"帖子ID格式错误"),
	COMCONTENT_ERROR(2001,"评论正文格式错误"),
	PUBLICTIME_ERROR(2001,"发布时间格式错误"),
	PROCESS_ERROR(2001,"状态码格式错误"),
	GOODSID_ERROR(2001,"商品ID格式错误"),
	USERID_ERROR(2001,"用户ID格式错误"),
	GOODSNAME_ERROR(2001,"商品名称格式错误"),
	GOODSPRICE_ERROR(2001,"商品价格格式错误"),
	PHOTO_ERROR(2001,"图片格式错误"),
	TYPEID_ERROR(2001,"类型ID格式错误"),
	TYPENAME_ERROR(2001,"类型名称格式错误"),
	ENDTIME_ERROR(2001,"到期时间格式错误"),
	MAXMSG_ERROR(2001,"商品详情格式错误"),
	SELLERNOTE_ERROR(2001,"卖家留言格式错误"),
	CONTENTID_ERROR(2001,"内容ID格式错误"),
	ORDERID_ERROR(2001,"订单ID格式错误"),
	WRITERID_ERROR(2001,"阅读人ID格式错误"),
	SELLERID_ERROR(2001,"卖家ID格式错误"),
	BUYERID_ERROR(2001,"买家ID格式错误"),
	BUYERNOTE_ERROR(2001,"买家留言格式错误"),
	TRADINGTIME_ERROR(2001,"发布时间错误"),
	PAYCODE_ERROR(2001,"支付码格式错误"),
	POSTSNAME_ERROR(2001,"话题名称格式错误"),
    CONTENT_ERROR(2001,"内容格式错误"),
    SID_ERROR(2001,"学号格式错误"),
	SCHOOLPASSWORD_ERROR(2001,"教务密码格式错误"),
	PASSOWRD_ERROR(2001,"登录密码格式错误"),
	USERNAME_ERROR(2001,"用户昵称格式错误"),
	PHONE_ERROR(2001,"手机号码格式错误"),
	USERSEX_ERROR(2001,"用户性别格式错误"),
	USERSTATE_ERROR(2001,"用户权限码格式错误"),
	CODE_ERROR(2002,"验证码错误"),
	
	//User专属
	PWD_ERROR10(2005,"密码错误次数超限,请24小时之后再试"),
	VERIFICATION_ERROR(2006,"密码验证错误"),
	USER_BANNED(2000,"此账户已被冻结,请联系管理员解冻"),
	PHONE_EXIST(2007,"此手机号码已存在"),
	OLDPWD_ERROR(2008,"原密码错误"),
	ENCRYPT_ERROR(2009,"加密错误"),
	
	//WECHAT专属
	GRANT_ERROR(2010,"授权登录失败,请稍后再试"),
	BINDING_ERROR(2011,"微信绑定失败,请稍后再试"),
	ACCOUNTBINDED_ERROR(2012,"您的账号已经绑定过微信"),
	WECHATBINDED_ERROR(2013,"此微信号已经绑定过其他账号"),
	
	//SCHOOLMESSAGE专属
	SID_EXIST(2020,"此学号已被注册过"),
	REALNAMED(2021,"此ID已实名认证过"),
	IS_NOT_REALNAME(2022,"未实名认证"),
	REALNAME_ERROR(2023,"网络异常"),
	
	//RESOURCE专属
	SEND_ERROR5(2030,"该手机号码超过发短信次数上限，请明天再试"),
	SEND_2FAST(2031,"请一分钟后再试"),
	SEND_FAIL(2032,"发送失败,请稍后再试"),
	FEEDBACK_ERROR(2033,"反馈信息格式错误"),
	UPLOADFILE_ERROR(2034,"上传文件错误"),
	
	//PAYMESSAGE专属
	NO_PAYCODE(2040,"未填写收款信息"),
		
	//ORDER专属
	NO_GOOD(2050,"商品不存在"),
	NO_ORDER(2051,"订单不存在"),
	
	//GOODS专属
	POWER_ERROR(2060,"权限错误"),
	DURATION_ERROR(2061,"时长错误"),
	NO_RECIVER(2062,"发送方不存在"),
	RECIVER_SERVICE_SHORTAGE(2063,"对方未开通此服务"),
	RECIVE_ERROR0(2064,"对方接受消息次数不足"),
	SERVICE_SAFEGUARD(2065,"该服务正在维护"),
	
	//ErrorController专属
	LOGIN_POWER_ERROR(2070,"未登录或令牌过期,请重新登录"),
	MANAGER_POWER_ERROR(2071,"此操作需要管理员权限"),

	TOKEN_ERROR(2080,"令牌错误"),

	//PostS
	DISKIO_EROOR(2090,"内容存储错误");

	private int code;
	private String describe;

	private ResultEnum(int code, String desc) {
		this.code = code;
		this.describe = desc;
	}
	
	public ResultMsg getResultMsg() {
		return new ResultMsg(code,describe);
	}

}

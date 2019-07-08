package com.keshe.luntan.utils.checker;

public class MyStringChecker {
	
	//防止创建实例
	private MyStringChecker() {}
	
	//字符串的正则表达式验证
	public static boolean stringPatternChecker(String str, String pattern) {
		if(str != null) {
			return str.matches(pattern) ? true : false;
		}
		return false;
	}
	
	//字符串长度校验
	public static boolean stringLengthChecker(String str, int minLength, int maxLength) {
		if(str == null) {
			return false;
		}
		if(str.length() < minLength) {
			return false;
		}
		if(str.length() > maxLength) {
			return false;
		}
		return true;
	}
	
	//判断字符串中是否存在某个(多个)值
	public static boolean stringContainsChecker(String str, char... checkerfactor) {
		if(str == null || checkerfactor.length == 0) {
			return false;
		}
		//判断字符串中是否存在检测因子
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < checkerfactor.length; i++) {
				if(str.charAt(i) == checkerfactor[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	//去掉字符串中的符号
	public static String stringUnsignedTransformer(String str) {
		if(str == null) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		//判断字符串中是否存在检测因子
		for(int i = 0; i < sb.length(); i++) {
			char temp = sb.charAt(i);
			if(temp >= '0' && temp <= '9') {
				continue;
			}
			if(temp >= 'Z' && temp <= 'Z') {
				continue;
			}
			if(temp >= 'a' && temp <= 'z') {
				continue;
			}
			
			//删除操作
			sb.delete(i, i+1);
			i--;
		}
		return sb.toString();
	}
	
	
	//清除字符串中是否存在某个(多个)值
	public static String stringContainsCleaner(String str, char... checkerfactor) {
		if(str == null || checkerfactor.length == 0) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		//判断字符串中是否存在检测因子
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < checkerfactor.length; i++) {
				if(str.charAt(i) == checkerfactor[j]) {
					sb.delete(i, i+1);
				}
			}
		}
		return sb.toString();
	}
	
	//执行额外的校验功能
	public static boolean stringExtChecker(String str, StringExtRule extRule) {
		if(str == null) {
			return false;
		}
		switch(extRule) {
			case PASSWORD_CHECKER : {
				if(stringLengthChecker(str,6,16) && (!str.contains(" "))) {
					return true;
				}
				return false;
			}
			case PHONE_CHECKER : {
				String regexp = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
				return stringPatternChecker(str, regexp);
			}
			case PHOTO_CHECKER : {
				if(stringLengthChecker(str, 5, 150)) {
					if(str.startsWith("https:")) {
						return true;
					}
					//截取后4位
					String s = str.substring(32).toLowerCase();
					if(s.equals(".jpg") || s.equals(".png") || s.equals(".gif")) {
						return true;
					}
				}
				return false;
			}
			default : {
				return false;
			}
		}
	}

	
	//校验字符串是否合格,不合格就返回默认的字符串
	public static String stringExtTransformer(String str, String defaultStr, StringExtRule checkRule) {
		if(stringExtChecker(str,checkRule)) {
			return str;
		}
		return defaultStr;
	}
	
	//校验字符串是否符合正则表达式,不合格就返回默认的字符串
	public static String stringPatternTransformer(String str, String defaultStr, String pattern) {
		if(stringPatternChecker(str,pattern)) {
			return str;
		}
		return defaultStr;
	}
	
	//校验字符串是否符合长度不合格就返回默认的字符串
	public static String stringLengthTransformer(String str, String defaultStr, int min, int max) {
		if(stringLengthChecker(str,min,max)) {
			return str;
		}
		return defaultStr;
	}
	
	//额外的功能枚举
	public static enum StringExtRule {
	    PASSWORD_CHECKER,//密码校验功能
	    PHONE_CHECKER,//手机号码校验
	    PHOTO_CHECKER//图片名校验
	}	

}

package com.keshe.luntan.utils.checker;

public class MyNumberChecker {

	private MyNumberChecker() {}
	
	//范围校验
	public static<T extends Number> boolean numberRangeChecker(T i, T min, T max) {

		if(i == null) {
			return false;
		}
		if(i.doubleValue() < min.doubleValue()) {
			return false;
		}
		if(i.doubleValue() > max.doubleValue()) {
			return false;
		}
		return true;
	}
	
	//额外的校验规则
	public static <T extends Number> boolean numberExtChecker(T i, NumberExtRule extRule) {
		switch(extRule) {
		
			case ID_CHECKER : {
				return numberRangeChecker(i,0,100000);
			}
			default : {
				return false;
			}
		}
	}
	
	//判断数字是否在规定范围内,如果不符合就返回默认值
	public static <T extends Number> T numberRangeTransformer(T i, T defaultValue, T min, T max) {
		if(numberRangeChecker(i,min,max)) {
			return i;
		}
		return defaultValue;
	}
	
	//判断数字是否符合校验规则,如果不符合就返回默认值
	public static <T extends Number> T numberExtTransformer(T i, T defaultValue, NumberExtRule extRule) {
		if(numberExtChecker(i,extRule)) {
			return i;
		}
		return defaultValue;
	}
	
	//额外的功能
	public enum NumberExtRule {
	    ID_CHECKER//ID校验功能
	}
	
}

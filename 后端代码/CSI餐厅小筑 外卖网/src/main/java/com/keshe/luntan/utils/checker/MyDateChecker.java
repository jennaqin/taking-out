package com.keshe.luntan.utils.checker;

import java.sql.Timestamp;

public class MyDateChecker {

	private MyDateChecker() {};
	
	//对日期进行改造
	public static Timestamp dataTransformer(Timestamp date,Long targetDate) {
		if(date == null) {
			date = new Timestamp(targetDate);
		}
		return date;
	}
	
	
}

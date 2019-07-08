package com.keshe.luntan.utils.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LoginManager {

	private static ConcurrentHashMap<Integer, String> mymap = new ConcurrentHashMap<Integer, String>();
	private static ScheduledThreadPoolExecutor removeExecutor = new ScheduledThreadPoolExecutor(3);

	public static void AddLoginflag(int userid, String token) {
		if (token != null) {
			mymap.put(userid, token);
			removeExecutor.schedule(() -> mymap.remove(userid),7,TimeUnit.DAYS);
		}
	}

	public static void DelLoginflag(int userid) {
		mymap.remove(userid);
	}

	public static String getLoginflag(int userid) {
		return mymap.get(userid);
	}
	
	public static void clearLoginflag() {
		mymap.clear();
	}
}

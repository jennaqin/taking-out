package com.keshe.luntan.utils.manager;


import com.keshe.luntan.entity.UserState;

import java.util.concurrent.ConcurrentHashMap;

//用户权限码管理器
public class UserStateManager {

	private static ConcurrentHashMap<Integer, UserState> mymap = new ConcurrentHashMap<Integer, UserState>();

	public static void AddUserStateflag(int userid, UserState userState) {
		mymap.put(userid, userState);
	}

	public static void DelUserStateflag(int userid) {
		mymap.remove(userid);
	}

	public static UserState getUserStateflag(int userid) {
		return mymap.get(userid);
	}
	
	public static void clearUserStateflag() {
		mymap.clear();
	}
}

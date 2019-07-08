package com.keshe.luntan.entity;

import java.io.Serializable;

public class UserState implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean isManager = false;
	private boolean isBan = false;

	public UserState(int userstate) {
		
		//10进制的权限码转为2进制
		if(userstate < 0) {
			isBan = true;
			userstate = -userstate;
		}
		int i = 0;
		isManager = (userstate >> i++ & 1) == 1 ? true : false;
	}
	
	public int getUserState() {
		int userstate = 0;
		userstate += (isManager ? 1 : 0) * Math.pow(2, 0);
		userstate *= (isBan ? -1 : 1);
		return userstate;
	}

	public boolean isBan() {
		return isBan;
	}

	public void setBan(boolean isBan) {
		this.isBan = isBan;
	}

	public boolean isManager() {
		return isManager;
	}


	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}


	@Override
	public String toString() {
		return "UserState [isManager=" + isManager +  ", isBan=" + isBan + "]";
	}

}


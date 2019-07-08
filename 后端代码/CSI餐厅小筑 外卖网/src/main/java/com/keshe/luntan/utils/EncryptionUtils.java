package com.keshe.luntan.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class EncryptionUtils {

	private EncryptionUtils() {};

	private static final EncryptionUtils instance = new EncryptionUtils();

	public static EncryptionUtils getInstance() {
		return instance;
	}


	// 加密一个字符串,加盐
	public String strEncrypt(String str, String salt) throws NoSuchAlgorithmException {
		String encrypt_Str = encrypt(str);
		//加盐操作
		return salt + encrypt_Str;
	}

	//MD5核心加密算法
	private String encrypt(String str) throws NoSuchAlgorithmException {
		String EncryptStr = null;
		MessageDigest md = MessageDigest.getInstance("md5");
		byte md5[] = md.digest(str.getBytes());
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(md5);
	}
}

package com.silence.questionlib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class ServiceUtils {

	public static String md5(String message) {
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte md5[] = digest.digest(message.getBytes());

			Base64 base64 = new Base64();
			return base64.encodeToString(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}

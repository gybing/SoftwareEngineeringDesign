package com.silence.questionlib.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化工具类
 * 
 * @author 林宇强 2015-12-05
 * 
 */
public class I18nUtils {

	/**
	 * 国际化参数提取测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle(
				"com.silence.questionlib.i18n.resource", Locale.CHINA);
		String username = bundle.getString("usex_male");
		String password = bundle.getString("password");
		System.out.println(username);
		System.out.println(password);

		System.out
				.println(I18nUtils.getI18nProperty(Locale.CHINA, "usex_male"));
	}

	/**
	 * 从国家化文件中提取相应的信息
	 * 
	 * @param locale要提取的地区
	 * @param name要提取信息名
	 * @return 返回指定地区的对应信息名的信息
	 */
	public static String getI18nProperty(Locale locale, String name) {
		ResourceBundle bundle = ResourceBundle.getBundle(
				"com.silence.questionlib.i18n.resource", locale);
		return bundle.getString(name);
	}
}

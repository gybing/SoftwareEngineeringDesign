package com.silence.questionlib.fombean;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.silence.questionlib.i18n.I18nUtils;

public class StudentLoginForm {

	private String stuid;
	private String password;

	private Locale locale;
	private Map<String, String> errors = new HashMap<String, String>();

	public void addLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean check() {
		boolean isOk = true;
		if (stuid == null || stuid.trim().equals("")) {
			isOk = false;
			errors.put("stuid", I18nUtils.getI18nProperty(locale, "stuid_null"));
		}
		if (password == null || password.trim().equals("")) {
			isOk = false;
			errors.put("password",
					I18nUtils.getI18nProperty(locale, "password_null"));
		}
		return isOk;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	@Override
	public String toString() {
		return "StudentLoginForm [stuid=" + stuid + ", password=" + password
				+ ", locale=" + locale + ", errors=" + errors + "]";
	}
}

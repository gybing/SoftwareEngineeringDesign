package com.silence.questionlib.fombean;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.silence.questionlib.i18n.I18nUtils;

public class TeacherLoginForm {

	private String teaid;
	private String password;

	private Locale locale;
	private Map<String, String> errors = new HashMap<String, String>();

	public void addLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean check() {
		boolean isOk = true;
		if (teaid == null || teaid.trim().equals("")) {
			isOk = false;
			errors.put("teaid", I18nUtils.getI18nProperty(locale, "teaid_null"));
		}
		if (password == null || password.trim().equals("")) {
			isOk = false;
			errors.put("password",
					I18nUtils.getI18nProperty(locale, "password_null"));
		}
		return isOk;
	}

	public String getTeaid() {
		return teaid;
	}

	public void setTeaid(String teaid) {
		this.teaid = teaid;
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

	@Override
	public String toString() {
		return "TeacherLoginForm [teaid=" + teaid + ", password=" + password
				+ ", locale=" + locale + ", errors=" + errors + "]";
	}
}

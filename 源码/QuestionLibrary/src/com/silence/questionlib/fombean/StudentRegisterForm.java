package com.silence.questionlib.fombean;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.silence.questionlib.i18n.I18nUtils;

public class StudentRegisterForm {

	private String stuid;
	private String stuname;
	private String password;
	private String password2;
	private String college;
	private String phone;
	private String email;
	private String groupid;

	private Locale locale;
	private Map<String, String> errors = new HashMap<String, String>();

	public void addLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean check() {
		boolean isOk = true;
		if (stuid == null || stuid.trim().equals("")) {
			isOk = false;
			errors.put("stuid",
					I18nUtils.getI18nProperty(locale, "register_stuid_null"));
		} else {
			if (!stuid.matches("[0-9]{8,16}")) {
				isOk = false;
				errors.put("stuid", I18nUtils.getI18nProperty(locale,
						"register_stuid_error"));
			}
		}
		if (stuname == null || stuname.trim().equals("")) {
			isOk = false;
			errors.put("stuname",
					I18nUtils.getI18nProperty(locale, "register_stuname_null"));
		} else {
			if (!stuname.matches("[a-zA-Z\u4e00-\u9fa5]{1,20}")) {
				isOk = false;
				errors.put("stuname", I18nUtils.getI18nProperty(locale,
						"register_stuname_error"));
			}
		}
		if (password == null || password.trim().equals("")) {
			isOk = false;
			errors.put("password",
					I18nUtils.getI18nProperty(locale, "register_password_null"));
		} else {
			if (!password.matches("[a-zA-Z0-9_]{5,16}")) {
				isOk = false;
				errors.put("password", I18nUtils.getI18nProperty(locale,
						"register_password_error"));
			}
		}
		if (password2 == null || password2.trim().equals("")) {
			isOk = false;
			errors.put("password2", I18nUtils.getI18nProperty(locale,
					"register_password2_null"));
		} else {
			if (!password2.equals(password)) {
				isOk = false;
				errors.put("password2", I18nUtils.getI18nProperty(locale,
						"register_password2_error"));
			}
		}
		if (college == null || college.trim().equals("")) {
			isOk = false;
			errors.put("college",
					I18nUtils.getI18nProperty(locale, "register_college_null"));
		} else {
			if (!college.matches("[a-zA-Z\u4e00-\u9fa5]{1,20}")) {
				isOk = false;
				errors.put("college", I18nUtils.getI18nProperty(locale,
						"register_college_error"));
			}
		}
		if (phone == null || phone.trim().equals("")) {
			isOk = false;
			errors.put("phone",
					I18nUtils.getI18nProperty(locale, "register_phone_null"));
		} else {
			if (!phone.matches("[0-9]{7,15}")) {
				isOk = false;
				errors.put("phone", I18nUtils.getI18nProperty(locale,
						"register_phone_error"));
			}
		}
		if (email == null || email.trim().equals("")) {
			isOk = false;
			errors.put("email",
					I18nUtils.getI18nProperty(locale, "register_email_null"));
		} else {
			if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOk = false;
				errors.put("email", I18nUtils.getI18nProperty(locale,
						"register_email_error"));
			}
		}
		if (groupid == null || groupid.trim().equals("")) {
			isOk = false;
			errors.put("groupid",
					I18nUtils.getI18nProperty(locale, "register_groupid_null"));
		} else {
			// if (!groupid.matches("\\w+@\\w+(\\.\\w+)+")) {
			// isOk = false;
			// errors.put("groupid", I18nUtils.getI18nProperty(locale,
			// "register_groupid_error"));
			// }
		}
		return isOk;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "StudentRegisterForm [stuid=" + stuid + ", stuname=" + stuname
				+ ", password=" + password + ", password2=" + password2
				+ ", college=" + college + ", phone=" + phone + ", email="
				+ email + ", groupid=" + groupid + ", locale=" + locale
				+ ", errors=" + errors + "]";
	}

}

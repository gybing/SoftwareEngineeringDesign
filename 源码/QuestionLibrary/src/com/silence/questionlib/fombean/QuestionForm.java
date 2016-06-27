package com.silence.questionlib.fombean;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.silence.questionlib.i18n.I18nUtils;

public class QuestionForm {

	private String quesid;
	private String quesname;
	private String questype;
	private String quescontent;
	private String quesanswer;
	private String other1;
	private String other2;
	private String other3;
	private String other4;

	private Locale locale;
	private Map<String, String> errors = new HashMap<String, String>();

	public void addLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean check() {
		boolean isOk = true;
		if (quesname == null || quesname.trim().equals("")) {
			isOk = false;
			errors.put("quesname",
					I18nUtils.getI18nProperty(locale, "quesname_null"));
		}
		if (quescontent == null || quescontent.trim().equals("")) {
			isOk = false;
			errors.put("quescontent",
					I18nUtils.getI18nProperty(locale, "quescontent_null"));
		}
		if (quesanswer == null || quesanswer.trim().equals("")) {
			isOk = false;
			errors.put("quesanswer",
					I18nUtils.getI18nProperty(locale, "quesanswer_null"));
		}
		if (questype == null || questype.trim().equals("")) {
			isOk = false;
			errors.put("questype",
					I18nUtils.getI18nProperty(locale, "questype_null"));
		}
		return isOk;
	}

	public String getQuesname() {
		return quesname;
	}

	public void setQuesname(String quesname) {
		this.quesname = quesname;
	}

	public String getQuesid() {
		return quesid;
	}

	public void setQuesid(String quesid) {
		this.quesid = quesid;
	}

	public String getQuestype() {
		return questype;
	}

	public void setQuestype(String questype) {
		this.questype = questype;
	}

	public String getQuescontent() {
		return quescontent;
	}

	public void setQuescontent(String quescontent) {
		this.quescontent = quescontent;
	}

	public String getQuesanswer() {
		return quesanswer;
	}

	public void setQuesanswer(String quesanswer) {
		this.quesanswer = quesanswer;
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public String getOther3() {
		return other3;
	}

	public void setOther3(String other3) {
		this.other3 = other3;
	}

	public String getOther4() {
		return other4;
	}

	public void setOther4(String other4) {
		this.other4 = other4;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "QuestionForm [quesname=" + quesname + ", questype=" + questype
				+ ", quescontent=" + quescontent + ", quesanswer=" + quesanswer
				+ ", other1=" + other1 + ", other2=" + other2 + ", other3="
				+ other3 + ", other4=" + other4 + ", locale=" + locale
				+ ", errors=" + errors + "]";
	}

}

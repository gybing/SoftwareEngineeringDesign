package com.silence.questionlib.domain;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Question {

	private String quesid;
	private String quesname;
	private String questype;
	private String quescontent;
	private String quesanswer;
	private String other1;
	private String other2;
	private String other3;
	private String other4;
	private Date insertTime;
	private String ownerid;
	private String ownername;

	public String getQuesid() {
		return quesid;
	}

	public void setQuesid(String quesid) {
		this.quesid = quesid;
	}

	public String getQuesname() {
		return quesname;
	}

	public void setQuesname(String quesname) {
		this.quesname = quesname;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
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

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	@Override
	public String toString() {
		return "Question [quesid=" + quesid + ", quesname=" + quesname
				+ ", questype=" + questype + ", quescontent=" + quescontent
				+ ", quesanswer=" + quesanswer + ", other1=" + other1
				+ ", other2=" + other2 + ", other3=" + other3 + ", other4="
				+ other4 + ", insertTime=" + insertTime + ", ownerid="
				+ ownerid + "]";
	}

	public class Type {
		public static final String xuanze = "xuanze";
		public static final String tiankong = "tiankong";
		public static final String jeishi = "jeishi";
		public static final String jianda = "jianda";
		public static final String yingyong = "yingyong";
	}
}

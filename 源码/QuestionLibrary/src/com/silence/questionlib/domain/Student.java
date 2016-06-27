package com.silence.questionlib.domain;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Student {

	private String stuid;
	private String stuname;
	private String password;
	private String college;
	private String phone;
	private String email;
	private Date registerTime;
	private String groupid;
	private String groupname;

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

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname
				+ ", password=" + password + ", college=" + college
				+ ", phone=" + phone + ", email=" + email + ", registerTime="
				+ registerTime + ", groupid=" + groupid + "]";
	}

}

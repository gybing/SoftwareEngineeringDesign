package com.silence.questionlib.domain;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Teacher {

	private String teaid;
	private String teaname;
	private String password;
	private String college;
	private String phone;
	private String email;
	private Date registerTime;

	public String getTeaid() {
		return teaid;
	}

	public void setTeaid(String teaid) {
		this.teaid = teaid;
	}

	public String getTeaname() {
		return teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}

	public String getPassword() {
		return password;
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

	@Override
	public String toString() {
		return "Teacher [teaid=" + teaid + ", teaname=" + teaname
				+ ", password=" + password + ", college=" + college
				+ ", phone=" + phone + ", email=" + email + ", registerTime="
				+ registerTime + "]";
	}

}

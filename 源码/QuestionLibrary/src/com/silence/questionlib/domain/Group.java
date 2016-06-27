package com.silence.questionlib.domain;

public class Group {

	private String groupid;
	private String college;
	private String groupname;
	private String teaid;

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getTeaid() {
		return teaid;
	}

	public void setTeaid(String teaid) {
		this.teaid = teaid;
	}

	@Override
	public String toString() {
		return "Group [groupid=" + groupid + ", college=" + college
				+ ", groupname=" + groupname + ", teaid=" + teaid + "]";
	}
}

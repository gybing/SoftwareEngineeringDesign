package com.silence.questionlib.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Paper {

	private String paperid;
	private String papername;
	private Date paperTime;
	private String ownername;
	private String ownerid;
	private String destGroup;

	private List<Question> questions = new ArrayList<Question>();

	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getPapername() {
		return papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	public Date getPaperTime() {
		return paperTime;
	}

	public void setPaperTime(Date paperTime) {
		this.paperTime = paperTime;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getDestGroup() {
		return destGroup;
	}

	public void setDestGroup(String destGroup) {
		this.destGroup = destGroup;
	}

	@Override
	public String toString() {
		return "Paper [paperid=" + paperid + ", papername=" + papername
				+ ", paperTime=" + paperTime + ", ownerid=" + ownerid
				+ ", destGroup=" + destGroup + "]";
	}

}

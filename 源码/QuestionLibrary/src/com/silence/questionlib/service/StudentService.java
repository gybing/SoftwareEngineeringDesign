package com.silence.questionlib.service;

import com.silence.questionlib.domain.Student;
import com.silence.questionlib.exception.GroupNotExist;
import com.silence.questionlib.exception.StudentNotExist;

public interface StudentService {

	public abstract void register(Student student);

	public abstract Student login(String stuid, String password)
			throws StudentNotExist;

	public abstract void add2Class(String stuid, String groupid)
			throws GroupNotExist, StudentNotExist;

}
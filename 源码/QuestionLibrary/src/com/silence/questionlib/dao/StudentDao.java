package com.silence.questionlib.dao;

import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;

public interface StudentDao {

	public abstract boolean addStudent(Student student);

	public abstract Student findStudent(String stuid);

	public abstract boolean updateStudent(Student student);

	public abstract Group findGroup(String groupid);

}
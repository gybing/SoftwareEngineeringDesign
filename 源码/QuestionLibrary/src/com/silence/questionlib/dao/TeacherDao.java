package com.silence.questionlib.dao;

import java.util.List;

import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;

public interface TeacherDao {

	public abstract boolean addTeacher(Teacher teacher);

	public abstract Teacher findTeacher(String teaid);

	public abstract boolean addGroup(Group group);

	public abstract List<Group> findGroups(String teaid);

	public abstract List<Student> findGroupStudents(String groupid);

}
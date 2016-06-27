package com.silence.questionlib.service;

import java.util.List;

import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.GroupNotExist;
import com.silence.questionlib.exception.StudentNotExist;
import com.silence.questionlib.exception.TeacherNotExist;

public interface TeacherService {

	public abstract void register(Teacher teacher);

	public abstract Teacher login(String teaid, String password)
			throws TeacherNotExist;

	public abstract void createClass(Group group);

	public abstract List<Group> findGroups(String teaid);

	public abstract List<Student> findGroupStudents(String groupid);

	public abstract Group findGroup(String groupid);

	public abstract void deleteGroupMember(String groupid, String stuid)
			throws GroupNotExist, StudentNotExist;

}
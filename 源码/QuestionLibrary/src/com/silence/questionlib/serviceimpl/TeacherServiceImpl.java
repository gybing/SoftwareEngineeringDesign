package com.silence.questionlib.serviceimpl;

import java.util.List;
import java.util.Set;

import com.silence.questionlib.dao.StudentDao;
import com.silence.questionlib.dao.TeacherDao;
import com.silence.questionlib.daoimpl.QuestionDaoImpl;
import com.silence.questionlib.daoimpl.StudentDaoImpl;
import com.silence.questionlib.daoimpl.TeacherDaoImpl;
import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.GroupNotExist;
import com.silence.questionlib.exception.QuestionNotExist;
import com.silence.questionlib.exception.ServiceException;
import com.silence.questionlib.exception.StudentNotExist;
import com.silence.questionlib.exception.TeacherNotExist;
import com.silence.questionlib.factory.DaoFactory;
import com.silence.questionlib.service.TeacherService;
import com.silence.questionlib.utils.ServiceUtils;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao = DaoFactory.getInstance().getTeacherDao(
			"teacher");
	private StudentDao studentDao = DaoFactory.getInstance().getStudentDao(
			"student");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#register(com.silence
	 * .questionlib.domain.Teacher)
	 */
	public void register(Teacher teacher) {
		try {
			teacher.setPassword(ServiceUtils.md5(teacher.getPassword()));
			teacherDao.addTeacher(teacher);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#login(java.lang.String
	 * , java.lang.String)
	 */
	public Teacher login(String teaid, String password) throws TeacherNotExist {
		try {
			Teacher teacher = teacherDao.findTeacher(teaid);
			if (teacher == null)
				throw new TeacherNotExist();
			password = ServiceUtils.md5(password);
			String password2 = teacher.getPassword();
			if (password2.equals(password)) {
				return teacher;
			} else
				return null;
		} catch (TeacherNotExist e) {
			throw new TeacherNotExist();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#createClass(com.silence
	 * .questionlib.domain.Group)
	 */
	public void createClass(Group group) {
		try {
			teacherDao.addGroup(group);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#findGroups(java.lang
	 * .String)
	 */
	public List<Group> findGroups(String teaid) {
		return teacherDao.findGroups(teaid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#findGroupStudents(
	 * java.lang.String)
	 */
	public List<Student> findGroupStudents(String groupid) {
		return teacherDao.findGroupStudents(groupid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#findGroup(java.lang
	 * .String)
	 */
	public Group findGroup(String groupid) {
		return studentDao.findGroup(groupid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.TeacherService#deleteGroupMember(
	 * java.lang.String, java.lang.String)
	 */
	public void deleteGroupMember(String groupid, String stuid)
			throws GroupNotExist, StudentNotExist {
		try {
			Student student = studentDao.findStudent(stuid);
			if (student == null)
				throw new StudentNotExist();
			Group group = studentDao.findGroup(groupid);
			if (group == null)
				throw new GroupNotExist();
			student.setGroupid(null);
			studentDao.updateStudent(student);
		} catch (StudentNotExist e) {
			throw new StudentNotExist();
		} catch (GroupNotExist e) {
			throw new GroupNotExist();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}

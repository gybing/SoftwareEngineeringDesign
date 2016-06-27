package com.silence.questionlib.serviceimpl;

import com.silence.questionlib.dao.StudentDao;
import com.silence.questionlib.daoimpl.StudentDaoImpl;
import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.exception.GroupNotExist;
import com.silence.questionlib.exception.ServiceException;
import com.silence.questionlib.exception.StudentNotExist;
import com.silence.questionlib.factory.DaoFactory;
import com.silence.questionlib.service.StudentService;
import com.silence.questionlib.utils.ServiceUtils;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = DaoFactory.getInstance().getStudentDao(
			"student");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.StudentService#register(com.silence
	 * .questionlib.domain.Student)
	 */
	public void register(Student student) {
		try {
			student.setPassword(ServiceUtils.md5(student.getPassword()));
			studentDao.addStudent(student);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.StudentService#login(java.lang.String
	 * , java.lang.String)
	 */
	public Student login(String stuid, String password) throws StudentNotExist {
		try {
			Student student = studentDao.findStudent(stuid);
			if (student == null)
				throw new StudentNotExist();
			password = ServiceUtils.md5(password);
			String password2 = student.getPassword();
			if (password2.equals(password)) {
				return student;
			} else
				return null;
		} catch (StudentNotExist e) {
			throw new StudentNotExist();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.StudentService#add2Class(java.lang
	 * .String, java.lang.String)
	 */
	public void add2Class(String stuid, String groupid) throws GroupNotExist,
			StudentNotExist {
		try {
			Student student = studentDao.findStudent(stuid);
			if (student == null)
				throw new StudentNotExist();
			Group group = studentDao.findGroup(groupid);
			if (group == null)
				throw new GroupNotExist();
			student.setGroupid(groupid);
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

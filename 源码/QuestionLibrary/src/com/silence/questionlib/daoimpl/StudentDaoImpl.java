package com.silence.questionlib.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.silence.questionlib.dao.StudentDao;
import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.exception.DaoException;

public class StudentDaoImpl implements StudentDao {

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.StudentDao#addStudent(com.silence.questionlib.domain.Student)
	 */
	public boolean addStudent(Student student) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into student(stuid,stuname,password,college,groupid,phone,email,registerTime) values(?,?,?,?,?,?,?,?);";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStuid());
			statement.setString(2, student.getStuname());
			statement.setString(3, student.getPassword());
			statement.setString(4, student.getCollege());
			statement.setString(5, student.getGroupid());
			statement.setString(6, student.getPhone());
			statement.setString(7, student.getEmail());
			statement.setDate(8, new Date(student.getRegisterTime().getTime()));
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.StudentDao#findStudent(java.lang.String)
	 */
	public Student findStudent(String stuid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where stuid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, stuid);
			rs = statement.executeQuery();
			if (rs.next()) {
				Student student = new Student();
				student.setStuid(stuid);
				student.setCollege(rs.getString("college"));
				student.setEmail(rs.getString("email"));
				student.setGroupid(rs.getString("groupid"));
				student.setPassword(rs.getString("password"));
				student.setPhone(rs.getString("phone"));
				student.setRegisterTime(rs.getDate("registerTime"));
				student.setStuname(rs.getString("stuname"));
				return student;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.StudentDao#updateStudent(com.silence.questionlib.domain.Student)
	 */
	public boolean updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "update student set stuname=?,password=?,college=?,groupid=?,phone=?,email=?,registerTime=? where stuid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStuname());
			statement.setString(2, student.getPassword());
			statement.setString(3, student.getCollege());
			statement.setString(4, student.getGroupid());
			statement.setString(5, student.getPhone());
			statement.setString(6, student.getEmail());
			statement.setDate(7, new Date(student.getRegisterTime().getTime()));
			statement.setString(8, student.getStuid());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.StudentDao#findGroup(java.lang.String)
	 */
	public Group findGroup(String groupid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mgroup where groupid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, groupid);
			rs = statement.executeQuery();
			if (rs.next()) {
				Group group = new Group();
				group.setCollege(rs.getString("college"));
				group.setGroupname(rs.getString("groupname"));
				group.setGroupid(rs.getString("groupid"));
				group.setTeaid(rs.getString("teaid"));
				return group;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}
}

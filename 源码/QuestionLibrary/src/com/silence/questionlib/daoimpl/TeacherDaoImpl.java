package com.silence.questionlib.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.silence.questionlib.dao.TeacherDao;
import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.DaoException;

public class TeacherDaoImpl implements TeacherDao {

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.TeacherDao#addTeacher(com.silence.questionlib.domain.Teacher)
	 */
	public boolean addTeacher(Teacher teacher) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into teacher(teaid,teaname,password,college,phone,email,registerTime) values(?,?,?,?,?,?,?);";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, teacher.getTeaid());
			statement.setString(2, teacher.getTeaname());
			statement.setString(3, teacher.getPassword());
			statement.setString(4, teacher.getCollege());
			statement.setString(5, teacher.getPhone());
			statement.setString(6, teacher.getEmail());
			statement.setDate(7, new Date(teacher.getRegisterTime().getTime()));
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
	 * @see com.silence.questionlib.daoimpl.TeacherDao#findTeacher(java.lang.String)
	 */
	public Teacher findTeacher(String teaid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teacher where teaid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, teaid);
			rs = statement.executeQuery();
			if (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeaid(teaid);
				teacher.setCollege(rs.getString("college"));
				teacher.setEmail(rs.getString("email"));
				teacher.setPassword(rs.getString("password"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setRegisterTime(rs.getDate("registerTime"));
				teacher.setTeaname(rs.getString("teaname"));
				return teacher;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.TeacherDao#addGroup(com.silence.questionlib.domain.Group)
	 */
	public boolean addGroup(Group group) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into mgroup(groupid,college,groupname,teaid) values(?,?,?,?);";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, group.getGroupid());
			statement.setString(2, group.getCollege());
			statement.setString(3, group.getGroupname());
			statement.setString(4, group.getTeaid());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.TeacherDao#findGroups(java.lang.String)
	 */
	public List<Group> findGroups(String teaid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mgroup where teaid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, teaid);
			rs = statement.executeQuery();
			List<Group> groups = new ArrayList<Group>();
			while (rs.next()) {
				Group group = new Group();
				group.setCollege(rs.getString("college"));
				group.setGroupid(rs.getString("groupid"));
				group.setGroupname(rs.getString("groupname"));
				group.setTeaid(teaid);
				groups.add(group);
			}
			return groups.size() > 0 ? groups : null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/* (non-Javadoc)
	 * @see com.silence.questionlib.daoimpl.TeacherDao#findGroupStudents(java.lang.String)
	 */
	public List<Student> findGroupStudents(String groupid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student s,mgroup g where g.groupid=s.groupid and s.groupid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, groupid);
			rs = statement.executeQuery();
			List<Student> students = new ArrayList<Student>();
			while (rs.next()) {
				Student student = new Student();
				student.setEmail(rs.getString("email"));
				student.setGroupid(groupid);
				student.setPhone(rs.getString("phone"));
				student.setRegisterTime(rs.getDate("registerTime"));
				student.setStuid(rs.getString("stuid"));
				student.setStuname(rs.getString("stuname"));
				student.setCollege(rs.getString("college"));
				student.setGroupname(rs.getString("groupname"));
				students.add(student);
			}
			return students.size() > 0 ? students : null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}
}

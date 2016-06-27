package com.silence.questionlib.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.silence.questionlib.dao.QuestionDao;
import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;
import com.silence.questionlib.exception.DaoException;

public class QuestionDaoImpl implements QuestionDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#findQuestion(java.lang.String
	 * )
	 */
	public Question findQuestion(String quesid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from question q,teacher t where q.ownerid=t.teaid and q.quesid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, quesid);
			rs = statement.executeQuery();
			if (rs.next()) {
				Question question = new Question();
				question.setInsertTime(rs.getDate("insertTime"));
				question.setOther1(rs.getString("other1"));
				question.setOther2(rs.getString("other2"));
				question.setOther3(rs.getString("other3"));
				question.setOther4(rs.getString("other4"));
				question.setOwnerid(rs.getString("ownerid"));
				question.setQuesanswer(rs.getString("quesanswer"));
				question.setQuescontent(rs.getString("quescontent"));
				question.setQuesid(quesid);
				question.setQuesname(rs.getString("quesname"));
				question.setQuestype(rs.getString("questype"));
				question.setOwnername(rs.getString("teaname"));
				return question;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#findQuestions(java.lang.String
	 * )
	 */
	public List<Question> findQuestions(String questype) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from question q,teacher t where t.teaid=q.ownerid and q.questype=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, questype);
			rs = statement.executeQuery();
			List<Question> questions = new ArrayList<Question>();
			while (rs.next()) {
				Question question = new Question();
				question.setInsertTime(rs.getDate("insertTime"));
				question.setOther1(rs.getString("other1"));
				question.setOther2(rs.getString("other2"));
				question.setOther3(rs.getString("other3"));
				question.setOther4(rs.getString("other4"));
				question.setOwnerid(rs.getString("ownerid"));
				question.setQuesanswer(rs.getString("quesanswer"));
				question.setQuescontent(rs.getString("quescontent"));
				question.setQuesid(rs.getString("quesid"));
				question.setQuesname(rs.getString("quesname"));
				question.setQuestype(rs.getString("questype"));
				question.setOwnername(rs.getString("teaname"));
				questions.add(question);
			}
			return questions.size() > 0 ? questions : null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.silence.questionlib.daoimpl.QuestionDao#addQuestion(com.silence.
	 * questionlib.domain.Question)
	 */
	public boolean addQuestion(Question question) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into question(quesid,quesname,quescontent,quesanswer,questype,other1,other2,other3,other4,ownerid,insertTime) values(?,?,?,?,?,?,?,?,?,?,?);";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, question.getQuesid());
			statement.setString(2, question.getQuesname());
			statement.setString(3, question.getQuescontent());
			statement.setString(4, question.getQuesanswer());
			statement.setString(5, question.getQuestype());
			statement.setString(6, question.getOther1());
			statement.setString(7, question.getOther2());
			statement.setString(8, question.getOther3());
			statement.setString(9, question.getOther4());
			statement.setString(10, question.getOwnerid());
			statement.setDate(11, new Date(question.getInsertTime().getTime()));
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#updateQuestion(com.silence
	 * .questionlib.domain.Question)
	 */
	public boolean updateQuestion(Question question) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "update question set quesname=?,quescontent=?,quesanswer=?,questype=?,other1=?,other2=?,other3=?,other4=?,ownerid=?,insertTime=? where quesid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, question.getQuesname());
			statement.setString(2, question.getQuescontent());
			statement.setString(3, question.getQuesanswer());
			statement.setString(4, question.getQuestype());
			statement.setString(5, question.getOther1());
			statement.setString(6, question.getOther2());
			statement.setString(7, question.getOther3());
			statement.setString(8, question.getOther4());
			statement.setString(9, question.getOwnerid());
			statement.setDate(10, new Date(question.getInsertTime().getTime()));
			statement.setString(11, question.getQuesid());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#deleteQuestion(java.lang.
	 * String)
	 */
	public boolean deleteQuestion(String quesid) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "delete from question where quesid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, quesid);
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#findPaper(java.lang.String)
	 */
	public Paper findPaper(String paperid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from paper p,teacher t where p.ownerid=t.teaid and p.paperid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, paperid);
			rs = statement.executeQuery();
			if (rs.next()) {
				Paper paper = new Paper();
				paper.setDestGroup(rs.getString("destGroup"));
				paper.setOwnerid(rs.getString("ownerid"));
				paper.setPaperid(paperid);
				paper.setPapername(rs.getString("papername"));
				paper.setPaperTime(rs.getDate("paperTime"));
				paper.setOwnername(rs.getString("teaname"));
				return paper;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#findStudentPapers(java.lang
	 * .String)
	 */
	public List<Paper> findStudentPapers(String stuid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student stu,paper p,teacher t where stu.groupid=p.destGroup and t.teaid=p.ownerid and stu.stuid=?;";
			// String sql =
			// "select * from stupaper sp,paper p,teacher t where sp.paperid=p.paperid and t.teaid=p.ownerid and sp.stuid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, stuid);
			rs = statement.executeQuery();
			List<Paper> papers = new ArrayList<Paper>();
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setDestGroup(rs.getString("destGroup"));
				paper.setOwnerid(rs.getString("ownerid"));
				paper.setPaperid(rs.getString("paperid"));
				paper.setPapername(rs.getString("papername"));
				paper.setPaperTime(rs.getDate("paperTime"));
				paper.setOwnername(rs.getString("teaname"));
				papers.add(paper);
			}
			return papers.size() > 0 ? papers : null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#addPaper(com.silence.questionlib
	 * .domain.Paper)
	 */
	public boolean addPaper(Paper paper) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into paper(paperid,papername,ownerid,destGroup,paperTime) values(?,?,?,?,?);";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, paper.getPaperid());
			statement.setString(2, paper.getPapername());
			statement.setString(3, paper.getOwnerid());
			statement.setString(4, paper.getDestGroup());
			statement.setDate(5, new Date(paper.getPaperTime().getTime()));
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#addPaperQuestions(java.lang
	 * .String, java.util.List, java.util.List)
	 */
	public boolean addPaperQuestions(String paperid, List<String> quesids,
			List<Float> qvalues) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "insert into quespaper(paperid,quesid,qvalue) values(?,?,?);";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, paperid);
			// TODO statement.addBatch(sql);
			for (int i = 0; i < quesids.size(); i++) {
				statement.setString(2, quesids.get(i));
				statement.setFloat(3, qvalues.get(i));
				int count = statement.executeUpdate();
				if (count <= 0)
					return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.daoimpl.QuestionDao#findPaperQuestions(java.lang
	 * .String)
	 */
	public List<Question> findPaperQuestions(String paperid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from quespaper qp,question q where qp.quesid=q.quesid and qp.paperid=?;";
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, paperid);
			rs = statement.executeQuery();
			List<Question> questions = new ArrayList<Question>();
			while (rs.next()) {
				Question question = new Question();
				System.out.println(rs.getString("quesname"));
				question.setInsertTime(rs.getDate("insertTime"));
				question.setOther1(rs.getString("other1"));
				question.setOther2(rs.getString("other2"));
				question.setOther3(rs.getString("other3"));
				question.setOther4(rs.getString("other4"));
				question.setOwnerid(rs.getString("ownerid"));
				question.setQuesanswer(rs.getString("quesanswer"));
				question.setQuescontent(rs.getString("quescontent"));
				question.setQuesid(rs.getString("quesid"));
				question.setQuesname(rs.getString("quesname"));
				question.setQuestype(rs.getString("questype"));
				questions.add(question);
			}
			return questions.size() > 0 ? questions : null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection(connection, statement, rs);
		}
	}
}

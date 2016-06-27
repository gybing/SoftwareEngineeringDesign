package com.silence.questionlib.serviceimpl;

import java.util.List;

import com.silence.questionlib.dao.QuestionDao;
import com.silence.questionlib.daoimpl.QuestionDaoImpl;
import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;
import com.silence.questionlib.exception.PaperNotExist;
import com.silence.questionlib.exception.QuestionNotExist;
import com.silence.questionlib.exception.QuestionUsedException;
import com.silence.questionlib.exception.ServiceException;
import com.silence.questionlib.factory.DaoFactory;
import com.silence.questionlib.service.QuestionLibService;

public class QuestionLibServiceImpl implements QuestionLibService {

	private QuestionDao questionDao = DaoFactory.getInstance().getQuestionDao(
			"question");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#findStudentPapers
	 * (java.lang.String)
	 */
	public List<Paper> findStudentPapers(String stuid) {
		return questionDao.findStudentPapers(stuid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#createPaper(com
	 * .silence.questionlib.domain.Paper, java.util.List, java.util.List)
	 */
	public void createPaper(Paper paper, List<String> quesids,
			List<Float> qvalues) {
		try {
			questionDao.addPaper(paper);
			questionDao.addPaperQuestions(paper.getPaperid(), quesids, qvalues);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#addQuestion(com
	 * .silence.questionlib.domain.Question)
	 */
	public void addQuestion(Question question) {
		try {
			questionDao.addQuestion(question);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#deleteQuestion
	 * (java.lang.String)
	 */
	public void deleteQuestion(String quesid) throws QuestionNotExist,
			QuestionUsedException {
		try {
			Question question = questionDao.findQuestion(quesid);
			if (question == null)
				throw new QuestionNotExist();
			questionDao.deleteQuestion(quesid);
		} catch (QuestionNotExist e) {
			throw new QuestionNotExist();
		} catch (Exception e) {
			throw new QuestionUsedException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#updateQuestion
	 * (java.lang.String, com.silence.questionlib.domain.Question)
	 */
	public Question updateQuestion(String quesid, Question question)
			throws QuestionNotExist {
		try {
			Question tQuestion = questionDao.findQuestion(quesid);
			if (tQuestion == null)
				throw new QuestionNotExist();
			tQuestion.setOther1(question.getOther1());
			tQuestion.setOther2(question.getOther2());
			tQuestion.setOther3(question.getOther3());
			tQuestion.setOther4(question.getOther4());
			tQuestion.setQuesanswer(question.getQuesanswer());
			tQuestion.setQuescontent(question.getQuescontent());
			tQuestion.setQuesname(question.getQuesname());
			tQuestion.setQuestype(question.getQuestype());
			questionDao.updateQuestion(tQuestion);
			return tQuestion;
		} catch (QuestionNotExist e) {
			throw new QuestionNotExist();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#queryQuestion(
	 * java.lang.String)
	 */
	public Question queryQuestion(String quesid) throws QuestionNotExist {
		try {
			Question question = questionDao.findQuestion(quesid);
			if (question == null)
				throw new QuestionNotExist();
			return question;
		} catch (QuestionNotExist e) {
			throw new QuestionNotExist();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#queryPaperQuestions
	 * (java.lang.String)
	 */
	public List<Question> queryPaperQuestions(String paperid)
			throws QuestionNotExist {
		try {
			List<Question> questions = questionDao.findPaperQuestions(paperid);
			return questions;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#queryPaper(java
	 * .lang.String)
	 */
	public Paper queryPaper(String paperid) throws PaperNotExist {
		try {
			Paper paper = questionDao.findPaper(paperid);
			if (paper == null)
				throw new PaperNotExist();
			return paper;
		} catch (PaperNotExist e) {
			throw new PaperNotExist();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.silence.questionlib.serviceimpl.QuestionLibService#getAll(java.lang
	 * .String)
	 */
	public List<Question> getAll(String questype) {
		try {
			return questionDao.findQuestions(questype);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}

package com.silence.questionlib.service;

import java.util.List;

import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;
import com.silence.questionlib.exception.PaperNotExist;
import com.silence.questionlib.exception.QuestionNotExist;
import com.silence.questionlib.exception.QuestionUsedException;

public interface QuestionLibService {

	public abstract List<Paper> findStudentPapers(String stuid);

	public abstract void createPaper(Paper paper, List<String> quesids,
			List<Float> qvalues);

	public abstract void addQuestion(Question question);

	public abstract void deleteQuestion(String quesid) throws QuestionNotExist,
			QuestionUsedException;

	public abstract Question updateQuestion(String quesid, Question question)
			throws QuestionNotExist;

	public abstract Question queryQuestion(String quesid)
			throws QuestionNotExist;

	public abstract List<Question> queryPaperQuestions(String paperid)
			throws QuestionNotExist;

	public abstract Paper queryPaper(String paperid) throws PaperNotExist;

	public abstract List<Question> getAll(String questype);

}
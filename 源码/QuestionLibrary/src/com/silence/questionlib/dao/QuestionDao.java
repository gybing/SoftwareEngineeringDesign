package com.silence.questionlib.dao;

import java.util.List;

import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;

public interface QuestionDao {

	public abstract Question findQuestion(String quesid);

	public abstract List<Question> findQuestions(String questype);

	public abstract boolean addQuestion(Question question);

	public abstract boolean updateQuestion(Question question);

	public abstract boolean deleteQuestion(String quesid);

	public abstract Paper findPaper(String paperid);

	public abstract List<Paper> findStudentPapers(String stuid);

	public abstract boolean addPaper(Paper paper);

	public abstract boolean addPaperQuestions(String paperid,
			List<String> quesids, List<Float> qvalues);

	public abstract List<Question> findPaperQuestions(String paperid);

}
package com.silence.questionlib.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.PaperNotExist;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.QuestionLibService;
import com.silence.questionlib.serviceimpl.QuestionLibServiceImpl;

/**
 * 试卷展示
 * 
 * @author 林宇强
 * 
 */
public class PaperServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession(false);
		// 检验登录状态
		if (session == null) {
			request.setAttribute("message",
					I18nUtils.getI18nProperty(request.getLocale(), "not_login"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		Object object = session.getAttribute("user");
		if (object == null) {
			request.setAttribute("message",
					I18nUtils.getI18nProperty(request.getLocale(), "not_login"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}

		String paperid = request.getParameter("paperid");
		QuestionLibService service = new QuestionLibServiceImpl();
		try {
			Paper paper = service.queryPaper(paperid);
			List<Question> questions = service.queryPaperQuestions(paperid);
			// 分类
			List<Question> xuanze = new ArrayList<Question>();
			List<Question> tiankong = new ArrayList<Question>();
			List<Question> jeishi = new ArrayList<Question>();
			List<Question> jianda = new ArrayList<Question>();
			List<Question> yingyong = new ArrayList<Question>();
			// 序号
			String[] xuhao = {
					I18nUtils.getI18nProperty(request.getLocale(), "xuhao1"),
					I18nUtils.getI18nProperty(request.getLocale(), "xuhao2"),
					I18nUtils.getI18nProperty(request.getLocale(), "xuhao3"),
					I18nUtils.getI18nProperty(request.getLocale(), "xuhao4"),
					I18nUtils.getI18nProperty(request.getLocale(), "xuhao5") };
			for (Question question : questions) {
				if (question.getQuestype().equals(Question.Type.xuanze)) {
					xuanze.add(question);
				} else if (question.getQuestype()
						.equals(Question.Type.tiankong)) {
					tiankong.add(question);
				} else if (question.getQuestype().equals(Question.Type.jeishi)) {
					jeishi.add(question);
				} else if (question.getQuestype().equals(Question.Type.jianda)) {
					jianda.add(question);
				} else if (question.getQuestype()
						.equals(Question.Type.yingyong)) {
					yingyong.add(question);
				}
			}
			request.setAttribute("paper", paper);
			request.setAttribute("xuanze", xuanze);
			request.setAttribute("tiankong", tiankong);
			request.setAttribute("jeishi", jeishi);
			request.setAttribute("jianda", jianda);
			request.setAttribute("yingyong", yingyong);
			request.setAttribute("xuhao", xuhao);
			int i = 0;
			request.setAttribute("i", i);
			request.getRequestDispatcher("/WEB-INF/jsp/paper.jsp").forward(
					request, response);
			return;
		} catch (PaperNotExist e) {
			// 试卷不存在
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "paper_not_exist"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		} catch (Exception e) {
			// 服务器未知异常
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "server_error"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
	}
}

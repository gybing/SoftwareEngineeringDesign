package com.silence.questionlib.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Question;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.QuestionLibService;
import com.silence.questionlib.serviceimpl.QuestionLibServiceImpl;

/**
 * 列出问题
 * 
 * @author 林宇强
 * 
 */
public class ListQuestionServlet extends HttpServlet {

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

		QuestionLibService questionLibService = new QuestionLibServiceImpl();
		List<Question> xuanze = questionLibService.getAll(Question.Type.xuanze);
		List<Question> tiankong = questionLibService
				.getAll(Question.Type.tiankong);
		List<Question> jeishi = questionLibService.getAll(Question.Type.jeishi);
		List<Question> jianda = questionLibService.getAll(Question.Type.jianda);
		List<Question> yingyong = questionLibService
				.getAll(Question.Type.yingyong);
		request.setAttribute("xuanze", xuanze);
		request.setAttribute("tiankong", tiankong);
		request.setAttribute("jeishi", jeishi);
		request.setAttribute("jianda", jianda);
		request.setAttribute("yingyong", yingyong);
		request.getRequestDispatcher("/WEB-INF/jsp/listquestion.jsp").forward(
				request, response);
		return;
	}
}

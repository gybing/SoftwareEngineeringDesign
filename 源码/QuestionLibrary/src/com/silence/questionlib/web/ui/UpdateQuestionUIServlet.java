package com.silence.questionlib.web.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Question;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.QuestionNotExist;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.QuestionLibService;
import com.silence.questionlib.serviceimpl.QuestionLibServiceImpl;
import com.silence.questionlib.utils.WebUtils;

public class UpdateQuestionUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String formId = WebUtils.getUUID();
		HttpSession session = request.getSession();
		// ¼ìÑéµÇÂ¼×´Ì¬
		Teacher teacher = (Teacher) session.getAttribute("user");
		if (teacher == null) {
			request.setAttribute("message",
					I18nUtils.getI18nProperty(request.getLocale(), "not_login"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		// ¼ì²â±íµ¥ºÅ
		session.setAttribute("formId", formId);
		request.setAttribute("formId", formId);

		String quesid = request.getParameter("quesid");
		QuestionLibService questionLibService = new QuestionLibServiceImpl();
		try {
			Question question = questionLibService.queryQuestion(quesid);
			request.setAttribute("question", question);
			request.getRequestDispatcher("/WEB-INF/jsp/updatequestion.jsp")
					.forward(request, response);
			return;
		} catch (QuestionNotExist e) {
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "question_not_exist"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "server_error"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
	}
}

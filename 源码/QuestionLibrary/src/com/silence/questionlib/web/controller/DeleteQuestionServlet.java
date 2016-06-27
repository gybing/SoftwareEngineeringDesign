package com.silence.questionlib.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.QuestionNotExist;
import com.silence.questionlib.exception.QuestionUsedException;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.QuestionLibService;
import com.silence.questionlib.serviceimpl.QuestionLibServiceImpl;

/**
 * 删除问题
 * 
 * @author 林宇强
 * 
 */
public class DeleteQuestionServlet extends HttpServlet {

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
		String quesid = request.getParameter("quesid");
		QuestionLibService questionLibService = new QuestionLibServiceImpl();
		try {
			questionLibService.deleteQuestion(quesid);
			response.sendRedirect(request.getContextPath()
					+ "/ListQuestionServlet");
			return;
		} catch (QuestionNotExist e) {
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "question_not_exist"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		} catch (QuestionUsedException e) {
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "question_used"));
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

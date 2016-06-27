package com.silence.questionlib.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Question;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.fombean.QuestionForm;
import com.silence.questionlib.fombean.TeacherRegisterForm;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.QuestionLibService;
import com.silence.questionlib.serviceimpl.QuestionLibServiceImpl;
import com.silence.questionlib.serviceimpl.TeacherServiceImpl;
import com.silence.questionlib.utils.WebUtils;

/**
 * 添加问题
 * 
 * @author 林宇强
 * 
 */
public class AddQuestionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		if (teacher == null) {
			request.setAttribute("message",
					I18nUtils.getI18nProperty(request.getLocale(), "not_login"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		// 检测表单号
		String formId = request.getParameter("formId");
		String formId2 = (String) session.getAttribute("formId");
		if (formId2 == null || !formId2.equals(formId)) {
			// 表单号错误，提供无需重复提交表单
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "formid_error"));
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		// 删除表单号
		session.removeAttribute("formId");

		addQuestion(request, response, teacher.getTeaid());
		return;
	}

	private void addQuestion(HttpServletRequest request,
			HttpServletResponse response, String teaid)
			throws ServletException, IOException {
		QuestionForm form = WebUtils.request2Bean(request, QuestionForm.class);
		form.addLocale(request.getLocale());
		if (!form.check()) {
			// 表单校验失败
			request.setAttribute("errors", form.getErrors());
			request.getRequestDispatcher("/WEB-INF/jsp/addquestion.jsp")
					.forward(request, response);
			return;
		}

		Question question = new Question();
		WebUtils.copyBean(form, question);
		question.setInsertTime(new Date());
		question.setQuesid(WebUtils.getUUID());
		question.setOwnerid(teaid);
		QuestionLibService questionLibService = new QuestionLibServiceImpl();
		try {
			questionLibService.addQuestion(question);
			// request.setAttribute("message", I18nUtils.getI18nProperty(
			// request.getLocale(), "add_question_success"));
			// request.getRequestDispatcher("/message.jsp").forward(request,
			// response);
			response.sendRedirect(request.getContextPath()
					+ "/ListQuestionServlet");
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}

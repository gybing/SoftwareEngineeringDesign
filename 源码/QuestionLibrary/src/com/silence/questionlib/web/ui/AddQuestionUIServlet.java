package com.silence.questionlib.web.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.utils.WebUtils;

public class AddQuestionUIServlet extends HttpServlet {
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

		session.setAttribute("formId", formId);
		request.setAttribute("formId", formId);
		request.getRequestDispatcher("/WEB-INF/jsp/addquestion.jsp").forward(
				request, response);
	}
}

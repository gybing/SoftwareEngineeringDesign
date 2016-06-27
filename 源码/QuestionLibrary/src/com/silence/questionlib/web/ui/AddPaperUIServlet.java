package com.silence.questionlib.web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Result;
import com.silence.questionlib.utils.WebUtils;

public class AddPaperUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String formId = WebUtils.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("formId", formId);
		request.setAttribute("formId", formId);

		request.getRequestDispatcher("/WEB-INF/jsp/addpaper.jsp").forward(
				request, response);
	}
}

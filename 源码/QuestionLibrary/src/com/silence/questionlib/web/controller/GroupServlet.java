package com.silence.questionlib.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.TeacherService;
import com.silence.questionlib.serviceimpl.StudentServiceImpl;
import com.silence.questionlib.serviceimpl.TeacherServiceImpl;

/**
 * 列出班级列表
 * 
 * @author 林宇强
 * 
 */
public class GroupServlet extends HttpServlet {

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

		String groupid = request.getParameter("groupid");
		TeacherService teacherService = new TeacherServiceImpl();
		Group group = teacherService.findGroup(groupid);
		List<Student> students = teacherService.findGroupStudents(groupid);
		request.setAttribute("students", students);
		request.setAttribute("group", group);
		request.getRequestDispatcher("/WEB-INF/jsp/liststudent.jsp").forward(
				request, response);
		return;
	}
}

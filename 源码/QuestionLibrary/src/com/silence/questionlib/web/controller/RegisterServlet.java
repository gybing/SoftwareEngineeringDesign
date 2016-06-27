package com.silence.questionlib.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silence.questionlib.domain.Result;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.GroupNotExist;
import com.silence.questionlib.exception.StudentNotExist;
import com.silence.questionlib.exception.TeacherNotExist;
import com.silence.questionlib.fombean.StudentLoginForm;
import com.silence.questionlib.fombean.StudentRegisterForm;
import com.silence.questionlib.fombean.TeacherLoginForm;
import com.silence.questionlib.fombean.TeacherRegisterForm;
import com.silence.questionlib.i18n.I18nUtils;
import com.silence.questionlib.service.StudentService;
import com.silence.questionlib.service.TeacherService;
import com.silence.questionlib.serviceimpl.StudentServiceImpl;
import com.silence.questionlib.serviceimpl.TeacherServiceImpl;
import com.silence.questionlib.utils.WebUtils;

/**
 * 注册
 * 
 * @author 林宇强
 * 
 */
public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession(false);
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

		Result result = (Result) session.getAttribute("result");
		String checkCode = request.getParameter("checkCode");
		if (checkCode == null || checkCode.trim().equals("")) {
			// 验证码为空
			request.setAttribute("checkCodeError", I18nUtils.getI18nProperty(
					request.getLocale(), "checkcode_null"));
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		} else if (!checkCode.equalsIgnoreCase(result.checkCode)) {
			// 验证码错误
			request.setAttribute("checkCodeError", I18nUtils.getI18nProperty(
					request.getLocale(), "checkcode_error"));
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		}
		// 验证码正确
		File file = new File(result.realPath);
		if (file.exists())
			file.delete();
		session.removeAttribute("result");

		String admin = request.getParameter("admin");
		if (admin == null || admin.trim().equals("")) {
			studentRegister(request, response);
			return;
		} else {
			teacherRegister(request, response);
			return;
		}
	}

	private void teacherRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TeacherRegisterForm form = WebUtils.request2Bean(request,
				TeacherRegisterForm.class);
		form.addLocale(request.getLocale());
		if (!form.check()) {
			// 表单校验失败
			request.setAttribute("errors", form.getErrors());
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		}

		Teacher teacher = new Teacher();
		WebUtils.copyBean(form, teacher);
		teacher.setRegisterTime(new Date());
		TeacherService teacherServiceImpl = new TeacherServiceImpl();
		try {
			teacherServiceImpl.register(teacher);
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "register_success"));
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

	private void studentRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentRegisterForm form = WebUtils.request2Bean(request,
				StudentRegisterForm.class);
		form.addLocale(request.getLocale());
		if (!form.check()) {
			// 表单校验失败
			request.setAttribute("errors", form.getErrors());
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		}
		Student student = new Student();
		WebUtils.copyBean(form, student);
		student.setRegisterTime(new Date());
		StudentService studentServiceImpl = new StudentServiceImpl();
		try {
			studentServiceImpl.register(student);
			request.setAttribute("message", I18nUtils.getI18nProperty(
					request.getLocale(), "register_success"));
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

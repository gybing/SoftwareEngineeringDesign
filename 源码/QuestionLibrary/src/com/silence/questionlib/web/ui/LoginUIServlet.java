package com.silence.questionlib.web.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.silence.questionlib.domain.Result;
import com.silence.questionlib.utils.WebUtils;

public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String admin = request.getParameter("admin");
		if (admin != null && !admin.trim().equals(""))
			request.setAttribute("admin", admin);
		String formId = WebUtils.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("formId", formId);
		request.setAttribute("formId", formId);

		Result result = WebUtils.makeCheckCode(request);
		session.setAttribute("checkCode", result.checkCode);
		request.setAttribute("path", result.path);

		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
				response);
	}

	

	
}

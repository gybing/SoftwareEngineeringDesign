package com.silence.questionlib.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.silence.questionlib.domain.Result;

public class WebUtils {

	// 设置验证码图片长宽
	private static final int WEIGHT = 240;
	private static final int HEIGHT = 70;

	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
		try {
			// 创建Bean
			T t = clazz.newInstance();
			// 将Request中的数据填充到Bean
			Enumeration enumeration = request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(t, name, value);
			}
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void copyBean(Object src, Object dest) {

		// 设置Date类型的转换器
		ConvertUtils.register(new Converter() {

			public Object convert(Class type, Object value) {
				if (value == null)
					return null;
				String str = (String) value;
				if (str.trim().equals("") || str.trim().equals("null"))
					return null;
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					return format.parse(str);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static Result makeCheckCode(HttpServletRequest request)
			throws IOException {
		// BufferImage生成图片，设置长宽，和类型：验证码类型
		BufferedImage image = new BufferedImage(WEIGHT, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// 得到一个图片对象，以便后面进行加工
		Graphics g = image.getGraphics();

		// 1.设置背景色
		setBackground(g);

		// 2.设置边框
		setBorder(g);

		// 3.设置随机线条 干扰线
		drawRandomLine(g);

		// 4.设置文字 Graphics2D这个类有旋转的功能
		String checkCode = drawRandomNum((Graphics2D) g);

		// 5.把图片生成缓存
		String filename = WebUtils.getUUID() + ".jpg";
		String realPath = request.getRealPath("/temp") + "/temp_" + filename;
		String path = request.getContextPath() + "/temp/temp_" + filename;
		// System.out.println("realPath = " + realPath);
		// System.out.println("path = " + path);
		File file = new File(realPath);
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		ImageIO.write(image, "jpg", fos);
		fos.close();
		System.out.println(checkCode);

		Result result = new Result();
		result.checkCode = checkCode;
		result.path = path;
		result.realPath = realPath;
		request.getSession().setAttribute("result", result);
		return result;
	}

	private static String drawRandomNum(Graphics2D g) {

		g.setColor(Color.RED);// 设置图片对象的颜色
		Font font = new Font("楷书", Font.BOLD, 35);
		g.setFont(font);// 设置图片对象的字体类型

		// a-zA-Z0-9
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		// x是字体的横坐标 后面随着循环递增
		int x = 10;
		StringBuffer sb = new StringBuffer();// 用StringBuffer重组字符，获得验证码信息
		for (int i = 0; i < 4; i++) {
			// 设置旋转角度 范围-30 ~ 30
			int degree = new Random().nextInt(60) - 30;
			// 随机数提取一个汉字 并存入password中
			String ch = base.charAt(new Random().nextInt(base.length())) + "";
			sb.append(ch);
			// 设置图片旋转 旋转弧度数和旋转中心
			g.rotate(degree * Math.PI / 180, x, 35);
			// 写入文字
			g.drawString(ch, x, 40);
			// 把刚才旋转的弧度数转回来。防止下次旋转相互叠加
			g.rotate(-degree * Math.PI / 180, x, 35);
			x += 55;
		}
		return sb.toString();
	}

	private static void drawRandomLine(Graphics g) {
		// 设置颜色 并根据横纵坐标画干扰线
		g.setColor(Color.RED);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WEIGHT);
			int x2 = new Random().nextInt(WEIGHT);
			int y1 = new Random().nextInt(HEIGHT);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private static void setBorder(Graphics g) {

		// 设 置 边 框 和 边 框 颜 色
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WEIGHT - 2, HEIGHT - 2);
	}

	private static void setBackground(Graphics g) {
		// 设置背景颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WEIGHT, HEIGHT);
	}
}

package com.silence.questionlib.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.silence.questionlib.dao.QuestionDao;
import com.silence.questionlib.dao.StudentDao;
import com.silence.questionlib.dao.TeacherDao;

/**
 * 持久层工厂
 * 
 * @author 宇强
 * 
 */
public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();
	private static Properties properties = new Properties();
	static {
		InputStream is = DaoFactory.class.getClassLoader().getResourceAsStream(
				"factory.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private DaoFactory() {

	}

	// 单例模式
	public static DaoFactory getInstance() {
		return instance;
	}

	public StudentDao getStudentDao(String name) {
		try {
			Class clazz = Class.forName(properties.getProperty(name));
			return (StudentDao) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public TeacherDao getTeacherDao(String name) {
		try {
			Class clazz = Class.forName(properties.getProperty(name));
			return (TeacherDao) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public QuestionDao getQuestionDao(String name) {
		try {
			Class clazz = Class.forName(properties.getProperty(name));
			return (QuestionDao) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

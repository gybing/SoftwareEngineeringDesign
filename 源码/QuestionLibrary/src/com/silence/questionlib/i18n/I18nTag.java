package com.silence.questionlib.i18n;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 国际化自定义标签
 * 
 * @author 林宇强 2015-12-05
 * 
 */
public class I18nTag extends TagSupport {

	/**
	 * i18n资源包中的key
	 */
	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		try {
			this.pageContext.getResponse().setCharacterEncoding("UTF-8");
			this.pageContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			this.pageContext.getOut().write(
					I18nUtils.getI18nProperty(this.pageContext.getRequest()
							.getLocale(), name));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.doStartTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

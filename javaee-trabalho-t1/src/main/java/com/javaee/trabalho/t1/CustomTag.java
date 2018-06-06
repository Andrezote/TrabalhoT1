package com.javaee.trabalho.t1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomTag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb = new StringBuilder();
			
		sb.append("<input type='submit' value='Gravar'")
		.append("</input>");
		
		getJspContext().getOut().write(sb.toString());
	}
	

}

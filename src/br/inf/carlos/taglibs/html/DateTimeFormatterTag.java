package br.inf.carlos.taglibs.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * @author Carlos Alberto Junior Spohr Poletto (carlosjrcabello@gmail.com)
 */
public class DateTimeFormatterTag extends TagSupport {

	private static final long serialVersionUID = 1669960932711639142L;

	protected Boolean test;
	
	@Override
	public int doEndTag() throws JspException {
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
		
		try {
			String disabled = "";
			
			if(this.test != null && this.test.equals(Boolean.TRUE)){
				disabled = " disabled='disabled' ";
			}
			
			this.pageContext.getOut().write(disabled);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}
}

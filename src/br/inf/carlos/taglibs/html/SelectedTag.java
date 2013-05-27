package br.inf.carlos.taglibs.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * @author Carlos Alberto Junior Spohr Poletto (carlosjrcabello@gmail.com)
 */
public class SelectedTag extends TagSupport {

	private static final long serialVersionUID = 1669960932711639142L;

	protected Boolean test;
	
	@Override
	public int doEndTag() throws JspException {
		
		try {
			String selected = "";
			
			if(this.test != null && this.test.equals(Boolean.TRUE)){
				selected = " selected='selected' ";
			}
			
			this.pageContext.getOut().write(selected);
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

package br.inf.carlos.taglibs.html;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * @author Carlos Alberto Junior Spohr Poletto (carlosjrcabello@gmail.com)
 */
public class TemplateTag extends TagSupport {

	private static final long serialVersionUID = 1669960932711639142L;

	protected String template;
	
	protected String part;
	
	@Override
	public int doEndTag() throws JspException {
		
		try {
			if("header".equals(part)){
				part = "header.jsp";
			}
			else
			{
				part = "footer.jsp";
			}
			
			String path = "/templates/" + template + "/" + part;
			this.pageContext.include(path);
			
			return EVAL_PAGE;
		} catch (IOException e) {
			e.printStackTrace();
			return super.doEndTag();
		} catch (ServletException e) {
			e.printStackTrace();
			return super.doEndTag();
		}
	}
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
}

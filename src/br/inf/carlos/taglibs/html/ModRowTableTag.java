package br.inf.carlos.taglibs.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * @author Carlos Alberto Junior Spohr Poletto (carlosjrcabello@gmail.com)
 */
public class ModRowTableTag extends TagSupport {

	private static final long serialVersionUID = 1669960932711639142L;

	protected int mod = 0;
	
	protected String in;
	
	protected String out;
	
	@Override
	public int doEndTag() throws JspException {
		
		try {
			if(this.mod % 2 == 0){
				this.pageContext.getOut().write(in);
			}
			else{
				this.pageContext.getOut().write(out);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}

	public int getMod() {
		return mod;
	}

	public void setMod(int mod) {
		this.mod = mod;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}
}

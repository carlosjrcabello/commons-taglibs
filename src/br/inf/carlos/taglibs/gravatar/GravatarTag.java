package br.inf.carlos.taglibs.gravatar;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * @author Carlos Alberto Junior Spohr Poletto (carlosjrcabello@gmail.com)
 */
public class GravatarTag extends TagSupport {

	private static final long serialVersionUID = 1669960932711639142L;

	/**
	 * This attribute represents the 'email' param of gravatar tag.
	 */
	protected String email;
	
	/**
	 * Represents the cssClass content.
	 */
	protected String cssClass;
	
	/**
	 * Represents the element (DOM) id.
	 */
	protected String id;

	/**
	 * Represents the size based on Gravatar API resize.
	 * 
	 * @see ?s= parameter.
	 */
	protected int imageSize = 200;

	/**
	 * This method implements the IMG injection in JSP page content.
	 */
	@Override
	public int doEndTag() throws JspException {
		
		try {
			if(this.getEmail() == null || this.getEmail().isEmpty()){
				this.setEmail("image-not-informed@gravatar-fail.com");
			}
			
			String hash = MD5.criptografa(this.getEmail());

			String url = "http://www.gravatar.com/avatar/" + hash + "?s=" + imageSize;

			String img = "<img src='" + url + "' ";
			
			if(this.getCssClass() != null && !this.getCssClass().isEmpty()){
				img += " class='" + this.getCssClass() + "'";
			}
			
			if(this.getId() != null && !this.getId().isEmpty()){
				img += " id='" + this.getId() + "'";
			}
			
			img = img + "/>";

			this.pageContext.getOut().write(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getImageSize() {
		return imageSize;
	}

	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}
}

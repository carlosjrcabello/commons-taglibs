package br.inf.carlos.taglibs.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import br.com.caelum.vraptor.validator.Message;

@SuppressWarnings("serial")
public class VRaptorMessageTag extends TagSupport {

	protected Collection<Message> messages;
	protected Locale locale;

	public VRaptorMessageTag() {
		super();
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			if (getMessages() != null && !getMessages().isEmpty()) {

				if (locale == null) {
					throw new JspException(
							"Nenhum locale definido. Use <t:messages messages=\"${errors}\" locale=\"${obj_foo.your_locale__}\"/> para informar o locale.");
				}
				
				StringBuilder sb = new StringBuilder();
				int i = 0;
				for (Message msg : this.messages) {
					
					if(i==0){
						sb.append("<div class='alert alert-");
						sb.append(msg.getCategory().toLowerCase());
						sb.append("' id='msg___");
						sb.append(i + "'>");
						sb.append("\t<button type='button' class='close' data-dismiss='alert'>&times;</button>");
					}
					sb.append(msg.getMessage());
					sb.append("<br/>");
					i++;
				}
				
				sb.append("</div>");
				pageContext.getOut().write(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return super.doEndTag();
		}
		
		return TagSupport.EVAL_PAGE;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}

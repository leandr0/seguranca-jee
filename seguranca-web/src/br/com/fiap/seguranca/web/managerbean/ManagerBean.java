/**
 * 
 */
package br.com.fiap.seguranca.web.managerbean;

import java.security.Principal;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author leandro.goncalves
 *
 */
public abstract class ManagerBean {

	protected HttpSession session;
	
	protected String user;
	
	public ManagerBean() {
		createNewSession();
	}
	
	private void createNewSession(){
		session = (HttpSession) 
		getExternalContext().getSession(true);
	}
	
	public String getUser(){
		
		HttpServletRequest request =  (HttpServletRequest) getExternalContext().getRequest();
		Principal principal = request.getUserPrincipal();
		
		return principal.getName();
	}
	
	protected void setAttributeInSession(String attributeName, Object value){
		session.setAttribute(attributeName, value);
	}
	
	protected Object getAttributeInSession(String attributeName){
		return session.getAttribute(attributeName);
	}
	
	protected ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance()
			.getExternalContext();
	}
	
	protected Object getAttributeInContext(String attributeName){
		return getExternalContext().getRequestMap().get(attributeName);
	}
			
	public HttpSession getSession() {
		
		if(session == null)
			createNewSession();
		
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}

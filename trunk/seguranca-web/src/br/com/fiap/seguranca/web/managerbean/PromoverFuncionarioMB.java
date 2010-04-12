/**
 * 
 */
package br.com.fiap.seguranca.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.seguranca.ejb.interfaces.local.PromoverFuncionarioLocal;
import br.com.fiap.seguranca.web.form.PromoverFuncionarioForm;
import br.com.fiap.seguranca.web.model.PromoverFuncionarioModel;

/**
 * @author leandro.goncalves
 *Classe que gerencia todas as requisoes da camada view
 * para o promocao de funcionarios
 */
public class PromoverFuncionarioMB extends ManagerBean{

	private PromoverFuncionarioForm form;
	
	private PromoverFuncionarioModel model;
	
	@EJB
	private PromoverFuncionarioLocal business;

	public PromoverFuncionarioMB() {
		inicializar();
	}
	
	private void inicializar(){
		this.form  = new PromoverFuncionarioForm();
		this.model = new PromoverFuncionarioModel();
	}
	
	public String promoverFuncionario(){
		
		business.promoverFucionarioGerente(model.getFuncionario());
		
		return null;
	}
	
	public String listarFuncionarios(){
		
		form.setFuncionarios(business.listarFuncionarios());
		
		return "promover-funcionario";
	}
	
	/**
	 * @return the form
	 */
	public PromoverFuncionarioForm getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(PromoverFuncionarioForm form) {
		this.form = form;
	}

	/**
	 * @return the model
	 */
	public PromoverFuncionarioModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(PromoverFuncionarioModel model) {
		this.model = model;
	}
}
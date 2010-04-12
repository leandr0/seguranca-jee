/**
 * 
 */
package br.com.fiap.seguranca.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.seguranca.ejb.interfaces.remote.CadastrarFuncionarioRemote;
import br.com.fiap.seguranca.web.form.CadastrarFuncionarioForm;
import br.com.fiap.seguranca.web.model.CadastrarFuncionarioModel;

/**
 * @author leandro.goncalves
 *
 */
public class CadastrarFuncionarioMB extends ManagerBean{
	
	private CadastrarFuncionarioForm form;
	
	private CadastrarFuncionarioModel model;
	
	@EJB
	private CadastrarFuncionarioRemote business;

	
	public CadastrarFuncionarioMB(){
		inicializar();
	}
	
	
	private void inicializar(){
		form  = new CadastrarFuncionarioForm();
		model = new CadastrarFuncionarioModel();
	}
	
	public String cadastrarFuncionario(){
		
		business.cadastrarFuncionario(model.getFuncionario());
		
		
		return null;
	}
	
	/**
	 * @return the form
	 */
	public CadastrarFuncionarioForm getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(CadastrarFuncionarioForm form) {
		this.form = form;
	}

	/**
	 * @return the model
	 */
	public CadastrarFuncionarioModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(CadastrarFuncionarioModel model) {
		this.model = model;
	}
}
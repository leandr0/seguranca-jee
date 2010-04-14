/**
 * 
 */
package br.com.fiap.seguranca.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.ejb.interfaces.local.ExcluirFuncionarioLocal;
import br.com.fiap.seguranca.web.form.ExcluirFuncionarioForm;
import br.com.fiap.seguranca.web.model.ExcluirFuncionarioModel;

/**
 * @author leandro.goncalves
 * Classe que gerencia todas as requisoes da camada view
 * para o exclusao de funcionarios
 */
public class ExcluirFuncionarioMB extends ManagerBean {

	private ExcluirFuncionarioForm form;
	
	private ExcluirFuncionarioModel model;
	
	@EJB
	private ExcluirFuncionarioLocal business;

	
	public ExcluirFuncionarioMB() {
		inicializar();
	}
	
	private void inicializar(){
		this.form  = new ExcluirFuncionarioForm();
		this.model = new ExcluirFuncionarioModel();
	}
	
	public String listarFuncionarios(){
		form.setFuncionarios(business.listarFuncionarios());
		return "excluir-funcionario";
	}
	
	public String excluirFuncionario(){
		
		
		
		business.excluirFuncionario(model.getFuncionario());
		listarFuncionarios();
		
		return null;
	}
	
	public String selecionarFuncionario(){
		
		for(Funcionario funcionario : form.getFuncionarios()){
			if(funcionario.getId().equals(form.getIdFuncionario()))
				model.setFuncionario(funcionario);
		}
		
		return null;
	}
	
	/**
	 * @return the form
	 */
	public ExcluirFuncionarioForm getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(ExcluirFuncionarioForm form) {
		this.form = form;
	}

	/**
	 * @return the model
	 */
	public ExcluirFuncionarioModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(ExcluirFuncionarioModel model) {
		this.model = model;
	}
}
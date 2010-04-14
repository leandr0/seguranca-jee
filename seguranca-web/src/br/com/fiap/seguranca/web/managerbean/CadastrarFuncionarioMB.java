/**
 * 
 */
package br.com.fiap.seguranca.web.managerbean;

import javax.ejb.EJB;

import br.com.fiap.seguranca.ejb.interfaces.local.CadastrarFuncionarioLocal;
import br.com.fiap.seguranca.web.form.CadastrarFuncionarioForm;
import br.com.fiap.seguranca.web.model.CadastrarFuncionarioModel;

/**
 * @author leandro.goncalves
 * Classe que gerencia todas as requisoes da camada view
 * para o cadastro de funcionarios
 */
public class CadastrarFuncionarioMB extends ManagerBean{
	
	private CadastrarFuncionarioForm form;
	
	private CadastrarFuncionarioModel model;
	
	@EJB
	private CadastrarFuncionarioLocal business;

	
	public CadastrarFuncionarioMB(){
		inicializar();
	}
	
	
	public String inicializar(){
		
		form  = new CadastrarFuncionarioForm();
		model = new CadastrarFuncionarioModel();
		
		return "cadastrar-funcionario";
	}
	
	public String novoUsuario(){
		
		model = new CadastrarFuncionarioModel();
		
		return null;
	}
	
	public String validarDadosFuncionario(){
		
		form.setDadosValidos(business.validarFuncionario(model.getFuncionario()));
		
		form.setMensagem(business.getMessageValidator());
		
		return null;
	}
	
	public String cadastrarFuncionario(){
		
		if(form.isDadosValidos()){
			business.cadastrarFuncionario(model.getFuncionario());
		
			form.setDadosValidos(business.isValid());
			
			if(!business.isValid())
				form.setMensagem(business.getMessageValidator());
		}
		
		novoUsuario();
		carregarListaFuncionarios();
		
		return null;
	}
	
	public String carregarListaFuncionarios(){
		
		form.setFuncionarios(business.listarFuncionarios());
		
		return "cadastrar-funcionario";
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
package br.com.erp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.erp.dao.EstadoDAO;
import br.com.erp.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar");
			erro.printStackTrace();
		}
		
	}
	
	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			estado = new Estado();
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Salvar");
			erro.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento) {
		try {
		estado = (Estado) evento.getComponent().getAttributes().get("linhaSelecionada");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		estados = estadoDAO.listar();
		
		Messages.addGlobalInfo("Excluido com Sucesso");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Excluir");
			erro.printStackTrace();
			
		}
	}
	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("linhaSelecionada");
	}

	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	

}

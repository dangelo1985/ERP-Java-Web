package br.com.erp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.erp.dao.MarcaDAO;
import br.com.erp.domain.Marca;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MarcaBean implements Serializable {
	
		private Marca marca;
		private List<Marca> marcas;

		@PostConstruct
		public void listar() {
			try {
				MarcaDAO marcaDAO = new MarcaDAO();
				marcas = marcaDAO.listar();
				
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar listar");
				erro.printStackTrace();
			}
			
		}
		
		public void novo() {
			marca = new Marca();
		}

		public void salvar() {
			try {
				MarcaDAO marcaDAO = new MarcaDAO();
				marcaDAO.merge(marca);
				marca = new Marca();
				
				marcas = marcaDAO.listar();
				
				Messages.addGlobalInfo("Salvo com Sucesso!");
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar Salvar");
				erro.printStackTrace();
			}
		}
		public void excluir(ActionEvent evento) {
			try {
			marca = (Marca) evento.getComponent().getAttributes().get("linhaSelecionada");
			MarcaDAO marcaDAO = new MarcaDAO();
			marcaDAO.excluir(marca);
			marcas = marcaDAO.listar();
			
			Messages.addGlobalInfo("Excluido com Sucesso");
			}catch(RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar Excluir");
				erro.printStackTrace();
				
			}
		}
		public void editar(ActionEvent evento) {
			marca = (Marca) evento.getComponent().getAttributes().get("linhaSelecionada");
		}

		public Marca getMarca() {
			return marca;
		}

		public void setMarca(Marca marca) {
			this.marca = marca;
		}

		public List<Marca> getMarcas() {
			return marcas;
		}

		public void setMarcas(List<Marca> marcas) {
			this.marcas = marcas;
		}

	

}

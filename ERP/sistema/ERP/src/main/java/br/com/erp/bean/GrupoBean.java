package br.com.erp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.erp.dao.GrupoDAO;
import br.com.erp.domain.Grupo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoBean implements Serializable {
	
		private Grupo grupo;
		private List<Grupo> grupos;

		@PostConstruct
		public void listar() {
			try {
				GrupoDAO grupoDAO = new GrupoDAO();
				grupos = grupoDAO.listar();
				
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar listar");
				erro.printStackTrace();
			}
			
		}
		
		public void novo() {
			grupo = new Grupo();
			
		}

		public void salvar() {
			try {
				GrupoDAO grupoDAO = new GrupoDAO();
				grupoDAO.merge(grupo);
				grupo = new Grupo();
				
				grupos = grupoDAO.listar();
				
				Messages.addGlobalInfo("Salvo com Sucesso!");
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar Salvar");
				erro.printStackTrace();
			}
		}
		public void excluir(ActionEvent evento) {
			try {
			grupo = (Grupo)  evento.getComponent().getAttributes().get("linhaSelecionada");
			GrupoDAO grupoDAO = new GrupoDAO();
			grupoDAO.excluir(grupo);
			grupos = grupoDAO.listar();
			
			Messages.addGlobalInfo("Excluido com Sucesso");
			}catch(RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar Excluir");
				erro.printStackTrace();
				
			}
		}
		public void editar(ActionEvent evento) {
			grupo = (Grupo) evento.getComponent().getAttributes().get("linhaSelecionada");
		}

		public Grupo getGrupo() {
			return grupo;
		}

		public void setGrupo(Grupo grupo) {
			this.grupo = grupo;
		}

		public List<Grupo> getGrupos() {
			return grupos;
		}

		public void setGrupos(List<Grupo> grupos) {
			this.grupos = grupos;
		}

		
		

	

}

package br.com.erp.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.erp.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado(); 
		estado.setNome("Goiás");
		estado.setSigla("GO");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado : resultado) {
			System.out.println(estado.getNome()+" - "+ estado.getSigla());
		}
	}
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);
		System.out.println(estado.getNome()+" - "+ estado.getSigla());
		
	}
	@Test
	@Ignore
	public void exluir() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);
		estadoDAO.excluir(estado);
	}
	@Test
	public void editar() {
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);
		
		estado.setNome("Santa Catarina");
		estadoDAO.editar(estado);
	}
}

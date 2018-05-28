package br.com.erp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Ncm extends GenericDomain {
	
	@Column(length = 9, nullable = false)
	private String codigoNCM;

	public String getCodigoNCM() {
		return codigoNCM;
	}

	public void setCodigoNCM(String codigoNCM) {
		this.codigoNCM = codigoNCM;
	}
	
}

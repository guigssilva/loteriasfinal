/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.particular.loteria.controller.jsf;

import org.apache.log4j.Logger;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.PlcBaseMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

@Specializes
@PlcHandleException
@SPlcMB
public class AppMB extends PlcBaseMB {

	private static final long serialVersionUID = 1L;
	
	@Inject
	protected transient Logger log;
	
	private Long qtdJogosGerado;
	
	private String nrUltiConcurso;
	
	private String nrUltiResultado;
	
	public String getNrUltiConcurso() {
		return nrUltiConcurso;
	}

	public void setNrUltiConcurso(String nrUltiConcurso) {
		this.nrUltiConcurso = nrUltiConcurso;
	}

	public String getNrUltiResultado() {
		return nrUltiResultado;
	}

	public void setNrUltiResultado(String nrUltiResultado) {
		this.nrUltiResultado = nrUltiResultado;
	}
	
	public Long getQtdJogosGerado() {
		return qtdJogosGerado;
	}

	public void setQtdJogosGerado(Long qtdJogosGerado) {
		this.qtdJogosGerado = qtdJogosGerado;
	}

	
}

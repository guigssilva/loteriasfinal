/**
 * 
 */
package br.particular.loteria.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.particular.loteria.enumerate.SimNao;

/**
 * @author Guilherme
 *
 */
@MappedSuperclass

public class MegaSena extends AppBaseEntity {
	
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "SE_MEGA_SENA")
	private Long id;
	
	@NotNull
	@Digits(integer=2, fraction=0)
	private Long nrResultado1;
	
	@NotNull
	@Digits(integer=2, fraction=0)
	private Long nrResultado2;
	
	@NotNull
	@Digits(integer=2, fraction=0)
	private Long nrResultado3;
	
	@NotNull
	@Digits(integer=2, fraction=0)
	private Long nrResultado4;
	
	@NotNull
	@Digits(integer=2, fraction=0)
	private Long nrResultado5;
	
	@NotNull
	@Digits(integer=2, fraction=0)
	private Long nrResultado6;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtResultado;
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtGeracao;
	
	@NotNull
	@Digits(integer=15, fraction=0)
	private Long nrConcurso;
	
	@Enumerated(EnumType.STRING)
	@Column(length=1)
	private SimNao nrGeradoFoiPremiado;
	
	@Size(max = 250)
	private String mensagem;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public Long getNrResultado1() {
		return nrResultado1;
	}

	public void setNrResultado1(Long nrResultado1) {
		this.nrResultado1=nrResultado1;
	}

	public Long getNrResultado2() {
		return nrResultado2;
	}

	public void setNrResultado2(Long nrResultado2) {
		this.nrResultado2=nrResultado2;
	}

	public Long getNrResultado3() {
		return nrResultado3;
	}

	public void setNrResultado3(Long nrResultado3) {
		this.nrResultado3=nrResultado3;
	}

	public Long getNrResultado4() {
		return nrResultado4;
	}

	public void setNrResultado4(Long nrResultado4) {
		this.nrResultado4=nrResultado4;
	}

	public Long getNrResultado5() {
		return nrResultado5;
	}

	public void setNrResultado5(Long nrResultado5) {
		this.nrResultado5=nrResultado5;
	}

	public Long getNrResultado6() {
		return nrResultado6;
	}

	public void setNrResultado6(Long nrResultado6) {
		this.nrResultado6=nrResultado6;
	}

	public Date getDtResultado() {
		return dtResultado;
	}

	public void setDtResultado(Date dtResultado) {
		this.dtResultado=dtResultado;
	}

	public Date getDtGeracao() {
		return dtGeracao;
	}

	public void setDtGeracao(Date dtGeracao) {
		this.dtGeracao=dtGeracao;
	}

	public Long getNrConcurso() {
		return nrConcurso;
	}

	public void setNrConcurso(Long nrConcurso) {
		this.nrConcurso=nrConcurso;
	}

	public SimNao getNrGeradoFoiPremiado() {
		return nrGeradoFoiPremiado;
	}

	public void setNrGeradoFoiPremiado(SimNao nrGeradoFoiPremiado) {
		this.nrGeradoFoiPremiado=nrGeradoFoiPremiado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem=mensagem;
	}

}

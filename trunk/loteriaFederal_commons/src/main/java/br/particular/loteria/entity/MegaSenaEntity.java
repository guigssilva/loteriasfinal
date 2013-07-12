package br.particular.loteria.entity;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="MEGA_SENA", schema="loterias")
@SequenceGenerator(name="SE_MEGA_SENA", sequenceName="SE_MEGA_SENA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="MegaSenaEntity.querySel2", query="select id as id, nrResultado1 as nrResultado1, nrResultado2 as nrResultado2, nrResultado3 as nrResultado3, nrResultado4 as nrResultado4, nrResultado6 as nrResultado6, nrResultado5 as nrResultado5 from MegaSenaEntity order by id asc"),
	@NamedQuery(name="MegaSenaEntity.querySel", query="select id as id, nrResultado1 as nrResultado1, nrResultado2 as nrResultado2, nrResultado3 as nrResultado3, nrResultado4 as nrResultado4, nrResultado5 as nrResultado5, nrResultado6 as nrResultado6 from MegaSenaEntity order by id asc"),
	@NamedQuery(name="MegaSenaEntity.querySelLookup", query="select id as id, mensagem as mensagem from MegaSenaEntity where id = ? order by id asc")
})
public class MegaSenaEntity extends MegaSena {

	private static final long serialVersionUID = 1L;
	
	@Transient
	private java.util.List<MegaSenaEntity> gerarmegasenaLista = new java.util.ArrayList<MegaSenaEntity>();
	
 	
    /*
     * Construtor padrÃ£o
     */
    public MegaSenaEntity() {
    }
	@Override
	public String toString() {
		return getMensagem();
	}
	
	private transient Long qtdJogosGerado;

	public Long getQtdJogosGerado() {
		return qtdJogosGerado;
	}
	public void setQtdJogosGerado(Long qtdJogosGerado) {
		this.qtdJogosGerado = qtdJogosGerado;
	}
	public java.util.List<MegaSenaEntity> getGerarmegasenaLista() {
		return gerarmegasenaLista;
	}
	public void setGerarmegasenaLista(
			java.util.List<MegaSenaEntity> gerarmegasenaLista) {
		this.gerarmegasenaLista = gerarmegasenaLista;
	}
	
	

}

package br.com.projetos.entity;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="MEGA_SENA", schema="loterias")
@SequenceGenerator(name="SE_MEGA_SENA", sequenceName="SE_MEGA_SENA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="MegaSenaEntity.querySel", query="select id as id, nrResultado1 as nrResultado1, nrResultado2 as nrResultado2, nrResultado3 as nrResultado3, nrResultado4 as nrResultado4, nrResultado5 as nrResultado5, nrResultado6 as nrResultado6 from MegaSenaEntity order by id asc"),
	@NamedQuery(name="MegaSenaEntity.querySelLookup", query="select id as id, mensagem as mensagem from MegaSenaEntity where id = ? order by id asc")
})
public class MegaSenaEntity extends MegaSena {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrÃ£o
     */
    public MegaSenaEntity() {
    }
	@Override
	public String toString() {
		return getMensagem();
	}

}

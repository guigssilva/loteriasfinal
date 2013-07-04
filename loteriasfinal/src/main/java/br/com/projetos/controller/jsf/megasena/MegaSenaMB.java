package br.com.projetos.controller.jsf.megasena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.projetos.controller.jsf.AppMB;
import br.com.projetos.entity.MegaSenaEntity;
import br.com.projetos.model.Urna;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

@PlcConfigAggregation(
		entity = br.com.projetos.entity.MegaSenaEntity.class
	
	)


@PlcConfigForm (
	
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/gerarmegasena")
	
	
		,selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
				pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=1000))
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("megasena")
@PlcHandleException
public class MegaSenaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	private Long qtdJogosGerado;

	public Long getQtdJogosGerado() {
		return qtdJogosGerado;
	}

	public void setQtdJogosGerado(Long qtdJogosGerado) {
		this.qtdJogosGerado = qtdJogosGerado;
	}

	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("megasena")
	public MegaSenaEntity createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new MegaSenaEntity();
              this.newEntity();
         }

        return (MegaSenaEntity) this.entityPlc;   
        
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("megasenaLista")
	public PlcEntityList createEntityListPlc() {
		
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}		
	
	
	@Override
	public void executeBefore() {
		HttpServletRequest request = contextUtil.getRequest();
		
		request.setAttribute("exibePesquisarPlc", "N");
		request.setAttribute("exibeLimparPlc", "N");
		visaoJsfUtil.show(request, "GerarNumeros");
		
		super.executeBefore();
	}
	
	public String gerarNumeros() {
		Long qtdJogosAux = getQtdJogosGerado();
		List<Object> listaMegaSena= new ArrayList<Object>();
		if(qtdJogosAux!=null && qtdJogosAux>0){
			for(int i = 0; i< qtdJogosAux; i++){			
				List<Integer> urna = Urna.createUrna(60);
				int[] resultados;
				resultados = Urna.sorteiSemReposicao(urna, 6);
				Arrays.sort(resultados);
				
				MegaSenaEntity megaSena = new MegaSenaEntity();
				for(int j = 0; j <= resultados.length ;j++){
					if(j == 0)
						megaSena.setNrResultado1(Long.valueOf(resultados[j]));
					if(j == 1)
						megaSena.setNrResultado2(Long.valueOf(resultados[j]));
					if(j == 2)
						megaSena.setNrResultado3(Long.valueOf(resultados[j]));
					if(j == 3)
						megaSena.setNrResultado4(Long.valueOf(resultados[j]));
					if(j == 4)
						megaSena.setNrResultado5(Long.valueOf(resultados[j]));
					if(j == 5)
						megaSena.setNrResultado6(Long.valueOf(resultados[j]));
				}
				listaMegaSena.add(megaSena);
			}
			this.createEntityListPlc();
			this.entityListPlc.setItensPlc(listaMegaSena);
	
		}
		
		return null;		
	}
}

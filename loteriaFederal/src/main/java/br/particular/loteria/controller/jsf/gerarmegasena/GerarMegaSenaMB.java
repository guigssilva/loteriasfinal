package br.particular.loteria.controller.jsf.gerarmegasena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.particular.loteria.controller.jsf.AppMB;
import br.particular.loteria.entity.MegaSenaEntity;
import br.particular.loteria.model.Urna;
import br.particular.loteria.model.WorldWideWeb;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

@PlcConfigAggregation(entity = br.particular.loteria.entity.MegaSena.class

)
@PlcConfigForm(

formPattern = FormPattern.Con, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/gerarmegasena")

, selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage = 1000), apiQuerySel = "querySel3"))
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("gerarmegasena")
@PlcHandleException
public class GerarMegaSenaMB extends AppMB {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("gerarmegasena")
	public MegaSenaEntity createEntityPlc() {

		if (this.entityPlc == null) {
			this.entityPlc = new MegaSenaEntity();
			this.newEntity();
		}

		return (MegaSenaEntity) this.entityPlc;

	}

	/**
	 * Lista de entidades da ação injetado pela CDI
	 */
	@Produces
	@Named("gerarmegasenaLista")
	public PlcEntityList createEntityListPlc() {

		if (this.entityListPlc == null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}

	@Override
	public void executeBefore() {
		// HttpServletRequest request = contextUtil.getRequest();

		// request.setAttribute("exibePesquisarPlc", "N");
		// request.setAttribute("exibeLimparPlc", "N");
		// visaoJsfUtil.show(request, "GerarNumeros");

		String nrConcurso = this.obterNumeroUltimoConcursoMegaSena();
		String[] nrResultados = this.obterResultadoMegaSena(nrConcurso);
		
		this.setNrUltiConcurso(nrConcurso);
		String nrResultado = "";
		Arrays.sort(nrResultados);
		for(String aux: nrResultados){
			nrResultado = nrResultado.concat(aux).concat(" "); 
		}
		this.setNrUltiResultado(nrResultado);

		super.executeBefore();
	}

	@Override
	public String search() {
		Long qtdJogosAux = getQtdJogosGerado();
		Collection listaMegaSena = new ArrayList<Object>();
		if (qtdJogosAux != null && qtdJogosAux > 0) {
			for (int i = 0; i < qtdJogosAux; i++) {
				List<Integer> urna = Urna.createUrna(60);
				int[] resultados;
				resultados = Urna.sorteiSemReposicao(urna, 6);
				Arrays.sort(resultados);

				MegaSenaEntity megaSena = new MegaSenaEntity();
				for (int j = 0; j <= resultados.length; j++) {
					if (j == 0)
						megaSena.setNrResultado1(Long.valueOf(resultados[j]));
					if (j == 1)
						megaSena.setNrResultado2(Long.valueOf(resultados[j]));
					if (j == 2)
						megaSena.setNrResultado3(Long.valueOf(resultados[j]));
					if (j == 3)
						megaSena.setNrResultado4(Long.valueOf(resultados[j]));
					if (j == 4)
						megaSena.setNrResultado5(Long.valueOf(resultados[j]));
					if (j == 5)
						megaSena.setNrResultado6(Long.valueOf(resultados[j]));
				}
				listaMegaSena.add(megaSena);
			}
			this.getEntityListPlc().setItensPlc((List) listaMegaSena);
			this.entityListPlc.setItensPlc((List) listaMegaSena);
		}
		return "gerarmegasena";
	}

	/**
	 * Obter o resultado da Megasena.
	 * 
	 * @param concurso Número do Concurso.
	 * @return Resultado da Megasena.
	 */
	public static String[] obterResultadoMegaSena(String concurso) {
		String url;
		if ( concurso == null || "".equals(concurso)) {
			url = "http://www1.caixa.gov.br/loterias/loterias/megasena/megasena_pesquisa_new.asp?f_megasena=";
		} else {
			url = "http://www1.caixa.gov.br/loterias/loterias/megasena/megasena_pesquisa_new.asp?submeteu=sim&opcao=concurso&txtConcurso=" + concurso;
		}			
		String conteudo = WorldWideWeb.obterConteudoSite(url, "UTF-8");
		String resultado = conteudo.split("\\|")[2].replaceAll("<ul>", "").replaceAll("</ul>","").replaceAll("<li>", "").replaceAll("<span class=\"num_sorteio\">","").replaceAll("</span>","").replaceAll("</li>","|");
		String[] resultadoMegaSena = resultado.split("\\|");
		return resultadoMegaSena;
	}
	
	/**
	 * Obter o número do concurso mais atual da megasena.
	 * 
	 * 
	 * @return Número do Concurso.
	 */
	public static String obterNumeroUltimoConcursoMegaSena() {
		String url = "http://www1.caixa.gov.br/loterias/loterias/megasena/megasena_pesquisa_new.asp?f_megasena="
				+ new Date().getTime();
		String conteudo = WorldWideWeb.obterConteudoSite(url, "UTF-8");
		return conteudo.split("\\|")[0];
	}

	

}

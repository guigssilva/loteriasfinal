/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.particular.loteria.controller.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;

import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.controller.listener.PlcServletContextListener;

/**
 * Classe destinada a programações em tempo de inicialização  da aplicação
 */
public class AppServletContextListener extends PlcServletContextListener {
	
	protected static final Logger log = Logger.getLogger(AppServletContextListener.class.getCanonicalName());

	@Override
	public void cdAoEncerrarAplicacao(ServletContextEvent event)
			throws PlcException {
		log.info( "Encerrando a Aplicacao");

	}

	@Override
	public void ciAoInicializarAplicacao(ServletContextEvent event)
			throws PlcException {
		log.info( "Tratamento da Aplicacao: Inicializando a Aplicacao");
	}
	
}

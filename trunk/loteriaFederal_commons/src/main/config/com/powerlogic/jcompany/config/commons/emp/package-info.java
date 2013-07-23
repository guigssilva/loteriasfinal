/* ******************* REDEFINIÇÃES DE META-DADOS GLOBAIS DA EMPRESA **********************
  ********************** Configurações default para toda a empresa *************************
  *******************************************************************************************/
			
@PlcConfigCompany(name = "Informa Informática Consultoria LTDA", domain = "http://www.informasistemas.com.br/", acronym = "INF", 
					logo = "/recursos/midia/login-logo-empresa.png", address = "Rua. Rooselvet de Oliveira, 345 / 2Âº andar Sala 16. CEP:38.400-610, Centro - Uberlândia/MG",
					supportEmail = "informa@informasistemas.com.br",supportPhone = "55 34 3235-9233")

@PlcConfigSuffixClass(entity="Entity",repository="Repository")

@PlcConfigPackage (entity=".entity.", application="br.particular.loteria")
			    	 
package com.powerlogic.jcompany.config.commons.emp;

import com.powerlogic.jcompany.config.application.PlcConfigCompany;
import com.powerlogic.jcompany.config.application.PlcConfigPackage;
import com.powerlogic.jcompany.config.application.PlcConfigSuffixClass;


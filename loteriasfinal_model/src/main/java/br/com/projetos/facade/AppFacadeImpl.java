package br.com.projetos.facade;

import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcFacade;
import com.powerlogic.jcompany.facade.PlcFacadeImpl;
import br.com.projetos.facade.IAppFacade;

@QPlcDefault
@SPlcFacade
public class AppFacadeImpl extends PlcFacadeImpl implements IAppFacade{

}

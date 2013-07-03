package br.com.projetos.entity.enumerate;

/**
 * Enum de dominio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum SimNao {
    
	S("{simNao.S}"),
	N("{simNao.N}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private SimNao(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}

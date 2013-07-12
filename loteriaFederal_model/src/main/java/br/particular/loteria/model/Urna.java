package br.particular.loteria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Guilherme
 *
 */
public class Urna {
	
	 /** 
     * Sorteia aleatoriamente as bolas da urna sem reposição, sendo a lista urna, sera  
     * alterada e ao final da operação ficará sem suas bolas. 
     * @param urna contem as bolas a serem sorteadas. 
     * @param numeroDeBolasASortear número de bolas a sortear 
     * @return o resultado do sorteio. 
     * @throws IllegalArgumentException Quando algum argumento é Illegal, por exemplo 
     *          quando numeroDeBolasASortear é maior que a quantidade de bolas na urna, 
     *          ou quando numeroDeBolasASortear ou tamanho da urna é igual a zero. 
     */  
    public static int[] sorteiSemReposicao(List<Integer> urna,  
            int numeroDeBolasASortear) throws IllegalArgumentException {  
          
        if (numeroDeBolasASortear > urna.size())   
            throw new IllegalArgumentException("Quantidade de bolas a sortear maior que o número de bolas na urna");  
        if (numeroDeBolasASortear == 0)   
            throw new IllegalArgumentException("Quantidade de bolas a sortear não pode ser zero");  
        if (urna.size() == 0)  
            throw new IllegalArgumentException("A urna não pode estar vazia");  
          
        int[] resultados = new int[numeroDeBolasASortear];  
        Random roleta = new Random();  
        for (int i = 0; i < numeroDeBolasASortear; i++)  
            //pega uma bola aleatorea da urna (atraves da roleta), e a retirna  
            resultados[i] = urna.remove(roleta.nextInt(urna.size()));  
        return resultados;  
    }  
      
    /** 
     * Cria uma urna contendo o número de bolas enviadas, que inicia do número 1. 
     * @param numeroDeBolasNaUrna número de bolas que a urna contem. 
     * @return a urna pronta. 
     */  
    public static List<Integer> createUrna(int numeroDeBolasNaUrna) {  
        return createUrna(numeroDeBolasNaUrna,1);  
    }  
      
    /** 
     * Cria uma urna contendo o número de bolas enviadas, que inicia do número numeroIncial. 
     * @param numeroDeBolasNaUrna número de bolas que a urna contem.  
     * @param numeroIncial número inicial da bola da urna. 
     * @return 
     */  
    public static List<Integer> createUrna(int numeroDeBolasNaUrna,int numeroIncial) {  
        List<Integer> urna = new ArrayList<Integer>(numeroDeBolasNaUrna);  
        for (int i = 0; i < numeroDeBolasNaUrna; i++)   
            urna.add(i+numeroIncial);  
        return urna;  
    }  

}

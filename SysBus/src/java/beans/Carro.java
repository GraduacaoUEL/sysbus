package beans;

import java.io.Serializable;

public class Carro implements Serializable {

    private int codigoCarro;
    private int numeroDePassageiros;
    private int linhaCarro;
    
    /**
     * Construtor vazio.
     */
    public Carro() {
    }

    /**
     * Retorna o código do carro.
     * @return Código do carro.
     */
    public int getCodigoCarro() {
        return codigoCarro;
    }
    
    /**
     * Atribui o código do carro.
     * @param codigoCarro Código do carro.
     */
    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }
    
    /**
     * Retorna o número de passageiros que o carro suporta.
     * @return Número de passageiros que o carro suporta.
     */
    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }
    
    /**
     * Atribui o número de passageiros que o carro suporta.
     * @param numeroDePassageiros Número de passageiros que o carro suporta.
     */
    public void setNumeroDePassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }
    
    /**
     * Retorna o código da linha à qual o carro está vinculado.
     * @return Código da linha à qual o carro está vinculado.
     */
    public int getLinhaCarro() {
        return linhaCarro;
    }
    
    /**
     * Atribui o código da linha à qual o carro está vinculado.
     * @param linhaCarro Código da linha à qual o carro está vinculado.
     */
    public void setLinhaCarro(int linhaCarro) {
        this.linhaCarro = linhaCarro;
    }
}
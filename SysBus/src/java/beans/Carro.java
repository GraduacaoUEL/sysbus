package beans;

import java.io.Serializable;

public class Carro implements Serializable {

    private int codigoCarro;
    private int numeroDePassageiros;
    private int linhaCarro;

    public Carro() {
    }

    /**@return O código do carro.*/
    public int getCodigoCarro() {
        return codigoCarro;
    }

    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    /**@return O número de passageiros (sentados) que o carro suporta.*/
    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }

    public void setNumeroDePassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }

    /**@return O código da linha à qual o carro está vinculado.*/
    public int getLinhaCarro() {
        return linhaCarro;
    }

    public void setLinhaCarro(int linhaCarro) {
        this.linhaCarro = linhaCarro;
    }
}
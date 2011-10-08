package beans;

import java.io.Serializable;

public class Carro implements Serializable {

    private int codigoCarro;
    private int numeroDePassageiros;
    private int linhaCarro;

    public Carro() {
    }

    public int getCodigoCarro() {
        return codigoCarro;
    }

    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }

    public void setNumeroDePassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }

    public int getLinhaCarro() {
        return linhaCarro;
    }

    public void setLinhaCarro(int linhaCarro) {
        this.linhaCarro = linhaCarro;
    }
}
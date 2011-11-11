/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author helioalb
 */
public class CarroInnerJoinLinha {
    private int codigoCarro;
    private int numeroDePassageiros;
    private String nomeLinha;

    /**
     * @return the codigoCarro
     */
    public int getCodigoCarro() {
        return codigoCarro;
    }

    /**
     * @param codigoCarro the codigoCarro to set
     */
    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    /**
     * @return the numeroPassageiros
     */
    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }

    /**
     * @param numeroPassageiros the numeroPassageiros to set
     */
    public void setNumeroPassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }

    /**
     * @return the nomeLinha
     */
    public String getNomeLinha() {
        return nomeLinha;
    }

    /**
     * @param nomeLinha the nomeLinha to set
     */
    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }
    
    
}

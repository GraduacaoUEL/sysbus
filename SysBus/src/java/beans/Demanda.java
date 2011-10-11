package beans;

import java.io.Serializable;

public class Demanda implements Serializable {

    private int codigoDemanda;
    private String nomeDemanda;
    
    /**
     * Construtor vazio.
     */
    public Demanda() {
    }
    
    /**
     * Retorna o código da demanda.
     * @return Código da demanda.
     */
    public int getCodigoDemanda() {
        return codigoDemanda;
    }
    
    /**
     * Atribui o código da demanda.
     * @param codigoDemanda Código da demanda.
     */
    public void setCodigoDemanda(int codigoDemanda) {
        this.codigoDemanda = codigoDemanda;
    }
    
    /**
     * Retorna o nome da demanda.
     * @return Nome da demanda.
     */
    public String getNomeDemanda() {
        return nomeDemanda;
    }
    
    /**
     * Atribui o nome da demanda.
     * @param nomeDemanda Nome da demanda.
     */
    public void setNomeDemanda(String nomeDemanda) {
        this.nomeDemanda = nomeDemanda;
    }
}
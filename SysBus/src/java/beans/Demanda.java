package beans;

import java.io.Serializable;

public class Demanda implements Serializable {

    private int codigoDemanda;
    private String nomeDemanda;

    public Demanda() {
    }

    /**@return O código da demanda.*/
    public int getCodigoDemanda() {
        return codigoDemanda;
    }
    
    public void setCodigoDemanda(int codigoDemanda) {
        this.codigoDemanda = codigoDemanda;
    }

    /**@return O nome da demanda.*/
    public String getNomeDemanda() {
        return nomeDemanda;
    }

    public void setNomeDemanda(String nomeDemanda) {
        this.nomeDemanda = nomeDemanda;
    }
}
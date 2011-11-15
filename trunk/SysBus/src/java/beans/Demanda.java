package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Demanda implements Serializable {

    private int codigoDemanda;
    private String nomeDemanda;
    private ArrayList<Periodo> periodosDemanda =
            new ArrayList<Periodo>();
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

    /**
     * @return the periodosDemanda
     */
    public ArrayList<Periodo> getPeriodosDemanda() {
        return periodosDemanda;
    }

    /**
     * @param periodosDemanda the periodosDemanda to set
     */
    public void setPeriodosDemanda(ArrayList<Periodo> periodosDemanda) {
        this.periodosDemanda = periodosDemanda;
    }
}
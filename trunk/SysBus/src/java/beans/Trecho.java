package beans;

import java.io.Serializable;
import java.sql.Time;

public class Trecho implements Serializable {

    private int codigoTrecho;
    private String origemTrecho;
    private String destinoTrecho;
    private Time tempoTrecho;
    private float distanciaTrecho;
    private int custoTrecho;

    public Trecho() {
    }

    /**@return O código do trecho.*/
    public int getCodigoTrecho() {
        return codigoTrecho;
    }
    
    public void setCodigoTrecho(int codigoTrecho) {
        this.codigoTrecho = codigoTrecho;
    }

    /**@return A cidade de origem do trecho.*/
    public String getOrigemTrecho() {
        return origemTrecho;
    }

    public void setOrigemTrecho(String origemTrecho) {
        this.origemTrecho = origemTrecho;
    }

    /**@return A cidade de destino do trecho.*/
    public String getDestinoTrecho() {
        return destinoTrecho;
    }

    public void setDestinoTrecho(String destinoTrecho) {
        this.destinoTrecho = destinoTrecho;
    }

    /**@return O tempo usado para percorrer o trecho. O formato é "hh:mm:ss"*/
    public Time getTempoTrecho() {
        return tempoTrecho;
    }

    public void setTempoTrecho(Time tempoTrecho) {
        this.tempoTrecho = tempoTrecho;
    }

    /**@return A distância entre a cidade de origem à cidade de origem.
     * A distância é medida em km.*/
    public float getDistanciaTrecho() {
        return distanciaTrecho;
    }

    public void setDistanciaTrecho(float distanciaTrecho) {
        this.distanciaTrecho = distanciaTrecho;
    }

    /**@return O custo para para se percorrer o trecho, o custo é dado em R$.*/
    public int getCustoTrecho() {
        return custoTrecho;
    }

    public void setCustoTrecho(int custoTrecho) {
        this.custoTrecho = custoTrecho;
    }
}
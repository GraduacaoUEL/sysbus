package beans;

import java.sql.Time;

public class Trecho {

    private int codigoTrecho;
    private String origemTrecho;
    private String destinoTrecho;
    private Time tempoTrecho;
    private float distanciaTrecho;
    private int custoTrecho;

    public Trecho() {
    }

    public int getCodigoTrecho() {
        return codigoTrecho;
    }
    
    public void setCodigoTrecho(int codigoTrecho) {
        this.codigoTrecho = codigoTrecho;
    }

    public String getOrigemTrecho() {
        return origemTrecho;
    }

    public void setOrigemTrecho(String origemTrecho) {
        this.origemTrecho = origemTrecho;
    }

    public String getDestinoTrecho() {
        return destinoTrecho;
    }

    public void setDestinoTrecho(String destinoTrecho) {
        this.destinoTrecho = destinoTrecho;
    }

    public Time getTempoTrecho() {
        return tempoTrecho;
    }

    public void setTempoTrecho(Time tempoTrecho) {
        this.tempoTrecho = tempoTrecho;
    }

    public float getDistanciaTrecho() {
        return distanciaTrecho;
    }

    public void setDistanciaTrecho(float distanciaTrecho) {
        this.distanciaTrecho = distanciaTrecho;
    }

    public int getCustoTrecho() {
        return custoTrecho;
    }

    public void setCustoTrecho(int custoTrecho) {
        this.custoTrecho = custoTrecho;
    }
}
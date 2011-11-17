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

    /**
     * Construtor vazio.
     */
    public Trecho() {
    }

    /**
     * Retorna o código do trecho.
     * @return O código do trecho.
     */
    public int getCodigoTrecho() {
        return codigoTrecho;
    }

    /**
     * Atribui o código do trecho.
     * @param codigoTrecho Código do trecho.
     */
    public void setCodigoTrecho(int codigoTrecho) {
        this.codigoTrecho = codigoTrecho;
    }

    /**
     * Retorna a cidade de origem do trecho.
     * @return Cidade de origem do trecho.
     */
    public String getOrigemTrecho() {
        return origemTrecho;
    }

    /**
     * Atribui a cidade de origem do trecho.
     * @param origemTrecho Cidade de origem do trecho.
     */
    public void setOrigemTrecho(String origemTrecho) {
        this.origemTrecho = origemTrecho;
    }

    /**
     * Retorna a cidade de destino do trecho.
     * @return Cidade de destino do trecho.
     */
    public String getDestinoTrecho() {
        return destinoTrecho;
    }

    /**
     * Atribui a cidade de destino do trecho.
     * @param destinoTrecho Cidade de destino do trecho.
     */
    public void setDestinoTrecho(String destinoTrecho) {
        this.destinoTrecho = destinoTrecho;
    }

    /**
     * Retorna o tempo gasto para percorrer o trecho no formato "hh:mm:ss".
     * @return Tempo gasto para percorrer o trecho.
     */
    public Time getTempoTrecho() {
        return tempoTrecho;
    }

    /**
     * Atribui o tempo gasto para percorrer o trecho no formato "hh:mm:ss".
     * @param tempoTrecho Tempo gasto para percorrer o trecho.
     */
    public void setTempoTrecho(Time tempoTrecho) {
        this.tempoTrecho = tempoTrecho;
    }

    /**
     * Retorna a distância da cidade de origem à cidade de destino em km.
     * @return Distância da cidade de origem à cidade de destino.
     */
    public float getDistanciaTrecho() {
        return distanciaTrecho;
    }

    /**
     * Atribui a distância da cidade de origem à cidade de destino em km.
     * @param distanciaTrecho Distância da cidade de origem à cidade de destino.
     */
    public void setDistanciaTrecho(float distanciaTrecho) {
        this.distanciaTrecho = distanciaTrecho;
    }

    /**
     * Retorna o custo para percorrer o trecho em R$.
     * @return Custo para percorrer o trecho.
     */
    public int getCustoTrecho() {
        return custoTrecho;
    }

    /**
     * Atribui o custo para percorrer o trecho em R$.
     * @param custoTrecho Custo para percorrer o trecho.
     */
    public void setCustoTrecho(int custoTrecho) {
        this.custoTrecho = custoTrecho;
    }
}
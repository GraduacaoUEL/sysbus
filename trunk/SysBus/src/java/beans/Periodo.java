package beans;

import java.io.Serializable;
import java.sql.Time;

public class Periodo implements Serializable {

    private int codigoPeriodo;
    private Time inicioPeriodo;
    private Time fimPeriodo;
    private float fatorMultiplicacao;
    
    /**
     * Construtor vazio.
     */
    public Periodo() {
    }
    
    /**
     * Retorna o código do período.
     * @return Código do período.
     */
    public int getCodigoPeriodo() {
        return codigoPeriodo;
    }
    
    /**
     * Atribui o código do período.
     * @param codigoPeriodo Código do período.
     */
    public void setCodigoPeriodo(int codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }
    
    /**
     * Retorna a hora de início do período no formato "hh:mm:ss".
     * @return Hora de início do período.
     */
    public Time getInicioPeriodo() {
        return inicioPeriodo;
    }
    
    /**
     * Atribui a hora de início do período no formato "hh:mm:ss".
     * @param inicioPeriodo Hora de início do período.
     */
    public void setInicioPeriodo(Time inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }
    
    /**
     * Retorna a hora de fim do período no formato "hh:mm:ss".
     * @return Hora de fim do período.
     */
    public Time getFimPeriodo() {
        return fimPeriodo;
    }
    
    /**
     * Atribui a hora de fim do período no formato "hh:mm:ss".
     * @param fimPeriodo Hora de fim do período.
     */
    public void setFimPeriodo(Time fimPeriodo) {
        this.fimPeriodo = fimPeriodo;
    }

    /**
     * Retorna o fator de multiplicação.
     * @return Fator de multiplicação.
     */
    public float getFatorMultiplicacao() {
        return fatorMultiplicacao;
    }
    
    /**
     * Atribui o fator de multiplicação.
     * @param fatorMultiplicacao Fator de multiplicação.
     */
    public void setFatorMultiplicacao(float fatorMultiplicacao) {
        this.fatorMultiplicacao = fatorMultiplicacao;
    }
}
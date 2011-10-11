package beans;

import java.io.Serializable;
import java.sql.Time;

public class Periodo implements Serializable {

    private int codigoPeriodo;
    private Time inicioPeriodo;
    private Time fimPeriodo;
    private float fatorMultiplicacao;

    public Periodo() {
    }

    /**@return O código do período.*/
    public int getCodigoPeriodo() {
        return codigoPeriodo;
    }
    
    public void setCodigoPeriodo(int codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    /**@return A hora de início do período. O formato da hora é "hh:mm:ss".*/
    public Time getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Time inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    /**@return A hora de fim do período. O formato da hora é "hh:mm:ss".*/
    public Time getFimPeriodo() {
        return fimPeriodo;
    }

    public void setFimPeriodo(Time fimPeriodo) {
        this.fimPeriodo = fimPeriodo;
    }

    /**@return O fator de multiplicação do período. O fator de multiplicação
     * sempre será maior que zero.*/
    public float getFatorMultiplicacao() {
        return fatorMultiplicacao;
    }

    public void setFatorMultiplicacao(float fatorMultiplicacao) {
        this.fatorMultiplicacao = fatorMultiplicacao;
    }
}
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

    public int getCodigoPeriodo() {
        return codigoPeriodo;
    }
    
    public void setCodigoPeriodo(int codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public Time getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Time inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Time getFimPeriodo() {
        return fimPeriodo;
    }

    public void setFimPeriodo(Time fimPeriodo) {
        this.fimPeriodo = fimPeriodo;
    }

    public float getFatorMultiplicacao() {
        return fatorMultiplicacao;
    }

    public void setFatorMultiplicacao(float fatorMultiplicacao) {
        this.fatorMultiplicacao = fatorMultiplicacao;
    }
}
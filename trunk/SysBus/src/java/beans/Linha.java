package beans;

import java.io.Serializable;
import java.sql.Time;

public class Linha implements Serializable {

    private int codigoLinha;
    private String nomeLinha;
    private Time horaInicioLinha;
    private int demandaLinha;

    public Linha() {
    }

    public int getCodigoLinha() {
        return codigoLinha;
    }

    public void setCodigoLinha(int codigoLinha) {
        this.codigoLinha = codigoLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public Time getHoraInicioLinha() {
        return horaInicioLinha;
    }

    public void setHoraInicioLinha(Time horaInicioLinha) {
        this.horaInicioLinha = horaInicioLinha;
    }

    public int getDemandaLinha() {
        return demandaLinha;
    }

    public void setDemandaLinha(int demandaLinha) {
        this.demandaLinha = demandaLinha;
    }
}
package beans;

import java.io.Serializable;
import java.sql.Date;

public class Linha implements Serializable {

    private int codigoLinha;
    private String nomeLinha;
    private Date horaInicioLinha;
    private int demandaLinha;

    public Linha() {
    }

    public int getCodigoLinha() {
        return codigoLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public Date getHoraInicioLinha() {
        return horaInicioLinha;
    }

    public void setHoraInicioLinha(Date horaInicioLinha) {
        this.horaInicioLinha = horaInicioLinha;
    }

    public int getDemandaLinha() {
        return demandaLinha;
    }

    public void setDemandaLinha(int demandaLinha) {
        this.demandaLinha = demandaLinha;
    }
}
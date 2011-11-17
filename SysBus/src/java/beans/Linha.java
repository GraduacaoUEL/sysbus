package beans;

import java.io.Serializable;
import java.sql.Time;

public class Linha implements Serializable {

    private int codigoLinha;
    private String nomeLinha;
    private Time horaInicioLinha;
    private int demandaLinha;

    /**
     * Construtor vazio.
     */
    public Linha() {
    }

    /**
     * Retorna o código da linha.
     * @return Código da linha.
     */
    public int getCodigoLinha() {
        return codigoLinha;
    }

    /**
     * Atribui o código da linha.
     * @param codigoLinha Código da linha.
     */
    public void setCodigoLinha(int codigoLinha) {
        this.codigoLinha = codigoLinha;
    }

    /**
     * Retorna o nome da linha.
     * @return Nome da linha.
     */
    public String getNomeLinha() {
        return nomeLinha;
    }

    /**
     * Atribui o nome da linha.
     * @param nomeLinha Nome da linha.
     */
    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    /**
     * Retorna a hora de início da linha no formato "hh:mm:ss".
     * @return Hora de início da linha.
     */
    public Time getHoraInicioLinha() {
        return horaInicioLinha;
    }

    /**
     * Atribui a hora de início da linha no formato "hh:mm:ss".
     * @param horaInicioLinha Hora de início da linha.
     */
    public void setHoraInicioLinha(Time horaInicioLinha) {
        this.horaInicioLinha = horaInicioLinha;
    }

    /**
     * Retorna o código da demanda à qual a linha está vinculada.
     * @return Código da demanda à qual a linha está vinculada.
     */
    public int getDemandaLinha() {
        return demandaLinha;
    }

    /**
     * Atribui o código da demanda à qual a linha está vinculada.
     * @param demandaLinha Código da demanda à qual a linha está vinculada.
     */
    public void setDemandaLinha(int demandaLinha) {
        this.demandaLinha = demandaLinha;
    }
}
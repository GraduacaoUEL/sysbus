package beans;

import java.io.Serializable;

public class Colaborador implements Serializable {

    private int codigoColaborador;
    private String nomeColaborador;
    private String loginColaborador;
    private String senhaColaborador;
    private int cargoColaborador;

    public Colaborador() {
    }

    public int getCodigoColaborador() {
        return codigoColaborador;
    }
    
    public void setCodigoColaborador(int codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getLoginColaborador() {
        return loginColaborador;
    }

    public void setLoginColaborador(String loginColaborador) {
        this.loginColaborador = loginColaborador;
    }

    public String getSenhaColaborador() {
        return senhaColaborador;
    }

    public void setSenhaColaborador(String senhaColaborador) {
        this.senhaColaborador = senhaColaborador;
    }

    public int getCargoColaborador() {
        return cargoColaborador;
    }

    public void setCargoColaborador(int cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }
}
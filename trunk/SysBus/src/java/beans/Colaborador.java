package beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senhaColaborador.getBytes(), 0, senhaColaborador.length());
            
            this.senhaColaborador = new BigInteger(1,md.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Colaborador.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public int getCargoColaborador() {
        return cargoColaborador;
    }

    public void setCargoColaborador(int cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }
}
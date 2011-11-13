package beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Colaborador implements Serializable {

    private int codigoColaborador;
    private String nomeColaborador;
    private String loginColaborador;
    private String senhaColaborador;
    private int cargoColaborador;
    
    /**
     * Construtor vazio.
     */
    public Colaborador() {
    }
    
    /**
     * Retorna o código do colaborador.
     * @return Código do colaborador.
     */
    public int getCodigoColaborador() {
        return codigoColaborador;
    }
    
    /**
     * Atribui o código do colaborador.
     * @param codigoColaborador Código do colaborador.
     */
    public void setCodigoColaborador(int codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }

    /**
     * Retorna o nome do colaborador.
     * @return Nome do colaborador.
     */
    public String getNomeColaborador() {
        return nomeColaborador;
    }
    
    /**
     * Atribui o nome do colaborador.
     * @param nomeColaborador Nome do colaborador.
     */
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }
    
    /**
     * Retorna o login do colaborador.
     * @return Login do colaborador.
     */
    public String getLoginColaborador() {
        return loginColaborador;
    }
    
    /**
     * Atribui o login do colaborador.
     * @param loginColaborador Login do colaborador.
     */
    public void setLoginColaborador(String loginColaborador) {
        this.loginColaborador = loginColaborador;
    }

    /**
     * Retorna a senha do colaborador no formato MD5.
     * @return Senha do colaborador.
     */
    public String getSenhaColaborador() {
        return senhaColaborador;
    }

    /**
     * Atribui a senha do colaborador, que é convertida para MD5.
     * @param senhaColaborador Senha do colaborador.
     */
    public void setSenhaColaborador(String senhaColaborador) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senhaColaborador.getBytes());
            this.senhaColaborador = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }        
        this.senhaColaborador = senhaColaborador;
    }

    /**
     * Retorna o código do cargo do colaborador.
     * @return Código do cargo do colaborador.
     */
    public int getCargoColaborador() {
        return cargoColaborador;
    }
    
    /**
     * Atribui o código do cargo do colaborador.
     * @param cargoColaborador Código do cargo do colaborador.
     */
    public void setCargoColaborador(int cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }
}
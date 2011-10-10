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

    public Colaborador() {
    }

    /**@return O código do colaborador.*/
    public int getCodigoColaborador() {
        return codigoColaborador;
    }
    
    public void setCodigoColaborador(int codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }

    /**@return O nome do colaborador.*/
    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    /**@return O login do colaborador.*/
    public String getLoginColaborador() {
        return loginColaborador;
    }

    public void setLoginColaborador(String loginColaborador) {
        this.loginColaborador = loginColaborador;
    }

    /**@return A senha do colaborador. A senha é um hash MD5 gerado a partir
      da senha.*/
    public String getSenhaColaborador() {
        return senhaColaborador;
    }

    /**
     * Atribui uma senha ao colaborador. Antes de ser armazenada no banco, 
     * a senha passa por um hash MD5
     *
     * @param senhaColaborador Senha que será armazenada no banco.
     *            A senha não poderá ser <code>null</code>.
     */
    public void setSenhaColaborador(String senhaColaborador) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senhaColaborador.getBytes());
            
            this.senhaColaborador = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }        
    }

    /** @return O código do cargo ao qual o colaborador está associado.*/
    public int getCargoColaborador() {
        return cargoColaborador;
    }

    public void setCargoColaborador(int cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }
}
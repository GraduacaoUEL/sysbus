package beans;

import java.io.Serializable;

public class Cargo implements Serializable {
    private int codigoCargo;
    private String nomeCargo;
    private boolean permissaoCargos;
    private boolean permissaoCarros;
    private boolean permissaoItinerarios;
    private boolean permissaoVendas;
    private boolean permissaoCustos;
    
    public Cargo() {
        
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public boolean isPermissaoCargos() {
        return permissaoCargos;
    }

    public void setPermissaoCargos(boolean permissaoCargos) {
        this.permissaoCargos = permissaoCargos;
    }

    public boolean isPermissaoCarros() {
        return permissaoCarros;
    }

    public void setPermissaoCarros(boolean permissaoCarros) {
        this.permissaoCarros = permissaoCarros;
    }

    public boolean isPermissaoItinerarios() {
        return permissaoItinerarios;
    }

    public void setPermissaoItinerarios(boolean permissaoItinerarios) {
        this.permissaoItinerarios = permissaoItinerarios;
    }

    public boolean isPermissaoVendas() {
        return permissaoVendas;
    }

    public void setPermissaoVendas(boolean permissaoVendas) {
        this.permissaoVendas = permissaoVendas;
    }

    public boolean isPermissaoCustos() {
        return permissaoCustos;
    }

    public void setPermissaoCustos(boolean permissaoCustos) {
        this.permissaoCustos = permissaoCustos;
    }
}
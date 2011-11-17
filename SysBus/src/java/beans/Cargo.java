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

    /**
     * Construtor vazio.
     */
    public Cargo() {
    }

    /**
     * Retorna o código do cargo.
     * @return Código do cargo.
     */
    public int getCodigoCargo() {
        return codigoCargo;
    }

    /**
     * Atribui o código do cargo.
     * @param codigoCargo Código do cargo.
     */
    public void setCodigoCargo(int codigoCargo) {
        try {
            this.codigoCargo = codigoCargo;
        } catch (NumberFormatException n) {
            this.codigoCargo = 0;
        }
    }

    /**
     * Retorna o nome do cargo.
     * @return Nome do cargo.
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * Atribui o nome do cargo.
     * @param nomeCargo Nome do cargo.
     */
    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    /**
     * Retorna se o cargo tem permissão para gerenciar cargos.
     * @return <code>true</code> se o cargo tem permissão.
     */
    public boolean isPermissaoCargos() {
        return permissaoCargos;
    }

    /**
     * Define se o cargo tem permissão para gerenciar cargos.
     * @param permissaoCargos <code>true</code> se o cargo tem permissão.
     */
    public void setPermissaoCargos(boolean permissaoCargos) {
        this.permissaoCargos = permissaoCargos;
    }

    /**
     * Retorna se o cargo tem permissão para gerenciar carros.
     * @return <code>true</code> se o cargo tem permissão.
     */
    public boolean isPermissaoCarros() {
        return permissaoCarros;
    }

    /**
     * Define se o cargo tem permissão para gerenciar carros.
     * @param permissaoCarros <code>true</code> se o cargo tem permissão.
     */
    public void setPermissaoCarros(boolean permissaoCarros) {
        this.permissaoCarros = permissaoCarros;
    }

    /**
     * Retorna se o cargo tem permissão para gerenciar itinerários.
     * @return <code>true</code> se o cargo tem permissão.
     */
    public boolean isPermissaoItinerarios() {
        return permissaoItinerarios;
    }

    /**
     * Define se o cargo tem permissão para gerenciar itinerários.
     * @param permissaoItinerarios <code>true</code> se o cargo tem permissão.
     */
    public void setPermissaoItinerarios(boolean permissaoItinerarios) {
        this.permissaoItinerarios = permissaoItinerarios;
    }

    /**
     * Retorna se o cargo tem permissão para gerenciar vendas.
     * @return <code>true</code> se o cargo tem permissão.
     */
    public boolean isPermissaoVendas() {
        return permissaoVendas;
    }

    /**
     * Define se o cargo tem permissão para gerenciar vendas.
     * @param permissaoVendas <code>true</code> se o cargo tem permissão.
     */
    public void setPermissaoVendas(boolean permissaoVendas) {
        this.permissaoVendas = permissaoVendas;
    }

    /**
     * Retorna se o cargo tem permissão para gerenciar custos.
     * @return <code>true</code> se o cargo tem permissão.
     */
    public boolean isPermissaoCustos() {
        return permissaoCustos;
    }

    /**
     * Define se o cargo tem permissão para gerenciar custos.
     * @param permissaoCustos <code>true</code> se o cargo tem permissão.
     */
    public void setPermissaoCustos(boolean permissaoCustos) {
        this.permissaoCustos = permissaoCustos;
    }
}
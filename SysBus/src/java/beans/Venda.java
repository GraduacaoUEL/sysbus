package beans;

import java.io.Serializable;
import java.sql.Date;

public class Venda implements Serializable {

    private int codigoVenda;
    private Date dataVenda;
    private String tipoPagamento;
    private float valorVenda;
    private boolean passagemEntregue;
    private boolean viaWeb;
    private int vendedor;
    private int carroVenda;

    public Venda() {
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }
    
    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public boolean isPassagemEntregue() {
        return passagemEntregue;
    }

    public void setPassagemEntregue(boolean passagemEntregue) {
        this.passagemEntregue = passagemEntregue;
    }

    public boolean isViaWeb() {
        return viaWeb;
    }

    public void setViaWeb(boolean viaWeb) {
        this.viaWeb = viaWeb;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getCarroVenda() {
        return carroVenda;
    }

    public void setCarroVenda(int carroVenda) {
        this.carroVenda = carroVenda;
    }
}
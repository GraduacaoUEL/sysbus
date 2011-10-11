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
    
    /**
     * Construtor vazio.
     */
    public Venda() {
    }
    
    /**
     * Retorna o código da venda.
     * @return Código da venda.
     */
    public int getCodigoVenda() {
        return codigoVenda;
    }
    
    /**
     * Atribui o código da venda.
     * @param codigoVenda Código da venda.
     */
    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
    
    /**
     * Retorna a data da venda.
     * @return Data da venda.
     */
    public Date getDataVenda() {
        return dataVenda;
    }
    
    /**
     * Atribui a data da venda.
     * @param dataVenda Data da venda.
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    /**
     * Retorna o tipo de pagamento.
     * @return Tipo de pagamento.
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    
    /**
     * Atribui o tipo de pagamento.
     * @param tipoPagamento Tipo de pagamento.
     */
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    /**
     * Retorna o valor da venda.
     * @return Valor da venda.
     */
    public float getValorVenda() {
        return valorVenda;
    }
    
    /**
     * Atribui o valor da venda.
     * @param valorVenda Valor da venda.
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    /**
     * Retorna se a passagem foi entregue.
     * @return <code>true</code> se a passagem foi entregue.
     */
    public boolean isPassagemEntregue() {
        return passagemEntregue;
    }
    
    /**
     * Define se a passagem foi entregue.
     * @param passagemEntregue <code>true</code> se a passagem foi entregue.
     */
    public void setPassagemEntregue(boolean passagemEntregue) {
        this.passagemEntregue = passagemEntregue;
    }

    /**
     * Retorna se a venda foi efetuada via web.
     * @return <code>true</code> se a venda foi efetuada via web.
     */
    public boolean isViaWeb() {
        return viaWeb;
    }
    
    /**
     * Define se a venda foi efetuada via web.
     * @param viaWeb <code>true</code> se a venda foi efetuada via web.
     */
    public void setViaWeb(boolean viaWeb) {
        this.viaWeb = viaWeb;
    }

    /**
     * Retorna o código do vendedor responsável pela venda.
     * @return Código do vendedor responsável pela venda.
     */
    public int getVendedor() {
        return vendedor;
    }
    
    /**
     * Atribui o código do vendedor responsável pela venda.
     * @param vendedor Código do vendedor responsável pela venda.
     */
    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }
    
    /**
     * Retorna o código do carro que será usado na viagem.
     * @return Código do carro que será usado na viagem.
     */
    public int getCarroVenda() {
        return carroVenda;
    }
    
    /**
     * Atribui o código do carro que será usado na viagem.
     * @param carroVenda Código do carro que será usado na viagem.
     */
    public void setCarroVenda(int carroVenda) {
        this.carroVenda = carroVenda;
    }
}
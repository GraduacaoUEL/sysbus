package beans;

import java.io.Serializable;

public class Custo implements Serializable {

    private int codigoCusto;
    private float precoQuilometro;

    /**
     * Construtor vazio.
     */
    public Custo() {
    }

    /**
     * Retorna o código do custo.
     * @return Código do custo.
     */
    public int getCodigoCusto() {
        return codigoCusto;
    }

    /**
     * Atribui o código do custo.
     * @param codigoCusto Código do custo.
     */
    public void setCodigoCusto(int codigoCusto) {
        this.codigoCusto = codigoCusto;
    }

    /**
     * Retorna o preço do quilômetro.
     * @return Preço do quilômetro.
     */
    public float getPrecoQuilometro() {
        return precoQuilometro;
    }

    /**
     * Atribui o preço do quilômetro.
     * @param precoQuilometro Preço do quilômetro.
     */
    public void setPrecoQuilometro(float precoQuilometro) {
        this.precoQuilometro = precoQuilometro;
    }
}
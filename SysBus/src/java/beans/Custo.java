package beans;

import java.io.Serializable;

public class Custo implements Serializable {

    private int codigoCusto;
    private float precoQuilometro;

    public Custo() {
    }

    /**@return O código do custo.*/
    public int getCodigoCusto() {
        return codigoCusto;
    }
    
    public void setCodigoCusto(int codigoCusto) {
        this.codigoCusto = codigoCusto;
    }

    /**@return O custo do km.*/
    public float getPrecoQuilometro() {
        return precoQuilometro;
    }

    public void setPrecoQuilometro(float precoQuilometro) {
        this.precoQuilometro = precoQuilometro;
    }
}
package beans;

import java.io.Serializable;

public class Custo implements Serializable {

    private int codigoCusto;
    private float precoQuilometro;

    public Custo() {
    }

    public int getCodigoCusto() {
        return codigoCusto;
    }

    public float getPrecoQuilometro() {
        return precoQuilometro;
    }

    public void setPrecoQuilometro(float precoQuilometro) {
        this.precoQuilometro = precoQuilometro;
    }
}
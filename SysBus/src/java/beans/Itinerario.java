package beans;

import java.io.Serializable;

public class Itinerario implements Serializable {

    private int codigoItinerario;
    private String nomeItinerario;

    public Itinerario() {
    }

    /**@return O código do itinerário.*/
    public int getCodigoItinerario() {
        return codigoItinerario;
    }
    
    public void setCodigoItinerario(int codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    /**@return O nome do itinerário.*/
    public String getNomeItinerario() {
        return nomeItinerario;
    }

    public void setNomeItinerario(String nomeItinerario) {
        this.nomeItinerario = nomeItinerario;
    }
}
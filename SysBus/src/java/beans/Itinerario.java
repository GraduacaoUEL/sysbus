package beans;

import java.io.Serializable;

public class Itinerario implements Serializable {

    private int codigoItinerario;
    private String nomeItinerario;

    public Itinerario() {
    }

    public int getCodigoItinerario() {
        return codigoItinerario;
    }
    
    public void setCodigoItinerario(int codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    public String getNomeItinerario() {
        return nomeItinerario;
    }

    public void setNomeItinerario(String nomeItinerario) {
        this.nomeItinerario = nomeItinerario;
    }
}
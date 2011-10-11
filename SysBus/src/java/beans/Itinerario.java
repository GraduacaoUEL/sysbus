package beans;

import java.io.Serializable;

public class Itinerario implements Serializable {

    private int codigoItinerario;
    private String nomeItinerario;
    
    /**
     * Construtor vazio.
     */
    public Itinerario() {
    }

    /**
     * Retorna o código do itinerário.
     * @return Código do itinerário.
     */
    public int getCodigoItinerario() {
        return codigoItinerario;
    }
    
    /**
     * Atribui o código do itinerário.
     * @param codigoItinerario Código do itinerário.
     */
    public void setCodigoItinerario(int codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    /**
     * Retorna o nome do itinerário.
     * @return Nome do itinerário.
     */
    public String getNomeItinerario() {
        return nomeItinerario;
    }
    
    /**
     * Atribui o nome do itinerário.
     * @param nomeItinerario Nome do itinerário.
     */
    public void setNomeItinerario(String nomeItinerario) {
        this.nomeItinerario = nomeItinerario;
    }
}
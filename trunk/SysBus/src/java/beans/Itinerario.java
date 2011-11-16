package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Itinerario implements Serializable {

    private int codigoItinerario;
    private String nomeItinerario;
    private ArrayList<Trecho> trechosItinerario
            = new ArrayList<Trecho>();
    
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

    /**
     * @return the trechosItinerario
     */
    public ArrayList<Trecho> getTrechosItinerario() {
        return trechosItinerario;
    }

    /**
     * @param trechosItinerario the trechosItinerario to set
     */
    public void setTrechosItinerario(ArrayList<Trecho> trechosItinerario) {
        this.trechosItinerario = trechosItinerario;
    }
}
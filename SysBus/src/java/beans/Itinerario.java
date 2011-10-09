package beans;

public class Itinerario {
    
    private int codigoItinerario;
    private String nomeItinerario;
    
    public Itinerario() {
    }

    public int getCodigoItinerario() {
        return codigoItinerario;
    }

    public String getNomeItinerario() {
        return nomeItinerario;
    }

    public void setNomeItinerario(String nomeItinerario) {
        this.nomeItinerario = nomeItinerario;
    }
}
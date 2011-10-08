package beans;

import java.io.Serializable;

public class Carro implements Serializable{
    private int id;
    private int numeroDePassageiros;
    
    public Carro(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }

    public void setNumeroDePassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }
    
}
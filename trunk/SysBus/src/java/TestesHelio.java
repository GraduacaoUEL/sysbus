import DAO.CarroDAO;
import beans.Carro;


public class TestesHelio {
    public static void main(String[] args){

        CarroDAO carro = new CarroDAO();
        
        Carro busao = new Carro();
                
        busao.setCodigoCarro(1);
        busao.setNumeroDePassageiros(50);
        busao.setLinhaCarro(1);
        
        carro.add(busao);

    }
}

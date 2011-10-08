import DAO.CarroDAO;
import beans.Carro;


public class TestesHelio {
    public static void main(String[] args){

        CarroDAO carro = new CarroDAO();
        
        Carro busao = new Carro();
                
        busao.setId(1);
        busao.setNumeroDePassageiros(50);
        
        carro.add(busao);

    }
}

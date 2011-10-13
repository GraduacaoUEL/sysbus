
import DAO.*;
import beans.*;

public class Testador {

    public static void main(String[] args) {
        CargoDAO cargoDAO = new CargoDAO();
        Cargo vendedor = new Cargo();

        vendedor.setNomeCargo("Vendedor");
        vendedor.setPermissaoCargos(false);
        vendedor.setPermissaoCarros(false);
        vendedor.setPermissaoCustos(false);
        vendedor.setPermissaoItinerarios(false);
        vendedor.setPermissaoVendas(true);

        cargoDAO.insert(vendedor);
    }
}

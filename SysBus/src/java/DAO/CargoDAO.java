package DAO;

import beans.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CargoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    /**
     * Construtor vazio.
     */
    public CargoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    /**
     * Insere um cargo no banco de dados.
     * @param cargo Cargo a ser inserido.
     */
    private void insert(Cargo cargo) {
        try {
            String queryString = "INSERT INTO cargo(nome_cargo,"
                    + " permissao_cargos, permissao_carros,"
                    + " permissao_itinerarios, permissao_vendas,"
                    + " permissao_custos) VALUES(?, ?, ?, ?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, cargo.getNomeCargo());
            pstmt.setBoolean(2, cargo.isPermissaoCargos());
            pstmt.setBoolean(3, cargo.isPermissaoCarros());
            pstmt.setBoolean(4, cargo.isPermissaoItinerarios());
            pstmt.setBoolean(5, cargo.isPermissaoVendas());
            pstmt.setBoolean(6, cargo.isPermissaoCustos());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Insere ou atualiza cargo no banco de dados.
     * @param cargo Cargo a ser inserido ou atualizado.
     */
    public void save(Cargo cargo) {
        if (cargo.getCodigoCargo() == 0) {
            insert(cargo);
        } else {
            ResultSet resultSet = null;
            
            try {
                String queryString = "SELECT COUNT(codigo_cargo) FROM cargo"
                        + " WHERE codigo_cargo = ?";

                connection = getConnection();
                pstmt = connection.prepareStatement(queryString);
                pstmt.setInt(1, cargo.getCodigoCargo());

                resultSet = pstmt.executeQuery();
                resultSet.next();
                
                if (resultSet.getInt("count") != 0) {
                    update(cargo);
                } else {
                    insert(cargo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Remove um cargo do banco de dados.
     * @param codigoCargo Código do cargo a ser removido.
     */
    public void delete(int codigoCargo) {
        try {
            String queryString = "DELETE FROM cargo WHERE codigo_cargo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoCargo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Atualiza um cargo no banco de dados.
     * @param cargo Cargo a ser atualizado.
     */
    private void update(Cargo cargo) {
        try {
            String queryString = "UPDATE cargo SET nome_cargo = ?,"
                    + " permissao_cargos = ?, permissao_carros = ?,"
                    + " permissao_itinerarios = ?, permissao_vendas = ?,"
                    + " permissao_custos = ? WHERE codigo_cargo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, cargo.getNomeCargo());
            pstmt.setBoolean(2, cargo.isPermissaoCargos());
            pstmt.setBoolean(3, cargo.isPermissaoCarros());
            pstmt.setBoolean(4, cargo.isPermissaoItinerarios());
            pstmt.setBoolean(5, cargo.isPermissaoVendas());
            pstmt.setBoolean(6, cargo.isPermissaoCustos());
            pstmt.setInt(7, cargo.getCodigoCargo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Cargo> selectAll() {
        ResultSet resultSet = null;
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();

        try {
            String queryString = "SELECT * FROM cargo ORDER BY nome_cargo";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Cargo cargo = new Cargo();

                cargo.setCodigoCargo(resultSet.getInt("codigo_cargo"));
                cargo.setNomeCargo(resultSet.getString("nome_cargo"));
                cargo.setPermissaoCargos(resultSet.getBoolean("permissao_cargos"));
                cargo.setPermissaoCarros(resultSet.getBoolean("permissao_carros"));
                cargo.setPermissaoCustos(resultSet.getBoolean("permissao_custos"));
                cargo.setPermissaoItinerarios(resultSet.getBoolean("permissao_itinerarios"));
                cargo.setPermissaoVendas(resultSet.getBoolean("permissao_vendas"));
                
                cargos.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cargos;
    }

    public Cargo selectForId(int codigoCargo) {
        ResultSet resultSet = null;
        Cargo cargo = new Cargo();

        try {
            String queryString = "SELECT * FROM cargo WHERE codigo_cargo = ?";

            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoCargo);

            resultSet = pstmt.executeQuery();
            resultSet.next();

            cargo.setCodigoCargo(resultSet.getInt("codigo_cargo"));
            cargo.setNomeCargo(resultSet.getString("nome_cargo"));
            cargo.setPermissaoCargos(resultSet.getBoolean("permissao_cargos"));
            cargo.setPermissaoCarros(resultSet.getBoolean("permissao_carros"));
            cargo.setPermissaoCustos(resultSet.getBoolean("permissao_custos"));
            cargo.setPermissaoItinerarios(resultSet.getBoolean("permissao_itinerarios"));
            cargo.setPermissaoVendas(resultSet.getBoolean("permissao_vendas"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cargo;
    }
}
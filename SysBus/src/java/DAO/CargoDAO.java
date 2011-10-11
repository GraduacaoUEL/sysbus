package DAO;

import beans.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CargoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    public CargoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void insert(Cargo cargo) {
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

    public void update(Cargo cargo) {
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
}
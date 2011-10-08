package DAO;

import beans.Demanda;
import beans.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemandaDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    public DemandaDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Demanda demanda) {
        try {
            String queryString = "INSERT INTO demanda(nome_demanda) VALUES (?)";

            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, demanda.getNomeDemanda());
            
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

    public void delete(int codigo_demanda) {
        try {
            String queryString = "DELETE FROM demanda WHERE codigo_demanda = ?";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigo_demanda);
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

    public void update(Demanda demanda) {

        try {
            String queryString = "UPDATE demanda SET nome_demanda = ?,"
                    + " WHERE codigo_demanda = ?";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, demanda.getNomeDemanda());
            pstmt.setInt(2, demanda.getCodigoDemanda());
            
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
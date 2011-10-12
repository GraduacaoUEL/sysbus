package DAO;

import beans.Demanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemandaDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    
    /**
     * Construtor vazio.
     */
    public DemandaDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    /**
     * Insere uma demanda no banco de dados.
     * @param demanda Demanda a ser inserida.
     */
    public void insert(Demanda demanda) {
        try {
            String queryString = "INSERT INTO demanda(nome_demanda) VALUES(?)";
            
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
    
    /**
     * Remove uma demanda do banco de dados.
     * @param codigoDemanda Código da demanda a ser removida.
     */
    public void delete(int codigoDemanda) {
        try {
            String queryString = "DELETE FROM demanda WHERE codigo_demanda = ?";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoDemanda);
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
     * Atualiza uma demanda no banco de dados.
     * @param demanda Demanda a ser atualizada.
     */
    public void update(Demanda demanda) {
        try {
            String queryString = "UPDATE demanda SET nome_demanda = ? WHERE"
                    + " codigo_demanda = ?";
            
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
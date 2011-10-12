package DAO;

import beans.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PeriodoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    
    /**
     * Construtor vazio.
     */
    public PeriodoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    /**
     * Insere um período no banco de dados.
     * @param periodo Período a ser inserido.
     */
    public void insert(Periodo periodo) {
        try {
            String queryString = "INSERT INTO periodo(inicio_periodo,"
                    + " fim_periodo, fator_multiplicacao) VALUES(?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setTime(1, periodo.getInicioPeriodo());
            pstmt.setTime(2, periodo.getFimPeriodo());
            pstmt.setFloat(3, periodo.getFatorMultiplicacao());
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
     * Remove um período do banco de dados.
     * @param codigoPeriodo Código do período a ser removido.
     */
    public void delete(int codigoPeriodo) {
        try {
            String queryString = "DELETE FROM periodo WHERE codigo_periodo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoPeriodo);
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
     * Atualiza um período no banco de dados.
     * @param periodo Período a ser atualizado.
     */
    public void update(Periodo periodo) {
        try {
            String queryString = "UPDATE periodo SET inicio_periodo = ?,"
                    + " fim_periodo = ?, fator_multiplicacao = ? WHERE"
                    + " codigo_periodo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setTime(1, periodo.getInicioPeriodo());
            pstmt.setTime(2, periodo.getFimPeriodo());
            pstmt.setFloat(3, periodo.getFatorMultiplicacao());
            pstmt.setInt(4, periodo.getCodigoPeriodo());
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
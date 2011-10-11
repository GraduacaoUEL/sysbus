package DAO;

import beans.Trecho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrechoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    public TrechoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void insert(Trecho trecho) {
        try {
            String queryString = "INSERT INTO trecho(origem_trecho,"
                    + " destino_trecho, tempo_trecho, distancia_trecho"
                    + " custo_trecho) VALUES(?, ?, ?, ?, ?)";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, trecho.getOrigemTrecho());
            pstmt.setString(2, trecho.getDestinoTrecho());
            pstmt.setTime(3, trecho.getTempoTrecho());
            pstmt.setFloat(4, trecho.getDistanciaTrecho());
            pstmt.setInt(5, trecho.getCustoTrecho());
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

    public void delete(int codigoTrecho) {
        try {
            String queryString = "DELETE FROM trecho WHERE codigo_trecho = ?";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoTrecho);
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

    public void update(Trecho trecho) {
        try {
            String queryString = "UPDATE trecho SET origem_trecho = ?,"
                    + " destino_trecho = ?, tempo_trecho = ?,"
                    + " distancia_trecho = ?, custo_trecho = ? WHERE"
                    + " codigo_trecho = ?";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, trecho.getOrigemTrecho());
            pstmt.setString(2, trecho.getDestinoTrecho());
            pstmt.setTime(3, trecho.getTempoTrecho());
            pstmt.setFloat(4, trecho.getDistanciaTrecho());
            pstmt.setInt(5, trecho.getCustoTrecho());
            pstmt.setInt(6, trecho.getCodigoTrecho());
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
package DAO;

import beans.Itinerario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItinerarioDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    
    /**
     * Construtor vazio.
     */
    public ItinerarioDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    /**
     * Insere um itinerário no banco de dados.
     * @param itinerario Itinerário a ser inserido.
     */
    public void insert(Itinerario itinerario) {
        try {
            String queryString = "INSERT INTO itinerario(nome_itinerario)"
                    + " VALUES(?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, itinerario.getNomeItinerario());
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
     * Remove um itinerário do banco de dados.
     * @param codigoItinerario Código do itinerário a ser removido.
     */
    public void delete(int codigoItinerario) {
        try {
            String queryString = "DELETE FROM itinerario WHERE"
                    + " codigo_itinerario = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoItinerario);
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
     * Atualiza um itinerário no banco de dados.
     * @param itinerario Itinerário a ser atualizado.
     */
    public void update(Itinerario itinerario) {
        try {
            String queryString = "UPDATE itinerario SET nome_itinerario = ?"
                    + " WHERE codigo_itinerario = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, itinerario.getNomeItinerario());
            pstmt.setInt(2, itinerario.getCodigoItinerario());
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
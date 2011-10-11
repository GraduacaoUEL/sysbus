package DAO;

import beans.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    public CarroDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void insert(Carro carro) {
        try {
            String queryString = "INSERT INTO carro(codigo_carro,"
                    + " numero_passageiros, linha_carro) VALUES(?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, carro.getCodigoCarro());
            pstmt.setInt(2, carro.getNumeroDePassageiros());
            pstmt.setInt(3, carro.getLinhaCarro());
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

    public void delete(int codigoCarro) {
        try {
            String queryString = "DELETE FROM carro WHERE codigo_carro = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoCarro);
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

    public void update(Carro carro) {

        try {
            String queryString = "UPDATE carro SET numero_passageiros = ?,"
                    + " linha_carro = ? WHERE codigo_carro = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, carro.getNumeroDePassageiros());
            pstmt.setInt(2, carro.getLinhaCarro());
            pstmt.setInt(3, carro.getCodigoCarro());
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
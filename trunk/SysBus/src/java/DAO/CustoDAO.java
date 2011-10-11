package DAO;

import beans.Custo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    public CustoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void insert(Custo custo) {
        try {
            String queryString = "INSERT INTO custo(preco_quilometro)"
                    + " VALUES(?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setFloat(1, custo.getPrecoQuilometro());
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

    public void delete(int codigoCusto) {
        try {
            String queryString = "DELETE FROM custo WHERE codigo_custo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoCusto);
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

    public void update(Custo custo) {
        try {
            String queryString = "UPDATE custo SET preco_quilometro = ? WHERE"
                    + " codigo_custo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setFloat(1, custo.getPrecoQuilometro());
            pstmt.setInt(2, custo.getCodigoCusto());
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
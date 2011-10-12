package DAO;

import beans.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ColaboradorDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    
    /**
     * Construtor vazio.
     */
    public ColaboradorDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    /**
     * Insere um colaborador no banco de dados.
     * @param colaborador Colaborador a ser inserido.
     */
    public void insert(Colaborador colaborador) {
        try {
            String queryString = "INSERT INTO colaborador(nome_colaborador,"
                    + " login_colaborador, senha_colaborador,"
                    + " cargo_colaborador) VALUES(?, ?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, colaborador.getNomeColaborador());
            pstmt.setString(2, colaborador.getLoginColaborador());
            pstmt.setString(3, colaborador.getSenhaColaborador());
            pstmt.setInt(4, colaborador.getCargoColaborador());
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
     * Remove um colaborador do banco de dados.
     * @param codigoColaborador Código do colaborador a ser removido.
     */
    public void delete(int codigoColaborador) {
        try {
            String queryString = "DELETE FROM colaborador WHERE"
                    + " codigo_colaborador = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoColaborador);
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
     * Atualiza um colaborador no banco de dados.
     * @param colaborador Colaborador a ser atualizado.
     */
    public void update(Colaborador colaborador) {
        try {
            String queryString = "UPDATE colaborador SET nome_colaborador = ?,"
                    + " login_colaborador = ?, senha_colaborador = ?,"
                    + " cargo_colaborador = ? WHERE codigo_colaborador = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, colaborador.getNomeColaborador());
            pstmt.setString(2, colaborador.getLoginColaborador());
            pstmt.setString(3, colaborador.getSenhaColaborador());
            pstmt.setInt(4, colaborador.getCargoColaborador());
            pstmt.setInt(5, colaborador.getCodigoColaborador());
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
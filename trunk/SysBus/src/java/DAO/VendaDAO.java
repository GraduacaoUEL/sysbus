package DAO;

import beans.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    
    /**
     * Construtor vazio.
     */
    public VendaDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    /**
     * Insere uma venda no banco de dados.
     * @param venda Venda a ser inserida.
     */
    public void insert(Venda venda) {
        try {
            String queryString = "INSERT INTO venda(data_venda, tipo_pagamento,"
                    + " valor_venda, passagem_entregue, via_web, vendedor,"
                    + " carro_venda) VALUES(?, ?, ?, ?, ?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setTimestamp(1, venda.getDataHoraVenda());
            pstmt.setString(2, venda.getTipoPagamento());
            pstmt.setFloat(3, venda.getValorVenda());
            pstmt.setBoolean(4, venda.isPassagemEntregue());
            pstmt.setBoolean(5, venda.isViaWeb());
            pstmt.setInt(6, venda.getVendedor());
            pstmt.setInt(7, venda.getCarroVenda());
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
     * Remove uma venda do banco de dados.
     * @param codigoVenda Código da venda a ser removida.
     */
    public void delete(int codigoVenda) {
        try {
            String queryString = "DELETE FROM venda WHERE codigo_venda = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoVenda);
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
     * Atualiza uma venda no banco de dados.
     * @param venda Venda a ser atualizada.
     */
    public void update(Venda venda) {
        try {
            String queryString = "UPDATE venda SET data_venda = ?,"
                    + " tipo_pagamento = ?, valor_venda = ?,"
                    + " passagem_entregue = ?, via_web = ?, vendedor = ?,"
                    + " carro_venda = ? WHERE codigo_venda = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setTimestamp(1, venda.getDataHoraVenda());
            pstmt.setString(2, venda.getTipoPagamento());
            pstmt.setFloat(3, venda.getValorVenda());
            pstmt.setBoolean(4, venda.isPassagemEntregue());
            pstmt.setBoolean(5, venda.isViaWeb());
            pstmt.setInt(6, venda.getVendedor());
            pstmt.setInt(7, venda.getCarroVenda());
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
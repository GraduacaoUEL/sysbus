package DAO;

import beans.Venda;
import beans.VendaInnerJoinColaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private void insert(Venda venda) {
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
     * Insere ou atualiza venda no banco de dados.
     * @param venda Venda a ser inserida ou atualizada.
     */
    public void save(Venda venda) {
        if (venda.getCodigoVenda() == 0) {
            insert(venda);
        } else {
            ResultSet resultSet = null;
            try {
                String queryString = "SELECT COUNT(codigo_venda) FROM venda"
                        + " WHERE codigo_venda = ?";

                connection = getConnection();
                pstmt = connection.prepareStatement(queryString);
                pstmt.setInt(1, venda.getCodigoVenda());

                resultSet = pstmt.executeQuery();
                resultSet.next();

                // Transparência marota
                if (resultSet.getInt("count") != 0) {
                    update(venda);
                } else {
                    insert(venda);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
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
    private void update(Venda venda) {
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

    public ArrayList<Venda> selectAll() {
        ResultSet resultSet = null;
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        try {
            String queryString = "SELECT * FROM venda ORDER BY data_venda";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                /* Para cada iteração do while é criado uma nova venda, que terá
                seus atributos setados de acordo com os dados que estão vindo do
                banco de dados. O fato de a cada iteração ser feito um novo
                "new" não é problema, visto que o Java faz coleta de lixo
                automaticamente. */
                Venda venda = new Venda();

                venda.setCodigoVenda(resultSet.getInt("codigo_venda"));
                venda.setDataHoraVenda(resultSet.getTimestamp("data_venda"));
                venda.setTipoPagamento(resultSet.getString("tipo_pagamento"));
                venda.setValorVenda(resultSet.getFloat("venda_venda"));
                venda.setPassagemEntregue(resultSet.getBoolean("passagem_entregue"));
                venda.setViaWeb(resultSet.getBoolean("via_web"));
                venda.setVendedor(resultSet.getInt("vendedor"));
                venda.setCarroVenda(resultSet.getInt("carro_venda"));

                /* Adiciona a venda ao ArrayList que será retornado. */
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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

        /* Retorna um ArrayList contendo todas as vendas cadastradas. */
        return vendas;
    }

    public ArrayList<VendaInnerJoinColaborador> selectAllWithJoin() {

        ResultSet resultSet = null;
        ArrayList<VendaInnerJoinColaborador> vendas = new ArrayList<VendaInnerJoinColaborador>();

        try {
            String queryString = "SELECT v.codigo_venda, v.data_venda, "
                    + "v.tipo_pagamento, v.valor_venda, v.passagem_entregue, "
                    + "v.via_web, c.nome_colaborador, v.carro_venda FROM venda "
                    + "AS v INNER JOIN colaborador AS c ON v.vendedor = "
                    + "c.codigo_colaborador ORDER BY v.data_venda";

            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                VendaInnerJoinColaborador venda = new VendaInnerJoinColaborador();

                venda.setCodigoVenda(resultSet.getInt("codigo_venda"));
                venda.setDataHoraVenda(resultSet.getTimestamp("data_venda"));
                venda.setTipoPagamento(resultSet.getString("tipo_pagamento"));
                venda.setValorVenda(resultSet.getFloat("venda_venda"));
                venda.setPassagemEntregue(resultSet.getBoolean("passagem_entregue"));
                venda.setViaWeb(resultSet.getBoolean("via_web"));
                venda.setVendedor(resultSet.getString("nome_colaborador"));
                venda.setCarroVenda(resultSet.getInt("carro_venda"));

                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return vendas;
    }

    public Venda selectForId(int codigoVenda) {
        ResultSet resultSet = null;
        Venda venda = new Venda();

        try {
            String queryString = "SELECT * FROM venda WHERE codigo_venda = ?";

            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoVenda);

            resultSet = pstmt.executeQuery();
            resultSet.next();

            venda.setCodigoVenda(resultSet.getInt("codigo_venda"));
            venda.setDataHoraVenda(resultSet.getTimestamp("data_venda"));
            venda.setTipoPagamento(resultSet.getString("tipo_pagamento"));
            venda.setValorVenda(resultSet.getFloat("venda_venda"));
            venda.setPassagemEntregue(resultSet.getBoolean("passagem_entregue"));
            venda.setViaWeb(resultSet.getBoolean("via_web"));
            venda.setVendedor(resultSet.getInt("vendedor"));
            venda.setCarroVenda(resultSet.getInt("carro_venda"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return venda;
    }
}
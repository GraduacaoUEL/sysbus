package DAO;

import beans.Trecho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrechoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    /**
     * Construtor vazio.
     */
    public TrechoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    /**
     * Insere um trecho no banco de dados.
     * @param trecho Trecho a ser inserido.
     */
    private void insert(Trecho trecho) {
        try {
            String queryString = "INSERT INTO trecho(origem_trecho,"
                    + " destino_trecho, tempo_trecho, distancia_trecho,"
                    + " custo_trecho) VALUES(?, ?, ?, ?, 1)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, trecho.getOrigemTrecho());
            pstmt.setString(2, trecho.getDestinoTrecho());
            pstmt.setTime(3, trecho.getTempoTrecho());
            pstmt.setFloat(4, trecho.getDistanciaTrecho());

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
     * Remove um trecho do banco de dados.
     * @param codigoTrecho Código do trecho a ser removido.
     */
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

    /**
     * Atualiza um trecho no banco de dados.
     * @param trecho Trecho a ser atualizado.
     */
    private void update(Trecho trecho) {
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

    public Trecho selectForId(int codigoTrecho) {
        ResultSet resultSet = null;
        Trecho trecho = new Trecho();

        try {
            String queryString = "SELECT * FROM trecho WHERE codigo_trecho = ?";

            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoTrecho);

            resultSet = pstmt.executeQuery();
            resultSet.next();

            trecho.setCodigoTrecho(resultSet.getInt("codigo_trecho"));
            trecho.setOrigemTrecho(resultSet.getString("origem_trecho"));
            trecho.setDestinoTrecho(resultSet.getString("destino_trecho"));
            trecho.setTempoTrecho(resultSet.getTime("tempo_trecho"));
            trecho.setDistanciaTrecho(resultSet.getFloat("distancia_trecho"));

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
        return trecho;
    }

    public ArrayList<Trecho> selectAll() {
        ResultSet resultSet = null;
        ArrayList<Trecho> trechos = new ArrayList<Trecho>();

        try {
            String queryString = "SELECT * FROM trecho ORDER BY origem_trecho";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Trecho trecho = new Trecho();

                trecho.setCodigoTrecho(resultSet.getInt("codigo_trecho"));
                trecho.setOrigemTrecho(resultSet.getString("origem_trecho"));
                trecho.setDestinoTrecho(resultSet.getString("destino_trecho"));
                trecho.setTempoTrecho(resultSet.getTime("tempo_trecho"));
                trecho.setDistanciaTrecho(resultSet.getFloat("distancia_trecho"));

                trechos.add(trecho);
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

        return trechos;
    }

    public void save(Trecho trecho) {
        if (trecho.getCodigoTrecho() == 0) {
            insert(trecho);
        } else {
            ResultSet resultSet = null;
            try {
                String queryString = "SELECT COUNT(codigo_trecho) FROM trecho"
                        + " WHERE codigo_trecho = ?";

                connection = getConnection();
                pstmt = connection.prepareStatement(queryString);
                pstmt.setInt(1, trecho.getCodigoTrecho());

                resultSet = pstmt.executeQuery();
                resultSet.next();

                // Transparência marota
                if (resultSet.getInt("count") != 0) {
                    update(trecho);
                } else {
                    insert(trecho);
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
}
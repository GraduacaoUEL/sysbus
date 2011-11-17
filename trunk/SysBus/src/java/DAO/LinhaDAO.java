package DAO;

import beans.Linha;
import beans.LinhaIJDemandaIJPercorreIJItinerario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LinhaDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    /**
     * Construtor vazio.
     */
    public LinhaDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    /**
     * Insere uma linha no banco de dados.
     * @param linha Linha a ser inserida.
     */
    public void insert(Linha linha) {
        try {
            String queryString = "INSERT INTO linha(nome_linha,"
                    + " hora_inicio_linha, demanda_linha) VALUES(?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, linha.getNomeLinha());
            pstmt.setTime(2, linha.getHoraInicioLinha());
            pstmt.setInt(3, linha.getDemandaLinha());
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
     * Remove uma linha do banco de dados.
     * @param codigoLinha Código da linha a ser removida.
     */
    public void delete(int codigoLinha) {
        try {
            String queryString = "DELETE FROM linha WHERE codigo_linha = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoLinha);
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
     * Atualiza uma linha no banco de dados.
     * @param linha Linha a ser atualizada.
     */
    public void update(Linha linha) {
        try {
            String queryString = "UPDATE linha SET nome_linha = ?,"
                    + " hora_inicio_linha = ?, demanda_linha = ? WHERE"
                    + " codigo_linha = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, linha.getNomeLinha());
            pstmt.setTime(2, linha.getHoraInicioLinha());
            pstmt.setInt(3, linha.getDemandaLinha());
            pstmt.setInt(4, linha.getCodigoLinha());
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

    public ArrayList<Linha> selectAll() {
        ResultSet resultSet = null;
        ArrayList<Linha> linhas = new ArrayList<Linha>();

        try {
            String queryString = "SELECT * FROM linha";
            
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                Linha linha = new Linha();

                linha.setCodigoLinha(resultSet.getInt("codigo_linha"));
                linha.setNomeLinha(resultSet.getString("nome_linha"));
                linha.setHoraInicioLinha(resultSet.getTime("hora_inicio_linha"));
                linha.setDemandaLinha(resultSet.getInt("demanda_linha"));

                linhas.add(linha);
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
        return linhas;
    }

    public ArrayList<LinhaIJDemandaIJPercorreIJItinerario> selectAllWithJoin() {
        ResultSet resultSet = null;
        ArrayList<LinhaIJDemandaIJPercorreIJItinerario> linhaIJDemandaIJPercorreIJItinerarios = 
                new ArrayList<LinhaIJDemandaIJPercorreIJItinerario>();

        try {
            String queryString = "BEGIN; "
                    + "CREATE OR REPLACE VIEW linha_ij_demanda AS SELECT * FROM linha AS l INNER JOIN demanda AS d ON l.demanda_linha = d.codigo_demanda; "
                    + "COMMIT; "
                    + "CREATE OR REPLACE VIEW ld_ij_percorre AS SELECT * FROM linha_ij_demanda AS ld INNER JOIN percorre AS p ON ld.codigo_linha = p.numero_linha; "
                    + "COMMIT; "
                    + "CREATE OR REPLACE VIEW linha_ij_demanda_ij_percorre_ij_itinerario AS SELECT * FROM ldIJpercorre AS ldp INNER JOIN itinerario AS it ON ldp.codigo_linha = it.codigo_itinerario ORDER BY ldp.nome_linha; "
                    + "COMMIT; "
                    + "SELECT * FROM linha_ij_demanda_ij_percorre_ij_itinerario";

            System.out.println(queryString);
            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);

            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                LinhaIJDemandaIJPercorreIJItinerario ldpi =
                        new LinhaIJDemandaIJPercorreIJItinerario();
                
                ldpi.setCodigoLinha(resultSet.getInt(1));
                ldpi.setNomeLinha(resultSet.getString(2));
                ldpi.setHoraInicioLinha(resultSet.getTime(3));
                ldpi.setDemandaLinha(resultSet.getInt(4));
                ldpi.setCodigoDemanda(resultSet.getInt(5));
                ldpi.setNomeDemanda(resultSet.getString(6));
                ldpi.setNumeroLinha(resultSet.getInt(7));
                ldpi.setNumeroItinerarioPercorrido(resultSet.getInt(8));
                ldpi.setCodigoItinerario(resultSet.getInt(9));
                ldpi.setNomeItinerario(resultSet.getString(10));
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
        return linhaIJDemandaIJPercorreIJItinerarios;
    }
    
}

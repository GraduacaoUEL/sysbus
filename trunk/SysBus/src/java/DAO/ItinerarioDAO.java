package DAO;

import beans.Itinerario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
/*

BEGIN; 
INSERT INTO itinerario(nome_itinerario) VALUES('Teste4');
INSERT INTO possui(numero_itinerario, numero_trecho) VALUES((SELECT codigo_itinerario FROM itinerario WHERE nome_itinerario = 'Teste4'), 2);
*/

    public void insert(Itinerario itinerario) {
        try {
            
            String queryString = "BEGIN; ";
            queryString += "INSERT INTO itinerario(nome_itinerario) VALUES('" + itinerario.getNomeItinerario() + "'); ";
                        
            for(int i = 0; i < itinerario.getTrechosItinerario().size(); i++)
                queryString += "INSERT INTO possui(numero_itinerario, numero_trecho) "
                        + "VALUES((SELECT codigo_itinerario FROM itinerario WHERE "
                        + "nome_itinerario = '" + itinerario.getNomeItinerario() + "'),"
                        + " "+ itinerario.getTrechosItinerario().get(i).getCodigoTrecho() +"); ";
            
            queryString += "COMMIT;";
            
            //Debug para ver como ficou a expressão gerada
            //System.out.println(queryString);
                    
            connection = getConnection();
            
            pstmt = connection.prepareStatement(queryString);
            pstmt.executeUpdate();
            System.out.println(queryString);
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

    /*
     * Retorna todos as tuplas da entidade Cargo
     * @param cargo Cargo a ser atualizado.
     */
    public ArrayList<Itinerario> selectAll() {

        ResultSet resultSet = null;
        ArrayList<Itinerario> itinerarios = new ArrayList<Itinerario>();

        try {
            String queryString = "SELECT * FROM itinerario";
            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {

                Itinerario itinerario = new Itinerario();

                itinerario.setCodigoItinerario(resultSet.getInt("codigo_itinerario"));
                itinerario.setNomeItinerario(resultSet.getString("nome_itinerario"));

                itinerarios.add(itinerario);
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
        return itinerarios;
    }
}
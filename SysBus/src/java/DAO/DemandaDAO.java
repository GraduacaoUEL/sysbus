package DAO;

import beans.Demanda;
import beans.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemandaDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    /**
     * Construtor vazio.
     */
    public DemandaDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    /**
     * Insere uma demanda no banco de dados.
     * @param demanda Demanda a ser inserida.
     */
    public void insert(Demanda demanda) {
        try {

            /*
             * Exemplo de expressão que será gerada
             * 
             * BEGIN; 
             * INSERT INTO demanda(nome_demanda) VALUES('Teste4');
             * INSERT INTO segue(numero_demanda, numero_periodo) VALUES((SELECT codigo_demanda FROM demanda WHERE nome_demanda = 'Teste4'), 1);
             * INSERT INTO segue(numero_demanda, numero_periodo) VALUES((SELECT codigo_demanda FROM demanda WHERE nome_demanda = 'Teste4'), 3); 
             * INSERT INTO segue(numero_demanda, numero_periodo) VALUES((SELECT codigo_demanda FROM demanda WHERE nome_demanda = 'Teste4'), 5); 
             * INSERT INTO segue(numero_demanda, numero_periodo) VALUES((SELECT codigo_demanda FROM demanda WHERE nome_demanda = 'Teste4'), 6); 
             * INSERT INTO segue(numero_demanda, numero_periodo) VALUES((SELECT codigo_demanda FROM demanda WHERE nome_demanda = 'Teste4'), 7); 
             * COMMIT;
             * 
             */
            String queryString = "BEGIN; ";
            queryString += "INSERT INTO demanda(nome_demanda) VALUES('" + demanda.getNomeDemanda() + "'); ";

            for (int i = 0; i < demanda.getPeriodosDemanda().size(); i++) {
                queryString += "INSERT INTO segue(numero_demanda, numero_periodo) "
                        + "VALUES((SELECT codigo_demanda FROM demanda WHERE "
                        + "nome_demanda = '" + demanda.getNomeDemanda() + "'),"
                        + " " + demanda.getPeriodosDemanda().get(i).getCodigoPeriodo() + "); ";
            }

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
     * Remove uma demanda do banco de dados.
     * @param codigoDemanda Código da demanda a ser removida.
     */
    public void delete(int codigoDemanda) {
        try {
            String queryString = "DELETE FROM demanda WHERE codigo_demanda = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoDemanda);
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
     * Atualiza uma demanda no banco de dados.
     * @param demanda Demanda a ser atualizada.
     */
    public void update(Demanda demanda) {
        try {
            String queryString = "UPDATE demanda SET nome_demanda = ? WHERE"
                    + " codigo_demanda = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setString(1, demanda.getNomeDemanda());
            pstmt.setInt(2, demanda.getCodigoDemanda());
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
     * Retorna todos as tupas da entidade Cargo
     * @param cargo Cargo a ser atualizado.
     */
    public ArrayList<Demanda> selectAll() {

        ResultSet resultSet = null;
        ArrayList<Demanda> demandas = new ArrayList<Demanda>();

        try {
            String queryString = "SELECT * FROM demanda";
            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {

                Demanda demanda = new Demanda();

                demanda.setCodigoDemanda(resultSet.getInt("codigo_demanda"));
                demanda.setNomeDemanda(resultSet.getString("nome_demanda"));

                demandas.add(demanda);
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
        return demandas;
    }
}
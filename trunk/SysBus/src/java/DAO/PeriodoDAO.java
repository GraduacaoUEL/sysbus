package DAO;

import beans.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeriodoDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;

    /**
     * Construtor vazio.
     */
    public PeriodoDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    /**
     * Insere um período no banco de dados.
     * @param periodo Período a ser inserido.
     */
    private void insert(Periodo periodo) {
        try {
            String queryString = "INSERT INTO periodo(inicio_periodo,"
                    + " fim_periodo, fator_multiplicacao) VALUES(?, ?, ?)";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setTime(1, periodo.getInicioPeriodo());
            pstmt.setTime(2, periodo.getFimPeriodo());
            pstmt.setFloat(3, periodo.getFatorMultiplicacao());
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
     * Remove um período do banco de dados.
     * @param codigoPeriodo Código do período a ser removido.
     */
    public void delete(int codigoPeriodo) {
        try {
            String queryString = "DELETE FROM periodo WHERE codigo_periodo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoPeriodo);
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
     * Atualiza um período no banco de dados.
     * @param periodo Período a ser atualizado.
     */
    private void update(Periodo periodo) {
        try {
            String queryString = "UPDATE periodo SET inicio_periodo = ?,"
                    + " fim_periodo = ?, fator_multiplicacao = ? WHERE"
                    + " codigo_periodo = ?";

            connection = getConnection();

            pstmt = connection.prepareStatement(queryString);
            pstmt.setTime(1, periodo.getInicioPeriodo());
            pstmt.setTime(2, periodo.getFimPeriodo());
            pstmt.setFloat(3, periodo.getFatorMultiplicacao());
            pstmt.setInt(4, periodo.getCodigoPeriodo());
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

    public ArrayList<Periodo> selectAll() {

        ResultSet resultSet = null;
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();

        try {
            String queryString = "SELECT * FROM periodo";
            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {

                Periodo periodo = new Periodo();

                periodo.setCodigoPeriodo(resultSet.getInt("codigo_periodo"));
                periodo.setInicioPeriodo(resultSet.getTime("inicio_periodo"));
                periodo.setFimPeriodo(resultSet.getTime("fim_periodo"));
                periodo.setFatorMultiplicacao(resultSet.getFloat("fator_multiplicacao"));

                periodos.add(periodo);
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
        return periodos;
    }
    
    public Periodo selectForId(int codigoPeriodo) {

        ResultSet resultSet = null;
        Periodo periodo = new Periodo();

        try {

            String queryString = "SELECT * FROM periodo"
                    + " WHERE codigo_periodo = ?";
            connection = getConnection();
            pstmt = connection.prepareStatement(queryString);
            pstmt.setInt(1, codigoPeriodo);

            resultSet = pstmt.executeQuery();

            resultSet.next();
            
            periodo.setCodigoPeriodo(resultSet.getInt("codigo_periodo"));
            periodo.setInicioPeriodo(resultSet.getTime("inicio_periodo"));
            periodo.setFimPeriodo(resultSet.getTime("fim_periodo"));
            periodo.setFatorMultiplicacao(resultSet.getFloat("fator_multiplicacao"));
            
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
        return periodo;
    }   
    
    public void save(Periodo periodo) {

        if (periodo.getCodigoPeriodo() == 0) {
            insert(periodo);
        } else {
            ResultSet resultSet = null;

            try {

                String queryString = "SELECT COUNT(codigo_periodo) FROM "
                        + "periodo WHERE codigo_periodo = ?";

                connection = getConnection();
                pstmt = connection.prepareStatement(queryString);
                pstmt.setInt(1, periodo.getCodigoPeriodo());

                resultSet = pstmt.executeQuery();
                resultSet.next();
                //Transparencia marota
                if (resultSet.getInt("count") != 0) {
                    update(periodo);
                } else {
                    insert(periodo);
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
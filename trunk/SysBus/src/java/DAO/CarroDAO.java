package DAO;

import beans.Carro;
import beans.CarroInnerJoinLinha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    
    /**
     * Construtor vazio.
     */
    public CarroDAO() {
    }
    
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    /**
     * Insere um carro no banco de dados.
     * @param carro Carro a ser inserido.
     */
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
    
    /**
     * Remove um carro do banco de dados.
     * @param codigoCarro Código do carro a ser removido.
     */
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
    
    /**
     * Atualiza um carro no banco de dados.
     * @param carro Carro a ser atualizado.
     */
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
    
    public ArrayList<Carro> selectAll() {
    
    ResultSet resultSet = null;
    ArrayList<Carro> carros = new ArrayList<Carro>();
    
    try {
                        String queryString = "SELECT * FROM carro";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(queryString);
                        resultSet = pstmt.executeQuery();
                        while (resultSet.next()) {
                            
                            Carro carro = new Carro();
                            
                            carro.setCodigoCarro(resultSet.getInt("codigo_carro"));
                            carro.setNumeroDePassageiros(resultSet.getInt("numero_passageiros"));
                            carro.setLinhaCarro(resultSet.getInt("linha_carro"));
                         
                            carros.add(carro);
                        }
                        
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (resultSet != null)
                                        resultSet.close();
                                if (pstmt != null)
                                        pstmt.close();
                                if (connection != null)
                                        connection.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                }
                return carros;
        }

    public ArrayList<CarroInnerJoinLinha> selectAllWithJoin() {
    
    ResultSet resultSet = null;
    ArrayList<CarroInnerJoinLinha> carros = new ArrayList<CarroInnerJoinLinha>();
    
    try {
                        String queryString = "SELECT c.codigo_carro, "
                                + "c.numero_passageiros, l.nome_linha FROM "
                                + "carro AS c INNER JOIN linha AS l ON "
                                + "c.linha_carro = l.codigo_linha";
                        connection = getConnection();
                        pstmt = connection.prepareStatement(queryString);
                        resultSet = pstmt.executeQuery();
                        while (resultSet.next()) {
                            
                            CarroInnerJoinLinha carro = new CarroInnerJoinLinha();
                            
                            carro.setCodigoCarro(resultSet.getInt("codigo_carro"));
                            carro.setNumeroPassageiros(resultSet.getInt("numero_passageiros"));
                            carro.setNomeLinha(resultSet.getString("nome_linha"));
                            carros.add(carro);
                        }
                        
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (resultSet != null)
                                        resultSet.close();
                                if (pstmt != null)
                                        pstmt.close();
                                if (connection != null)
                                        connection.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                }
                return carros;
        }
    
}
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String driverClassName = "org.postgresql.Driver";
    private String connectionUrl = "jdbc:postgresql://localhost:5432/sysbus";
    private String dbUser = "sysbus";
    private String dbPwd = "bd17";
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna um objeto de conexão.
     * @return Objeto de conexão.
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    /**
     * Retorna uma instância única de <code>ConnectionFactory</code>.
     * @return Instância única de <code>ConnectionFactory</code>.
     */
    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
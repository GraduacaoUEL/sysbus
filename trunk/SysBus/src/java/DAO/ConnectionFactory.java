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

    /**@return Um objeto de conexão.*/
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    /**@return Uma instância única de <code>ConnectionFactory</code>.*/
    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    public static final String URL_CONNECTION_DB = "jdbc:mysql://localhost:3306/productmanagers";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null){
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(URL_CONNECTION_DB,USER,PASSWORD);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
            return connection;
    }
}

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    public static String jdbcURL = "jdbc:mysql://localhost:3306/productmanagers";
    public static String jdbcUser = "root";
    public static String jdbcPassword = "123456";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);

            } catch (ClassNotFoundException e) {
                System.out.println("kh co driver");
            } catch (SQLException throwable) {
                System.out.println("kh connect sql");
            }
            System.out.println("connect thanh cong");
        }
        return connection;
    }
}


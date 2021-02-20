package service;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Khong ket noi duoc");
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/productmanagers",
                    "root",
                    "admin"
            );
        } catch (SQLException throwables) {
            System.out.println("Khong co driver");
        }
        System.out.println("Ket noi thanh cong");
        return connection;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}

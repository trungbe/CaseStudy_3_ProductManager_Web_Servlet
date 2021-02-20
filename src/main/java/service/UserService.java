package service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
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
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                Date birthday = resultSet.getDate("birthday");
                String address = resultSet.getString("address");
                User user = new User(id, username, password, fullname, birthday, address);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}

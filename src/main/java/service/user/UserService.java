package service.user;

import model.User;
import service.SingletonConnection;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {

    public static final String SELECT_USER_SQL = "select * from user";

    private Connection connection = SingletonConnection.getConnection();

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_user = resultSet.getInt("id_user");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                int id_role = resultSet.getInt("id_role");
                User user = new User(id_user, username, password, fullname, birthday, address,id_role);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }






    @Override
    public User create(User user) {
        return null;
    }
    @Override
    public User findById(int id) {
        return null;
    }
    @Override
    public boolean update(User user) {
        return false;
    }
    @Override
    public boolean delete(int id) {
        return false;
    }
    @Override
    public List<User> sort() {
        return null;
    }

}

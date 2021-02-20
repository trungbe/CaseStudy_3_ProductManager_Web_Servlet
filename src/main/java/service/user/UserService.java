package service.user;

import model.User;
import service.SingletonConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
   private Connection connection = SingletonConnection.getConnection();

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_user = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String fullname = resultSet.getString(4);
                Date birthday = resultSet.getDate(5);
                String address = resultSet.getString(6);
                int id_role = resultSet.getInt(7);
                User user = new User(id_user, username, password, fullname, birthday, address,id_role);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}

package service.user;

import model.User;
import service.SingletonConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    public static final String LOGIN_SQL = "select * from user where username=? and password =?;";
    public static final String CREATE_NEW_USER_SQL = "insert into user" + " (username,password,fullname,birthday,address,id_role) values" + "(?,?,?,?,?,?);";
    public static final String CHECK_USER_EXIST_SQL = "select 1 from user where username = ?";
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
        if (duplicateUser(user)) {
            return null;
        } else {
            try {
                PreparedStatement p = connection.prepareStatement(CREATE_NEW_USER_SQL);
                p.setString(1, user.getUsername());
                p.setString(2, user.getPassword());
                p.setString(3, user.getFullname());
                p.setString(4, user.getBirthday());
                p.setString(5, user.getAddress());
                p.setInt(6, user.getId_role());
                p.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return user;
    }

    private boolean duplicateUser(User user) {
        boolean duplicateUser = false;
        try {
            PreparedStatement p = connection.prepareStatement(CHECK_USER_EXIST_SQL);
            p.setString(1, user.getUsername());
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                duplicateUser = true;
            }
            System.out.println(duplicateUser);
        } catch (Exception e) {

        }
        return duplicateUser;
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

    @Override
    public User login(String user, String pass) {
//        Connection connection = null;
        ResultSet resultSet;

        try {
            PreparedStatement p = connection.prepareStatement(LOGIN_SQL);
            p.setString(1, user);
            p.setString(2, pass);
            resultSet = p.executeQuery();
            while (resultSet.next()) {
                User user1 = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
                        , resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
                return user1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

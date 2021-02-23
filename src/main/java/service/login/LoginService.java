package service.login;

import model.User;
import service.SingletonConnection;
import service.login.ILoginService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginService implements ILoginService {
    public static final String LOGIN_SQL = "select * from user where username=? and password =?;";
    public static final String CREATE_NEW_USER_SQL = "insert into user" + " (username,password,fullname,birthday,address,id_role) values" + "(?,?,?,?,?,?);";
    public static final String CHECK_USER_EXIST_SQL = "select 1 from user where username = ?";
    private Connection connection = SingletonConnection.getConnection();

    @Override
    public List<User> findAll() {
      return null;
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
    public User login(String user, String pass) {
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

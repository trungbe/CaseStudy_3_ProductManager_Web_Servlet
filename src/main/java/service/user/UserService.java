package service.user;

import model.User;
import service.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    public static final String LOGIN_SQL = "select * from user where username=? and password =?;";
    public static final String CREATE_NEW_USER_SQL = "insert into user" + " (username,password,fullname,birthday,address) values" + "(?,?,?,?,?);";
    private Connection connection = SingletonConnection.getConnection();

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User user) {
        try {
            PreparedStatement p = connection.prepareStatement(CREATE_NEW_USER_SQL);
            p.setString(1, user.getUsername());
            p.setString(2, user.getPassword());
            p.setString(3, user.getFullname());
            p.setInt(4, user.getBirthday());
            p.setString(5, user.getAddress());
            //p.setInt(6, user.getId_role());
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }



//    public boolean login(User user) {
//
//        try {
//            PreparedStatement p = connection.prepareStatement(LOGIN_SQL);
//            p.setString(1, user.getUsername());
//            p.setString(2, user.getPassword());
//            ResultSet resultSet = p.executeQuery();
//            isLogin = resultSet.next();
//            if (isLogin) {
//                return true;
//            } else return false;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return isLogin;
//
//    }


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
        Connection connection =null;
        ResultSet resultSet;

        try {
            PreparedStatement p = connection.prepareStatement(LOGIN_SQL);
            p.setString(1, user);
            p.setString(2, pass);
            resultSet = p.executeQuery();
            while (resultSet.next()){
                User user1 = new User(resultSet.getString(1),resultSet.getString(2));
            return user1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

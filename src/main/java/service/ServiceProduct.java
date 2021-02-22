package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProduct implements IServiceProduct{
    private static final String SELECT_ALL_PRODUCT="select * from product";
    public static final String CREATE_NEW_PRODUCT = "insert into product(name_product,price,origin,description) values (?,?,?,?)";
    public static final String FIND_PRODUCT_BY_ID= "select  * from product where id=? ";
    public static final String EDIT_PRODUCT = "update product set name_product = ?,price =?,origin=?,description=? where id= ?";
    public static final String DELETE_PRODUCT= "delete from product where id= ?";
    public static final String SEARCH_BY_NAME = "select * from product where name like ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/productmanagers";
    private String jdbcUser = "root";
    private String jdbcPassword = "123456";
    private Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("khong co thu vien");
        } catch (SQLException throwables) {
            System.out.println("khong co ket noi");
        }
        System.out.println("ket noi thanh cong");
        return connection;
    }
    @Override
    public List<Product> findAll() {
        List<Product>products=new ArrayList<>();
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name_product=resultSet.getString("name_product");
                int price=resultSet.getInt("price");
                String origin=resultSet.getString("origin");
                String description=resultSet.getString("description");
                Product product=new Product(id,name_product,price,origin,description);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public Product save(Product product) {
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(CREATE_NEW_PRODUCT);
            preparedStatement.setString(1,product.getName_product());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getOrigin());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean edit(Product product) {
        Connection connection=getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(EDIT_PRODUCT);
            preparedStatement.setInt(5,product.getId());
            preparedStatement.setString(1,product.getName_product());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getOrigin());
            preparedStatement.setString(4,product.getDescription());
            check=preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public Product findById(int id) {
        Product product=null;
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String name= resultSet.getString("name_product");
                int price=resultSet.getInt("price");
                String origin=resultSet.getString("origin");
                String des=resultSet.getString("description");
                product=new Product(id,name,price,origin,des);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean delete(int id) {
        Connection connection=getConnection();
        boolean check=false;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            check=preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}

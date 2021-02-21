package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProduct implements IServiceProduct{
    private static final String SELECT_ALL_PRODUCT="select * from product";
    private Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagers"
            ,"root","123456");
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
    public Product save(int id, Product product) {
        return null;
    }

    @Override
    public Product edit(int id, Product product) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

package service.product;

import model.Product;
import service.SingletonConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    public static final String CREATE_NEW_PRODUCT = "insert into product(name_product,price,origin,description,image) values (?,?,?,?,?)";
    public static final String FIND_PRODUCT_BY_ID = "select  * from product where id=? ";
    public static final String EDIT_PRODUCT = "update product set name_product = ?,price =?,origin=?,description=?,image=? where id= ?";
    public static final String DELETE_PRODUCT = "delete from product where id= ?";
    public static final String SEARCH_BY_NAME = "select * from product where name_product like ?";
    private Connection connection = SingletonConnection.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name_product = resultSet.getString("name_product");
                int price = resultSet.getInt("price");
                String origin = resultSet.getString("origin");
                String description = resultSet.getString("description");
                String image= resultSet.getString("image");
                Product product = new Product(id, name_product, price, origin, description,image);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public Product save(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_PRODUCT);
            preparedStatement.setString(1, product.getName_product());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getOrigin());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5,product.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean edit(Product product) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT);
            preparedStatement.setInt(6, product.getId());
            preparedStatement.setString(1, product.getName_product());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getOrigin());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImage());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name_product");
                int price = resultSet.getInt("price");
                String origin = resultSet.getString("origin");
                String des = resultSet.getString("description");
                String image=resultSet.getString("image");
                product = new Product(id, name, price, origin, des,image);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean delete(int id) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name_product = resultSet.getString("name_product");
                int price = resultSet.getInt("price");
                String origin = resultSet.getString("origin");
                String des = resultSet.getString("description");
                String image=resultSet.getString("image");
                products.add(new Product(name_product, price, origin, des,image));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}

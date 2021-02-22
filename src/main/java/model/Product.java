package model;

public class Product {
    private int id;
    private String name_product;
    private int price;
    private String origin;
    private String description;
    private String image;

    public Product() {

    }

    public Product(String name_product, int price, String origin, String description, String image) {
        this.name_product = name_product;
        this.price = price;
        this.origin = origin;
        this.description = description;
        this.image = image;
    }

    public Product(int id, String name_product, int price, String origin, String description, String image) {
        this.id = id;
        this.name_product = name_product;
        this.price = price;
        this.origin = origin;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

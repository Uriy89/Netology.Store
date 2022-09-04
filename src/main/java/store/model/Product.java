package store.model;

import java.text.DecimalFormat;
import java.util.Objects;

public class Product implements Comparable<Product> {
    private long id;
    private double price;
    private String name;
    private double rating;
    private TypeProduct typeProduct;
    private final int MIN = 1;
    private final int MAX = 100_000;

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public Product(double price, String name, double rating, TypeProduct typeProduct) {
        this.id = (long) (MIN + Math.random() * MAX);
        this.price = price;
        this.name = name;
        this.rating = rating;
        this.typeProduct = typeProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + decimalFormat.format(price) +
                ", name=" + name +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && name == product.name && Double.compare(product.rating, rating) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, rating);
    }

    @Override
    public int compareTo(Product o) {
        return (int) (o.getRating() - this.getRating());
    }
}

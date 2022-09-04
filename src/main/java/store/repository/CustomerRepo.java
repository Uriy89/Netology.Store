package store.repository;

import store.model.Product;

import java.util.List;

public interface CustomerRepo {
    void addProduct(long id);
    void getArea();
    void byProducts();
    void deleteProduct(long id);
    void changeRating(long id, int rating);
}

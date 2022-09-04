package store.repository;

import store.Store;
import store.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerRepoImp implements CustomerRepo {

    private List<Product> products = new ArrayList<>();

    private final int PERCENT100 = 100;

    @Override
    public void addProduct(long id) {
        Product product = getById(id);
        if (product != null) {
            products.add(product);
            System.out.println("Товар " + product.getName() + " добавлен в корзину");
        }
        else System.out.println("Товар с id: " + id + " не найден");
    }

    @Override
    public void getArea() {
        if (products.size() > 0) products.forEach(System.out::println);
        else System.out.println("Корзина пуста");
    }

    @Override
    public void byProducts() {
        products.clear();
        System.out.println("Товары куплены");
    }


    @Override
    public void deleteProduct(long id) {
        Product product = getById(id);
        products.remove(product);
    }

    @Override
    public void changeRating(long id, int rating) {
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product p = productIterator.next();
            if (p.getId() == id) {
                double res = (rating / PERCENT100) + p.getRating();
                p.setRating(res);
            }
        }
    }

    private Product getById(long id) {
        Product product = null;
        for (Product p : Store.getStore()) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }
}

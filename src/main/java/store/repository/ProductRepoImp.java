package store.repository;

import store.Store;
import store.model.Product;

import java.util.Collections;

public class ProductRepoImp implements ProductRepo {
    @Override
    public void getMoreRatedProduct() {
        Collections.sort(Store.getStore());
        getAllListProducts();
    }
    @Override
    public void getAllListProducts() {
        if (Store.getStore().size() > 0) {
            Store.getStore()
                    .forEach(System.out::println);
        } else {
            System.out.println("Товаров в магазине нет");
        }
    }


}

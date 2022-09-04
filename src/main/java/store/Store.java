package store;

import store.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<Product> store;
    private static Store instance;

    private Store() {
        store = new ArrayList<>();
    }

    public static List<Product> getStore() {
        return store;
    }

    public static Store getInstance() {
        if (store == null) {
            instance = new Store();
        }
        return instance;
    }
}

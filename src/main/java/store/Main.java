package store;


import store.model.Product;
import store.model.TypeProduct;
import store.repository.CustomerRepoImp;
import store.repository.ProductRepoImp;
import store.repository.CustomerRepo;
import store.repository.ProductRepo;

import java.util.Scanner;

public class Main {
    private static final CustomerRepo customerRepo = new CustomerRepoImp();
    private static final ProductRepo productRepo = new ProductRepoImp();

    public static void main(String[] args) {
        Store.getInstance();
        addProductInStore();
        System.out.println("Добро пожаловать в магазин!");
        while (true) {
            System.out.println("1.Посмотреть список товаров\n2.положить товар в корзину" +
                    "\n3.Удалить товар из корзины\n4.Показать корзину\n5.Оплатить\n6.Выход");
            Scanner scannerI = new Scanner(System.in);
            int i = scannerI.nextInt();
            if(i == 6) break;
            switch (i) {
                case 1:
                    System.out.println("Отсортировать по рейтингу?(да/нет)");
                    Scanner scannerR = new Scanner(System.in);
                    String response = scannerR.nextLine();
                    if (response.equals("да")) productRepo.getMoreRatedProduct();
                    else productRepo.getAllListProducts();
                    break;
                case 2:
                    System.out.println("Выберите id товара");
                    Scanner scannerID = new Scanner(System.in);
                    long id = scannerID.nextLong();
                    customerRepo.addProduct(id);
                    System.out.println("Хотите оценить товар?(да/нет)");
                    Scanner scannerRat = new Scanner(System.in);
                    String res = scannerRat.nextLine();
                    if (res.equals("да"))  {
                        System.out.println("Введите оценку от 1 до 5?");
                        Scanner s = new Scanner(System.in);
                        int rat = s.nextInt();
                        customerRepo.changeRating(id, rat);
                        System.out.println("Спасибо!");
                    }
                    break;
                case 3:
                    System.out.println("Выберите id товара");
                    Scanner scannerId = new Scanner(System.in);
                    long idDelete = scannerId.nextLong();
                    customerRepo.deleteProduct(idDelete);
                    break;
                case 4:
                    customerRepo.getArea();
                    break;
                case 5:
                    customerRepo.byProducts();
                    break;
            }
        }
    }

    private static void addProductInStore() {

        Store.getStore().add(new Product(12.28, "Чай Lipton", 3.2, TypeProduct.TEA));
        Store.getStore().add(new Product(14.35, "Чай Richard", 4.3, TypeProduct.TEA));
        Store.getStore().add(new Product(21.16, "Кофе Nescafe", 5.0, TypeProduct.COFFEE));
        Store.getStore().add(new Product(10.23, "Хлеб черный", 2.7, TypeProduct.BREAD));
        Store.getStore().add(new Product(32.13, "Кофе Jacobs", 3.7, TypeProduct.COFFEE));
        Store.getStore().add(new Product(9.25, "Хлеб зерновой", 3.9, TypeProduct.BREAD));
        Store.getStore().add(new Product(43.53, "Масло сливочное", 1.2, TypeProduct.BUTTER));
        Store.getStore().add(new Product(40.22, "Масло сливочное", 3.6, TypeProduct.BUTTER));
        Store.getStore().add(new Product(41.38, "Масло сливочное", 3.8, TypeProduct.BUTTER));
        Store.getStore().add(new Product(14.22, "Coca-Cola", 2.9, TypeProduct.DRINK));
        Store.getStore().add(new Product(13.17, "Sprite", 4.7, TypeProduct.DRINK));
        Store.getStore().add(new Product(16.43, "Lays", 4.2, TypeProduct.CHIPS));
        Store.getStore().add(new Product(9.67, "Русская картошка", 2.5, TypeProduct.CHIPS));
        Store.getStore().add(new Product(56.13, "Сыр чеддр", 4.1, TypeProduct.CHEESE));
        Store.getStore().add(new Product(45.11, "Сыр российский", 3.0, TypeProduct.CHEESE));
        Store.getStore().add(new Product(36.65, "Сыр косичка ", 4.0, TypeProduct.CHEESE));
        Store.getStore().add(new Product(20.31, "Пиво Bad", 1.8, TypeProduct.BEER));
        Store.getStore().add(new Product(32.23, "Пиво Tuborg", 1.4, TypeProduct.BEER));
    }
}

<h3>Описание</h3>

>Принцип избегания магических чисел

Применен в классе CustomerRepoImp, для расчета рейтинга
``private final int PERCENT100 = 100;`` - 12 строка

>Принцип DRY

Применил в классе CustomerRepoImp, для поиска объекта в коллекции по id, вынес
код в общий метод `getById()`.


``private Product getById(long id) {
Product product = null;
for (Product p : Store.getStore()) {
if (p.getId() == id) {
product = p;
break;
}
}
return product;
}``

>SOLID

**SRP**
CustomerRepoImp, реализует управление карзиной покупателя.

**OCP**
Применяется в POJO классах.

**LSP**
Создана общая модель Person, от которой наследутся Customer.
Так же можно реализовать администратора магазина или другого работника.


**ISP**
Реализованы два интерфейса CustomerRepo, ProductRepo. 
СustomerRepo,  служит для управления хранилищем всех продуктов в магазине.
ProductRepo, для управления корзиной покупателя.


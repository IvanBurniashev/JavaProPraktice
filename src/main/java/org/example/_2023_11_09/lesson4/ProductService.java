package org.example._2023_11_09.lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    private int currentId;
    private Map<Integer, Product> products = new HashMap<>();
    private MerchService merchService;

    public void setMerchService(MerchService merchService) {
        this.merchService = merchService;
    }

    // Запрос всех продуктов:
    // Мы должны запросить сторонний сервис, нужна ли информация о поставщике.
    // Если нет - удаляем информацию из объектов продуктов.

    public List<Product> getAll() {
        List<Product> result = new ArrayList<>(products.values());

        if (merchService.withoutSupplierInfo()) {//спрашиваем, нужна ли информация о поставщике
            result.forEach(x -> x.setSupplier(null));
        }

        return result;
    }

    // Запрос одного продукта:
    // Мы должны запросить у стороннего сервиса наценку.
    // Применяем наценку к запрошенному товару.

    public Product getById(int id) {
        Product product = products.get(id);

        if (product != null) {
            double markup = merchService.getMarkup();
            double newPrice = product.getPrice() * (100 + markup) / 100;
            product.setPrice(newPrice);
        }

        return product;
    }

    // Сохранение продукта:
    // Мы должны обратиться к стороннему сервису, чтобы он создал артикул.
    // Созданный артикул применяется к продукту, сохраняем продукт в БД.

    public Product save(Product product) {
        product.setId(++currentId);//это ПРЕфиксная запись, поэтому сначала увеличиваем, и только потом выолним метод set(), если постфиксная запись - то сначала выполнится метод set(), а потом уже будет добавлен инкримент
        merchService.setArticle(product);
        products.put(product.getId(), product);
        return product;
    }

    // Удаление продукта:
    // Мы должны обратиться к стороннему сервису, чтобы понять
    // удалять продукт из БД физически или просто выставлять статус в 0.
    // Поступаем соответствующим образом.

    public void delete(int id) {
        if (merchService.fullDeletion()) {//если метод говорит true, то мы полностью удаляем его из сервиса, если false, то просто делаем его неактивным.
            products.remove(id);
        } else {
            Product product = products.get(id);

            if (product != null) {
                product.setActive(false);
            }
        }
    }
}
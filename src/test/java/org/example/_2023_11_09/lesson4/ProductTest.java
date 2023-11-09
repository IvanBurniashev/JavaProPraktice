package org.example._2023_11_09.lesson4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;//имею статический доступ ко всем методам, так как будто класс Assertions находится внутри моего класса

class ProductTest {
    @Mock
    private MerchService merchService;
    private ProductService service;

    @BeforeEach
    public void init() {
        merchService = Mockito.mock(MerchService.class);//по умолчанию вернет false
        service = new ProductService();
        service.setMerchService(merchService);
        service.save(new Product("milk", 10, "Muller Milk"));
        service.save(new Product("bread", 21, "Schtirlitz Bread"));
        service.save(new Product("sugar", 15, "Schellenberg Sugar"));
    }

    @Test
    public void checkIfProductsConteinsSupplyerInfo() { // подходы к неймингу разные, можно от оригинального названия метода, можно создавать свои названия, главное что бы название было информативным
        List<Product> products = service.getAll();
        for (Product product : products) {
            assertNotNull(product.getSupplier());
        }
    }

    @Test
    public void checkIfProductSupplyerIsNull() {
        Mockito.when(merchService.withoutSupplierInfo()).thenReturn(true);
        List<Product> products = service.getAll();
        for (Product product : products) {
            assertNull(product.getSupplier());
        }
    }
}
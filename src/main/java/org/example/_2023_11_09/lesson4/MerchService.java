package org.example._2023_11_09.lesson4;

public interface MerchService {//это сторонний сервис

    boolean withoutSupplierInfo();//нужно ли включать инфо о поставщике внутри продукта (мы должны передать продукты БЕЗ инфо если true)

    double getMarkup();

    void setArticle(Product product);//присваивает артикул товару

    boolean fullDeletion();//при удалении из базы данных, если возвращает true то происходит полное удаление продукта из базы данных
    //если false то нужно только сделать его неактивным

}
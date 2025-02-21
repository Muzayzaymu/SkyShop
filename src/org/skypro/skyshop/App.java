package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixCostProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct apple = new SimpleProduct("Яблоко", 100.0);
        DiscountedProduct banana = new DiscountedProduct("Банан со скидкой", 150.0, 10);
        FixCostProduct gum = new FixCostProduct("Жвачка");
        SimpleProduct orange = new SimpleProduct("Апельсин", 120.0);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад со скидкой", 200.0, 20);

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(gum);
        basket.addProduct(orange);
        basket.addProduct(chocolate);

        System.out.println("Содержимое корзины:");
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));
        System.out.println("Есть ли в корзине Торт: " + basket.containsProduct("Торт"));
        basket.clearBasket();
        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(gum);
        searchEngine.add(orange);
        searchEngine.add(chocolate);

        Article article1 = new Article("Как выбрать яблоки", "В этой статье мы расскажем о том, как правильно выбирать яблоки.");
        Article article2 = new Article("Польза бананов", "Бананы - отличный источник калия и энергии.");
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("\nSearch Engine Demonstration:");
        Searchable[] results1 = searchEngine.search("яблоко");
        System.out.println("Search results for 'яблоко':");
        for (Searchable result : results1) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            } else {
                System.out.println("null");
            }
        }

        Searchable[] results2 = searchEngine.search("бананы");
        System.out.println("\nSearch results for 'бананы':");
        for (Searchable result : results2) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            } else {
                System.out.println("null");
            }
        }

        Searchable[] results3 = searchEngine.search("как выбрать");
        System.out.println("\nSearch results for 'как выбрать':");
        for (Searchable result : results3) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            } else {
                System.out.println("null");
            }
        }

        Searchable[] results4 = searchEngine.search("Жвачка");
        System.out.println("\nSearch results for 'Жвачка':");
        for (Searchable result : results4) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            } else {
                System.out.println("null");
            }
        }
    }
}
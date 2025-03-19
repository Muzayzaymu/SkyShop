package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixCostProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        try {
            new SimpleProduct("Valid Product", 10.0);
            new DiscountedProduct("Valid Discounted Product", 20.0, 10);

            new SimpleProduct("Invalid Product", 0);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating SimpleProduct: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Invalid Discounted Product", 0, 10);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating DiscountedProduct (invalid price): " + e.getMessage());
        }

        try {
            new DiscountedProduct("Invalid Discounted Product", 20.0, 101);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating DiscountedProduct (invalid discount): " + e.getMessage());
        }

        try {
            new SimpleProduct("", 10);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating Product with empty name: " + e.getMessage());
        }

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

        System.out.println("\nСодержимое корзины:");
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));
        System.out.println("Есть ли в корзине Торт: " + basket.containsProduct("Торт"));
        basket.clearBasket();
        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли в корзине Яблоко: " + basket.containsProduct("Яблоко"));

        SearchEngine searchEngine = new SearchEngine();
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
        Set<Searchable> results1 = searchEngine.search("яблоко");
        System.out.println("Search results for 'яблоко':");
        for (Searchable result : results1) {
            System.out.println(result.getStringRepresentation());
        }

        Set<Searchable> results2 = searchEngine.search("бананы");
        System.out.println("\nSearch results for 'бананы':");
        for (Searchable result : results2) {
            System.out.println(result.getStringRepresentation());
        }

        Set<Searchable> results3 = searchEngine.search("как выбрать");
        System.out.println("\nSearch results for 'как выбрать':");
        for (Searchable result : results3) {
            System.out.println(result.getStringRepresentation());
        }

        Set<Searchable> results4 = searchEngine.search("Жвачка");
        System.out.println("\nSearch results for 'Жвачка':");
        for (Searchable result : results4) {
            System.out.println(result.getStringRepresentation());
        }


        System.out.println("\nDemonstration of best match search:");

        try {
            Searchable bestMatch = searchEngine.findBestMatch("яблоки");
            System.out.println("Best match for 'яблоки': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println("Error finding best match: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Несуществующий запрос");
            System.out.println("Best match for 'Несуществующий запрос': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println("Error finding best match: " + e.getMessage());
        }
    }
}
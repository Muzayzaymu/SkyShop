package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchTerm) {
        super("No best result found for search term: " + searchTerm);
    }
}
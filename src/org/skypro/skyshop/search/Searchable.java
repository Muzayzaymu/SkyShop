package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + " - " + getContentType();
    }
}
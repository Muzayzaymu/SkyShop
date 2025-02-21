package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results[resultIndex] = searchable;
                resultIndex++;
                if (resultIndex == 5) {
                    break;
                }
            }
        }

        return results;
    }

    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = searchable;
            currentIndex++;
        } else {
            System.out.println("Search engine is full.");
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();
                int occurrences = countOccurrences(searchTerm, searchLower);

                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String searchTerm) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(searchTerm, index)) != -1) {
            count++;
            index += searchTerm.length();
        }
        return count;
    }
}
package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchable = new ArrayList<>();


    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable searchable : searchable) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(searchable);
            }
        }

        return results;
    }

    public void add(Searchable searchable) {
        this.searchable.add(searchable);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchable) {
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
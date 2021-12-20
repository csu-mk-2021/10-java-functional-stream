package com.example.task04;

import java.util.Comparator;
import java.util.Map;

public class WordComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e2.getValue().compareTo(e1.getValue()) != 0
                ? e2.getValue().compareTo(e1.getValue())
                : e1.getKey().compareTo(e2.getKey());
    }
}

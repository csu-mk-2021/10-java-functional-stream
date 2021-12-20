package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> dict = new HashMap<>();
        in.lines()
                .map(String::toLowerCase)
                .flatMap(it -> Stream.of(it.split("\\P{LD}")))
                .filter(it -> !it.isEmpty())
                .forEach(it -> {
                    if (!dict.containsKey(it))
                        dict.put(it, 1);
                    else
                        dict.replace(it, dict.get(it) + 1);
                });

        dict.entrySet()
                .stream()
                .sorted(new WordComparator())
                .limit(10)
                .forEach(it -> System.out.print(it.getKey() + "\n"));
    }

}

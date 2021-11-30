package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.Iterator;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> MinMaxConsumer) {

        Iterator<? extends T> iterator = stream.iterator();
        T current = iterator.hasNext() ? iterator.next() : null;
        T minimal = current;
        T maximal = current;
        while (iterator.hasNext()){
            current = iterator.next();
            if(order.compare(current,minimal) < 0)
                minimal = current;
            else if(order.compare(current,maximal) > 0)
                maximal = current;
        }

        MinMaxConsumer.accept(minimal,maximal);
    }
}

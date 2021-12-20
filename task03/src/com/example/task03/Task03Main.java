package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

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
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        if (stream == null || order == null || minMaxConsumer == null) throw new NullPointerException();
        Iterator<? extends T> it = stream.iterator();
        if (!it.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T bufferMin = it.next();
        T bufferMax = bufferMin;

        while (it.hasNext()) {
            T temporary = it.next();
            if (order.compare(temporary, bufferMax) > 0)
                bufferMax = temporary;
            if (order.compare(bufferMin, temporary) > 0)
                bufferMin = temporary;
        }
        minMaxConsumer.accept(bufferMin, bufferMax);
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterPrimes {

    public static List<Integer> getPrimesUsingJava8(List<Integer> list) {
        List<Integer> primes = list.stream().filter(num -> num != 1 && num != 0).filter(obj -> IntStream.rangeClosed(2, (int) Math.sqrt(obj)).allMatch(fact -> obj % fact != 0)).collect(Collectors.toList());
        return primes;
    }

    public static List<Integer> getPrimesUsingLoops(List<Integer> list) {
        List<Integer> primes = new ArrayList<>(list);
        for (Integer num : list) {
            if (num >= 2) {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        primes.remove(num);
                    }
                }
            } else {
                primes.remove(num);
            }
        }
        return primes;
    }
}

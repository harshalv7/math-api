package uk.co.rbs.util;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathUtil {
    public static Stream<Long> primes(long n) {
        if(n > 1){
            return Stream.iterate(2L, i -> i + 1)
                    .limit(n-1)
                    .filter(MathUtil::isPrime);
        }
        return Stream.empty();
    }
    public static boolean isPrime(long candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return (candidate > 1) && IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}

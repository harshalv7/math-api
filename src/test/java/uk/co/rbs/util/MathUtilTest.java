package uk.co.rbs.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MathUtilTest {
    @Test
    void testPrimerNumbersUpto100() {
        long[] primeNumbers = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        assertTrue(Arrays.stream(primeNumbers).allMatch(MathUtil::isPrime));
    }

    @Test
    void testNonPrimerNumbersUpto100() {
        long[] nonPrimeNumbers = new long[]{0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63};
        assertTrue(Arrays.stream(nonPrimeNumbers).noneMatch(MathUtil::isPrime));
    }

    @Test
    void testUptoGivenLimit() {
        long limit = 25;
        Set<Long> expectedNumbers = Set.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L);
        Set<Long> outputNumbers = MathUtil.primes(limit).collect(Collectors.toSet());
        assertEquals(expectedNumbers, outputNumbers);
    }

    @Test
    void testLimitZero() {
        long limit = 0;
        Set<Long> expectedNumbers = new HashSet<>();
        Set<Long> outputNumbers = MathUtil.primes(limit).collect(Collectors.toSet());
        assertEquals(expectedNumbers, outputNumbers);
    }

    @Test
    void testLimitOne() {
        long limit = 1;
        Set<Long> expectedNumbers = new HashSet<>();
        Set<Long> outputNumbers = MathUtil.primes(limit).collect(Collectors.toSet());
        assertEquals(expectedNumbers, outputNumbers);
    }

    @Test
    void testLimitMinusOne() {
        long limit = -1;
        Set<Long> expectedNumbers = new HashSet<>();
        Set<Long> outputNumbers = MathUtil.primes(limit).collect(Collectors.toSet());
        assertEquals(expectedNumbers, outputNumbers);
    }

    @Test
    void testLimitTwo() {
        long limit = 2;
        Set<Long> expectedNumbers = Set.of(2L);
        Set<Long> outputNumbers = MathUtil.primes(limit).collect(Collectors.toSet());
        assertEquals(expectedNumbers, outputNumbers);
    }

    @Test
    void testLimitMinusTwo() {
        long limit = -2;
        Set<Long> expectedNumbers = new HashSet<>();
        Set<Long> outputNumbers = MathUtil.primes(limit).collect(Collectors.toSet());
        assertEquals(expectedNumbers, outputNumbers);
    }
}

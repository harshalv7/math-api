package uk.co.rbs.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.co.rbs.util.ErrorMessages;
import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MathServiceTest {

    private MathService mathService;
    public MathService getMathService() {
        return mathService;
    }

    @Autowired
    public void setMathService(MathService mathService) {
        this.mathService = mathService;
    }

    @Test
    void testNegativeLimit() {
        final long negativeUpperLimit = -5;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> getMathService().getPrimeNumbersUpto(negativeUpperLimit));

        String expectedMessage = ErrorMessages.NEG_UPPER_LIMIT;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testPositiveLimit() {
        final long limit = 10; // means expected number are 2,3,5,7
        final Collection<Long> expectedPrimeNumbers = Set.of(2L,3L,5L,7L);
        final Collection<Long> outputNumbers = getMathService().getPrimeNumbersUpto(limit);
        assertEquals( expectedPrimeNumbers, outputNumbers );
    }

    @Test
    void testZeroLimit() {
        final long limit = 0;
        final Collection<Long> outputNumbers = getMathService().getPrimeNumbersUpto(limit);
        assertTrue( outputNumbers.isEmpty());
    }

    @Test
    void testLimitOne() {
        final long limit = 1;
        final Collection<Long> outputNumbers = getMathService().getPrimeNumbersUpto(limit);
        assertTrue( outputNumbers.isEmpty());
    }

    @Test
    void testLimitMinusOne() {
        final long negativeUpperLimit = -5;
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> getMathService().getPrimeNumbersUpto(negativeUpperLimit));

        final String expectedMessage = ErrorMessages.NEG_UPPER_LIMIT;
        final String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testLimitMinusTwo() {
        final long negativeUpperLimit = -5;
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> getMathService().getPrimeNumbersUpto(negativeUpperLimit));

        final String expectedMessage = ErrorMessages.NEG_UPPER_LIMIT;
        final String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testLimitTwo() {
        final long limit = 2;
        final Collection<Long> outputNumbers = getMathService().getPrimeNumbersUpto(limit);
        final Collection<Long> expectedNumbers = Set.of(2L);
        assertEquals(outputNumbers, expectedNumbers);
    }
}

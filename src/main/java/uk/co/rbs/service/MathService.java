package uk.co.rbs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.co.rbs.util.ErrorMessages;
import uk.co.rbs.util.MathUtil;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MathService {

    private final Logger logger = LoggerFactory.getLogger(MathService.class);

    public Collection<Long> getPrimeNumbersUpto(long upperLimit){
        if(upperLimit < 0){
            logger.error("Received negative upper limit throwing error : "+ErrorMessages.NEG_UPPER_LIMIT);
            throw new IllegalArgumentException(ErrorMessages.NEG_UPPER_LIMIT);
        }
        logger.trace("Inside MathService.getPrimeNumbersUpto(), parameters => upperLimit = "+upperLimit);
        Collection<Long> primeNumbers = MathUtil.primes(upperLimit).collect(Collectors.toSet());
        logger.trace("Exiting MathService.getPrimeNumbersUpto(), returning => primeNumbers = "+primeNumbers);
        return primeNumbers;
    }
}

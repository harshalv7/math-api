package uk.co.rbs.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rbs.service.MathService;

import java.util.Collection;

@RestController
public class MathController {

    private final Logger logger = LoggerFactory.getLogger(MathController.class);

    private MathService mathService;

    @GetMapping("/numbers/prime/{upperLimit}")
    public Collection<Long> getPrimeNumbersUpto(
            @PathVariable
                    long upperLimit) {
        logger.trace("Inside MathController.getPrimeNumbersUpto(), parameters => upperLimit = " + upperLimit);
        Collection<Long> primeNumbers = getMathService().getPrimeNumbersUpto(upperLimit);
        logger.trace("Exiting MathController.getPrimeNumbersUpto(), returning " + primeNumbers);
        return primeNumbers;
    }

    public MathService getMathService() {
        return mathService;
    }

    @Autowired
    public void setMathService(MathService mathService) {
        this.mathService = mathService;
    }
}

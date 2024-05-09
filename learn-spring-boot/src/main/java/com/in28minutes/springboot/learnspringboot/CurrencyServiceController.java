package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyServiceController {

    @Autowired
    private CurrencyServiceConfig currencyServiceConfig;
    
    @RequestMapping("/currency-service")
    public CurrencyServiceConfig retrieveAllCourses() {

        return currencyServiceConfig;
    }
    
}

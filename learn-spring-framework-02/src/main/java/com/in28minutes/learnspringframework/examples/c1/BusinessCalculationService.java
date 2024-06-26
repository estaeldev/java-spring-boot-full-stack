package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Component
@Service
public class BusinessCalculationService {

     @Autowired
    private DataService dataService;

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
    
}

package com.example.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyMathTest {

    @Test
    void testCalculateSum() {
        int[] numbers = {1,2,3};
        MyMath myMath = new MyMath();
        Integer result = myMath.calculateSum(numbers);
        
        Assertions.assertEquals(6, result);
        
    }

}


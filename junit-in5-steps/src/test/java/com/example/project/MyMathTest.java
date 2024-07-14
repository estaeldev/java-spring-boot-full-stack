package com.example.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyMathTest {

    private MyMath myMath = new MyMath();

    @Test
    void testCalculateSum_ThreeMemberArray() {
        Integer result = myMath.calculateSum(new int[] {1,2,3});
        Assertions.assertEquals(6, result);
    }

    @Test
    void testCalculate_ZeroLengthArray() {
        Integer result = myMath.calculateSum(new int[] {});
        Assertions.assertEquals(0, result);
    }
    
}


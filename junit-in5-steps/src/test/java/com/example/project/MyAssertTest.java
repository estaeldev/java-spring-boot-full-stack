package com.example.project;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyAssertTest {

    private List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        boolean result = todos.contains("AWS");

        Assertions.assertTrue(result);
        
        Assertions.assertEquals(3, todos.size());

    }


}

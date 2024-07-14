package com.project.mockito.mockito_demo.business;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataService;

    @InjectMocks
    private SomeBusinessImpl someBusinessImpl;

    @Test
    void testFindTheGreatestFromAllData_basicScenario() {
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        int result = someBusinessImpl.findTheGreatestFromAllData();
        Assertions.assertEquals(25, result);

        Mockito.verify(dataService, times(1)).retrieveAllData();
    }

    @Test
    void testFindTheGreatestFromAllData_OneValue() {
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {35});

        int result = someBusinessImpl.findTheGreatestFromAllData();
        Assertions.assertEquals(35, result);

        Mockito.verify(dataService, times(1)).retrieveAllData();
    }

    @Test
    void testFindTheGreatestFromAllData_EmptyArray() {
        Mockito.when(dataService.retrieveAllData()).thenReturn(new int[] {});

        int result = someBusinessImpl.findTheGreatestFromAllData();
        Assertions.assertEquals(Integer.MIN_VALUE, result);

        Mockito.verify(dataService, times(1)).retrieveAllData();
    }


}


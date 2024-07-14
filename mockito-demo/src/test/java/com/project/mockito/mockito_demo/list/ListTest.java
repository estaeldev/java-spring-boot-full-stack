package com.project.mockito.mockito_demo.list;

import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {


    @Test
    void simpleTest() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(3);

        Assertions.assertEquals(3, listMock.size());
        
    }

    @Test
    void multipleReturns() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(1).thenReturn(2);

        Assertions.assertEquals(1, listMock.size());
        Assertions.assertEquals(2, listMock.size());
        
        Mockito.verify(listMock, times(2)).size();
        
    }

    @Test
    void parameters() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");

        Assertions.assertEquals("SomeString", listMock.get(0));
        
        Mockito.verify(listMock, times(1)).get(0);
        
    }


    
}

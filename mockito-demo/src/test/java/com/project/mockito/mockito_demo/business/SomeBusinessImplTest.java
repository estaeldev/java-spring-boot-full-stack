package com.project.mockito.mockito_demo.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {

    private final DataServiceStub dataServiceStub = new DataServiceStub();
    private final SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);

    @Test
    void testFindTheGreatestFromAllData_basicScenario() {
        int result = this.someBusinessImpl.findTheGreatestFromAllData();
        Assertions.assertEquals(25, result);
    }


}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
    
}

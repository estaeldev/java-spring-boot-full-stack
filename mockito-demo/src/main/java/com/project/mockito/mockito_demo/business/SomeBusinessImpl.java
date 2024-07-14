package com.project.mockito.mockito_demo.business;

interface DataService {
    int[] retrieveAllData();
}


public class SomeBusinessImpl {
    
    private final DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = this.dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for(int value : data) {
            if(value > greatestValue) {
                greatestValue = value;
            }
        }
        return greatestValue;
    }

}



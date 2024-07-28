package com.project.learn_aop.aop.data;

import org.springframework.stereotype.Repository;

import com.project.learn_aop.aop.aspects.annotations.TrackTime;

@Repository
public class DataService1 {

    @TrackTime
    public int[] retrieveData() {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        
        return new int[] {11, 22, 33, 44, 55};
    }
    
}

package org.example.math;

import java.util.Random;

public class RandomHandler {

    public void start(){
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }

}

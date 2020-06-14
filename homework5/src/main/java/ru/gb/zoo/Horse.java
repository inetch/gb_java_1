package ru.gb.zoo;

import java.util.Random;

public class Horse extends Animal {
    private static int instance_count = 0;

    public Horse (){
        instance_count++;
        spec = "Horse";

        Random random = new Random();
        maxRunLength = 1000 + random.nextInt(1000);
        maxSwimLength = 70 + random.nextInt(60);
        maxJumpHeight = 2 + 1.5 * random.nextDouble();
    }

    public static int getCount(){
        return instance_count;
    }
}

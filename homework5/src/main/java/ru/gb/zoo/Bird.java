package ru.gb.zoo;

import java.util.Random;

public class Bird extends Animal {
    private static int instance_count = 0;

    public Bird(){
        instance_count++;
        spec = "Bird";

        Random random = new Random();
        maxRunLength = 4 + random.nextInt(2);
        maxSwimLength = 0;
        maxJumpHeight = 0.07 + 0.05 * random.nextDouble();
    }

    public static int getCount(){
        return instance_count;
    }
}

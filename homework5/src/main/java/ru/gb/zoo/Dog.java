package ru.gb.zoo;

import java.util.Random;

public class Dog extends Animal {
    private static int instance_count = 0;

    public Dog(){
        instance_count++;
        spec = "Dog";

        Random random = new Random();
        maxRunLength = 400 + random.nextInt(200);
        maxSwimLength = 7 + random.nextInt(6);
        maxJumpHeight = 0.3 + 0.2 * random.nextDouble();
    }

    public static int getCount(){
        return instance_count;
    }

}

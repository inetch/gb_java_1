package ru.gb.zoo;

import java.util.Random;

public class Cat extends Animal {
    private static int instance_count = 0;

    public Cat(){
        instance_count++;
        spec = "Cat";

        Random random = new Random();
        maxRunLength = 150 + random.nextInt(100);
        maxSwimLength = 0;
        maxJumpHeight = 1.5 + 1 * random.nextDouble();
    }

    public static int getCount(){
        return instance_count;
    }

}

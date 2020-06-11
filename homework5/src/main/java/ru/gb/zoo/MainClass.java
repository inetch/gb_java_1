package ru.gb.zoo;

public class MainClass {
    public static void main(String[] args) {
        Animal[] zoo = {
                new Cat(), new Dog(), new Horse(), new Bird(), new Cat()
        };

        System.out.println(String.format("%d animals in the Zoo!", Animal.getAnimalCount()));
        System.out.println(String.format("%d cats in the Zoo!", Cat.getCount()));
        System.out.println(String.format("%d dogs in the Zoo!", Dog.getCount()));

        for (Animal a: zoo) {
            System.out.println(a);
        }


        int[] chases = {100, 300, 1000};
        Animal.chaseRun(chases, zoo);

        chases[0] = 5;
        chases[1] = 15;
        chases[2] = 50;
        Animal.chaseSwim(chases, zoo);

        double[] dChases = {0.1, 1.0, 3.5};
        Animal.chaseJump(dChases, zoo);

    }
}

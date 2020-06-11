package ru.gb.zoo;

public class MainClass {
    public static void main(String[] args) {
        Animal[] zoo = {
                new Cat(), new Dog(), new Horse(), new Bird()
        };

        for (Animal a: zoo) {
            System.out.println(a);
        }
    }
}

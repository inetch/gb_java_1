package ru.gb.zoo;

/*
1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть и прыгать. В качестве параметра каждому методу передается величина,
   обозначающая или длину (для бега и плавания), или высоту (для прыжков)
3. У каждого животного есть ограничения на действия: бег: кот = 200 м., собака = 500 м., лошадь = 1500 м,
   птица = 5 м; плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м. прыжок: кот = 2 м., собака 0.4 м., лошадь 3 м., птица 0.1 м.
4. При попытке выполнить одно из действий, оно должно сообщить результат:
   смогло или нет животное выполнить действие, например, dog.run(150); -> результат 'Пес пробежал!';
5. * Добавить подсчет созданных котов, собак и животных.
6. * Добавить животным разброс в ограничениях. То есть у одной собаки может быть ограничение на бег 400 м., у другой 600 м..
 */
public abstract class Animal {
    private static int instance_count = 0;

    protected int maxRunLength;
    protected int maxSwimLength;
    protected double maxJumpHeight;

    protected String spec;

    public Animal(){
        instance_count++;
    }

    public static int getAnimalCount(){
        return instance_count;
    }

    public boolean run(int length){
        return length <= maxRunLength;
    }
    public boolean swim(int length){
        return length <= maxSwimLength;
    }
    public boolean jump(double height){
        return height <= maxJumpHeight;
    }

    @Override
    public String toString() {
        return String.format("I am a %s! I can run %d meters, swim %d meters and jump on %.1f meters!", spec, maxRunLength, maxSwimLength, maxJumpHeight);
    }

    public String getSpec(){
        return spec;
    }

    public static void chaseRun(int[] distances, Animal[] zoo){
        System.out.println();
        for(int d : distances) {
            System.out.println(String.format("Run %d meters!", d));
            for (Animal a : zoo) {
                if (a.run(d)){
                    System.out.println(a.getSpec() + " runs!");
                } else {
                    System.out.println(a.getSpec() + " fails...");
                }
            }
        }
    }

    public static void chaseSwim(int[] distances, Animal[] zoo){
        System.out.println();
        for(int d : distances) {
            System.out.println(String.format("Swim %d meters!", d));
            for (Animal a : zoo) {
                if (a.swim(d)){
                    System.out.println(a.getSpec() + " swims!");
                } else {
                    System.out.println(a.getSpec() + " fails...");
                }
            }
        }
    }

    public static void chaseJump(double[] distances, Animal[] zoo){
        System.out.println();
        for(double d : distances) {
            System.out.println(String.format("Jump %.1f meters!", d));
            for (Animal a : zoo) {
                if (a.jump(d)){
                    System.out.println(a.getSpec() + " jumps!");
                } else {
                    System.out.println(a.getSpec() + " fails...");
                }
            }
        }
    }
}

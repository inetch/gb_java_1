package ru.gb.hw1;

public class MainClass {
    /*
    3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
     */
    private static double theCalc(double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    /*
    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
      от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     */
    private static boolean checkSum(int a, int b){
        if((10 <= a + b) && (20 >= a + b)){
            return true;
        }
        return false;
    }

    /*
    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
    в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
     */
    private static void printSign(int x){
        if(x >= 0){
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }

    /*
    6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
     */
    private static boolean isNegative(int x){
        if(x < 0){
            return true;
        }
        return false;
    }

    /*
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    private static void printHi(String name){
        System.out.println("Привет, " + name + "!");
    }

    /*
    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    private static void printIsLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("Year " + year + " is leap!");
        } else {
            System.out.println("Year " + year + " is NOT leap!");
        }
    }

    public static void main(String[] agrs){
        byte    the_byte    = 1;
        short   the_short   = 12000;
        int     the_int     = 2342045;
        long    the_long    = 97456L;
        char    the_char    = 'G';

        float   the_float   = 123.93f;
        double  the_doube   = 4545.7247;

        boolean the_bool    = false;

        System.out.println(theCalc(123, 45, 67, 3));
        System.out.println(checkSum(2, 7));
        printSign(-90);
        System.out.println(isNegative(-90));
        printHi("Chuck Norris");
        printIsLeapYear(2021);
    }
}

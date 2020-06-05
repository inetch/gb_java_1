package ru.gb.hw4;

public class Employer {
    private String fio;
    private String email;
    private String phone;
    private int salary;

    private final int birthYear;

    private static final int CURRENT_YEAR = 2020;

    public Employer(String fio, int age){
        this.fio = fio;
        birthYear = CURRENT_YEAR - age;
    }

    public Employer(String fio, String email, String phone, int birthYear){
        this.fio = fio;
        this.email = email;
        this.phone = phone;
        this.birthYear = birthYear;
    }

    public Employer(String fio, String email, String phone, int birthYear, int salary){
        this(fio, email, phone, birthYear);
        this.salary = salary;
        this.email = email;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getAge(){
        return CURRENT_YEAR - birthYear;
    }

    public void sayMyName(){
        System.out.println("Я, " + fio + ", " + birthYear + " года рождения, имею телефон " + phone + " и почту " + email + ", и зарабатываю " + salary + " в год");
    }

}

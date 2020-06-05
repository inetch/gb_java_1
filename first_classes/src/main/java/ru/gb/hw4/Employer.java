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

    private String ageString(){
        int age = CURRENT_YEAR - birthYear;
        if(age > 4 && age < 20){
            return age + " лет";
        }else{
            switch (age%10) {
                case 1: return age + " год";
                case 2:
                case 3:
                case 4: return age + " года";
                default: return age + " лет";
            }
        }
    }

    private String checkNull(String str, String conMessage, String nullMessage){
        if (str == null){
            return nullMessage;
        }else{
            return conMessage + " " + str;
        }
    }

    private String emailString(){
        return checkNull(email, "почта", "нет почты");
    }

    private String phoneString(){
        return checkNull(phone, "телефон", "нет телефона");
    }

    public void sayMyName(){
        System.out.println("Я " + fio + ", мне " + ageString() + ", " + phoneString() + ", " + emailString() + ", и зарабатываю " + salary + " в год");
    }

    public void elderVoice(int borderAge){
        if (borderAge <= CURRENT_YEAR - birthYear){
            sayMyName();
        }
    }

}

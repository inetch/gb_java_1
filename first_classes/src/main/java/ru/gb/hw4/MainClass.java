package ru.gb.hw4;

public class MainClass {
    public static void main(String[] args) {
        int departmentSize = 5;

        Employer[] employers = new Employer[departmentSize];

        employers[0] = new Employer("Heisenberg", "info@dea.com", "911", 1970, 50000000);
        employers[1] = new Employer("Мистер Х", 18);
        employers[2] = new Employer("Homer J. Simpson", "homersimpson@yahoo.org", "5556789086", 1955, 85000);
        employers[3] = new Employer("Кот", null, null, 2010, 300);
        employers[4] = new Employer("Austin Powers", "riddle@middle.shmiddle", "0xDEADBEEF", 1979, 0);

        System.out.println("Вся дрим-тим:");
        for (Employer e: employers){
            e.sayMyName();
        }

        System.out.println();
        System.out.println("Зрелые, сформировавшиеся личности:");
        int borderAge = 40;

        for(Employer e: employers){
            e.elderVoice(borderAge);
        }
    }
}

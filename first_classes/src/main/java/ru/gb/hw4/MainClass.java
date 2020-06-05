package ru.gb.hw4;

public class MainClass {
    public static void main(String[] args) {
        Employer[] employers = new Employer[5];

        employers[0] = new Employer("Heisenberg", "info@dea.com", "911", 1970, 50000000);
        employers[2] = new Employer("Мистер Х", 18);
        employers[3] = new Employer("Homer J. Simpson", "homersimpson@yahoo.org", "5556789086", 1955, 85000);
        employers[4] = new Employer("Кот", null, null, 2010, 300);
        employers[5] = new Employer("Austin Powers", "riddle@middle.shmiddle", "0xDEADBEEF", 1978, 0);
    }
}

package ru.gb.hw3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char X_TAG = 'X';
    private static final char O_TAG = 'O';
    private static final char EMPTY_TAG = ' ';

    private static char humanTag;
    private static char aiTag;

    private static int xScale;
    private static int yScale;

    private static char[][] field;

    private static int winLength;

    private static char lastTurnTag;
    private static int lastTurnX;
    private static int lastTurnY;

    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args){
        scanner = new Scanner(System.in);
        random = new Random();

        init();

        do{
            humanTurn();
            if(checkWin())break;
            aiTurn();
            if(checkWin())break;
        } while (true);

        if(lastTurnTag == humanTag){
            System.out.println("Человек победил!");
        }else{
            System.out.println("Bite my shiny metal ass!");
        }

        scanner.close();
    }

    private static void humanTurn(){
        int x;
        int y;
        do {
            System.out.println("Твой ход (колонка 1 - " + xScale + ", потом ряд 1 - " + yScale + "):");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while ((x < 1 || x > xScale) && (y < 1 || y > yScale));

        turn(humanTag, x - 1, y - 1);
    }

    private static void aiTurn(){
        int x;
        int y;
        do{
            x = random.nextInt(xScale);
            y = random.nextInt(yScale);
        } while (field[x][y] != EMPTY_TAG);
        turn(aiTag, x, y);
    }

    private static boolean checkLine(boolean dX, boolean dY){
        /*
            dX = true, dY = false - to check horizontal
            dX = false, dY = true - to check vertical
            dX = true, dY = true - main diagonal
            dX = false, dY = false - sub diagonal
         */
        int line = 0;
        int x = lastTurnX;
        int y = lastTurnY;

        do{
            if (field[x][y] == lastTurnTag){
                if(++line == winLength){
                    return true;
                }
                if(!dX && !dY){
                    x--;y++;
                }else{
                    x += dX ? 1 : 0;
                    y += dY ? 1 : 0;
                }
            } else {
                break;
            }
        } while (x >= 0 && x < xScale && y >= 0 && y < yScale);

        if(!dX && !dY){
            x = lastTurnX + 1;
            y = lastTurnY - 1;
        }else{
            x = lastTurnX + (dX ? 1 : -1);
            y = lastTurnY + (dY ? 1 : -1);
        }
        while (x >= 0 && x < xScale && y >= 0 && y < yScale){
            if (field[x][y] == lastTurnTag){
                if(++line == winLength){
                    return true;
                }
                if(!dX && !dY){
                    x++;y--;
                }else{
                    x += dX ? 0 : 1;
                    y += dY ? 0 : 1;
                }
            } else {
                break;
            }
        }

        return false;
    }

    private static boolean checkWin(){
        return checkLine(true, false) || checkLine(false, true) || checkLine(true, true) || checkLine(false, false);
    }

    private static void fillArray(char arr[][], char filler){
        for (int x = 0; x < arr.length; x++){
            for (int y = 0; y < arr[x].length; y++){
                arr[x][y] = filler;
            }
        }
    }

    private static void turn(char tag, int x, int y){
        field[x][y] = tag;
        lastTurnTag = tag;
        lastTurnX = x;
        lastTurnY = y;
        printField();
    }

    private static void printField(){
        for (int i = 0; i < xScale * 2 + 1; i++){
            System.out.print("-");
        }
        System.out.println();
        for (int y = 0; y < yScale; y++){
            for (int x = 0; x < xScale; x++){
                System.out.print("|" + field[x][y]);
            }
            System.out.println("|");
        }
        for (int i = 0; i < xScale * 2 + 1; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private static void init(){
        System.out.println("Какими фишками будешь играть, человек? Введи " + X_TAG + " иои " + O_TAG + ":");
        do{
            humanTag = scanner.next().charAt(0);
        }while (humanTag != X_TAG && humanTag != O_TAG);
        aiTag = humanTag == X_TAG ? O_TAG : X_TAG;
        System.out.println("Компьютер будет играть фишками " + aiTag);

        System.out.println("Введи размер поля (X Y):");
        xScale = scanner.nextInt();
        yScale = scanner.nextInt();
        System.out.println("Будем играть на поле " + xScale + " колонок на " + yScale + " рядов");
        field = new char[xScale][yScale];
        fillArray(field, EMPTY_TAG);

        int maxWin = xScale < yScale ? xScale : yScale;
        System.out.println("Сколько фишек для победы? Максимум " + maxWin);
        do{
            winLength = scanner.nextInt();
        } while (winLength < 1 || winLength > maxWin);

        printField();
    }
}

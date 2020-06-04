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

    private static int lastHumanTurnX;
    private static int lastHumanTurnY;

    private static int turns;

    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args){
        scanner = new Scanner(System.in);
        random = new Random();

        init();

        int maxTurns = xScale * yScale;

        boolean humanWinner = false;
        boolean aiWinner = false;

        do{
            humanTurn();
            humanWinner = checkWin();
            if(humanWinner || turns == maxTurns)break;

            aiSmartTurn();
            aiWinner = checkWin();
            if(aiWinner || turns == maxTurns)break;
        } while (true);

        if(humanWinner){
            System.out.println("Человек победил!");
        } else if (aiWinner){
            System.out.println("Компьютер победил!");
        } else {
            System.out.println("Победила дружба!");
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
        lastHumanTurnX = x - 1;
        lastHumanTurnY = y - 1;
    }

    private static void aiSmartTurn(){
        int lineX = 0;

        int xTurn = -1;
        //check horizontal
        int x = lastHumanTurnX - 1;
        while (x >= 0){
            if(field[x][lastHumanTurnY] == humanTag){
                lineX++;
            } else if (field[x][lastHumanTurnY] == EMPTY_TAG){
                xTurn = x;
            }
            x--;
        }
        x = lastHumanTurnX + 1;
        while (x < xScale){
            if(field[x][lastHumanTurnY] == humanTag){
                lineX++;
            } else if (field[x][lastHumanTurnY] == EMPTY_TAG){
                xTurn = x;
            }
            x++;
        }

        if (xTurn == -1){
            lineX = 0;
        }

        //check vertical
        int y = lastHumanTurnY - 1;
        int lineY = 0;
        int yTurn = -1;
        while (y >= 0){
            if(field[lastHumanTurnX][y] == humanTag){
                lineY++;
            } else if (field[lastHumanTurnX][y] == EMPTY_TAG){
                yTurn = y;
            }
            y--;
        }
        y = lastHumanTurnY + 1;
        while (y < yScale){
            if(field[lastHumanTurnX][y] == humanTag){
                lineY++;
            } else if (field[lastHumanTurnX][y] == EMPTY_TAG){
                yTurn = y;
            }
            y++;
        }

        if(yTurn == -1){
            lineY = 0;
        }

        if(lineY >= lineX){
            lineX = 0;
        }

        //check mainD
        y = lastHumanTurnY - 1;
        x = lastHumanTurnX - 1;
        int lineD1 = 0;
        int yD1Turn = -1;
        int xD1Turn = -1;
        while (y >= 0 && x >= 0){
            if(field[x][y] == humanTag){
                lineD1++;
            } else if (field[x][y] == EMPTY_TAG){
                yD1Turn = y;
                xD1Turn = x;
            }
            y--;x--;
        }
        y = lastHumanTurnY + 1;
        x = lastHumanTurnX + 1;
        while (y < yScale && x < xScale){
            if(field[x][y] == humanTag){
                lineD1++;
            } else if (field[x][y] == EMPTY_TAG){
                yD1Turn = y;
                xD1Turn = x;
            }
            y++;x++;
        }

        if(yD1Turn == -1 || xD1Turn == -1){
            lineD1 = 0;
        }
        if(lineD1 >= lineX){
            lineX = 0;
        }
        if(lineD1 >= lineY){
            lineY = 0;
        }

        //check subD
        y = lastHumanTurnY - 1;
        x = lastHumanTurnX + 1;
        int lineD2 = 0;
        int yD2Turn = -1;
        int xD2Turn = -1;
        while (y >= 0 && x < xScale){
            if(field[x][y] == humanTag){
                lineD2++;
            } else if (field[x][y] == EMPTY_TAG){
                yD2Turn = y;
                xD2Turn = x;
            }
            y--;x++;
        }
        y = lastHumanTurnY + 1;
        x = lastHumanTurnX - 1;
        while (y < yScale && x >= 0){
            if(field[x][y] == humanTag){
                lineD2++;
            } else if (field[x][y] == EMPTY_TAG){
                yD2Turn = y;
                xD2Turn = x;
            }
            y++;x--;
        }

        if(yD2Turn == -1 || xD2Turn == -1){
            lineD2 = 0;
        }
        if(lineD2 >= lineX){
            lineX = 0;
        }
        if(lineD2 >= lineY){
            lineY = 0;
        }
        if(lineD2 >= lineX){
            lineX = 0;
        }
        if(lineD2 >= lineD1){
            lineD1 = 0;
        }

        if(lineX > 0){
            turn(aiTag, xTurn, lastHumanTurnY);
        } else if (lineY > 0){
            turn(aiTag, lastHumanTurnX, yTurn);
        } else if (lineD1 > 0) {
            turn(aiTag, xD1Turn, yD1Turn);
        } else if (lineD2 > 0) {
            turn(aiTag, xD2Turn, yD2Turn);
        } else{
            aiStupidTurn();
        }
    }

    private static void aiStupidTurn(){
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
            x = lastTurnX + (dX ? -1 : 0);
            y = lastTurnY + (dY ? -1 : 0);
        }

        while (x >= 0 && x < xScale && y >= 0 && y < yScale){
            if (field[x][y] == lastTurnTag){
                if(++line == winLength){
                    return true;
                }
                if(!dX && !dY){
                    x++;y--;
                }else{
                    x -= dX ? 1 : 0;
                    y -= dY ? 1 : 0;
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
        turns++;
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

package org.example;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static Scanner scanner;
    private static Random random = new Random();
    private static char[][] field;
    private static final int SIZE = 3;
    private static final char FIELD_ELEMENT_EMPTY = '*';
    private static final char FIELD_ELEMENT_X = 'X';
    private static final char FIELD_ELEMENT_O = 'O';

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        initField();
        printField();
        while (true) {
            playerTurn();
            printField();
            if (checkWin('X')) {
                System.out.println("Победа");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printField();
            if (checkWin('O')) {
                System.out.println("Поражение");
                break;
        }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void playerTurn() {
        int x, y;
do {
    System.out.println("Введите координаты вашего хода (X, Y)");
    x = scanner.nextInt() - 1;
    y = scanner.nextInt() - 1;
} while (!isCellEmpty(x, y));
         field[x][y] = FIELD_ELEMENT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        field[x][y] = FIELD_ELEMENT_O;
        System.out.println("Бот походил в клетку [ " + (x + 1) + ", " + (y + 1) +  " ]");
    }

    public static boolean checkWin(char element) {
        if (field[0][0] == element && field[1][0] == element && field[2][0] == element) {
            return true;
        }
        if (field[0][1] == element && field[1][1] == element && field[2][1] == element) {
            return true;
        }
        if (field[0][2] == element && field[1][2] == element && field[2][2] == element) {
            return true;
        }
        if (field[0][0] == element && field[0][1] == element && field[0][2] == element) {
            return true;
        }
        if (field[1][0] == element && field[1][1] == element && field[1][2] == element) {
            return true;
        }
        if (field[2][0] == element && field[2][1] == element && field[2][2] == element) {
            return true;
        }
        if (field[0][0] == element && field[1][1] == element && field[2][2] == element) {
            return true;
        }
        if (field[2][0] == element && field[1][1] == element && field[0][2] == element) {
            return true;
        }

        return false;
    }

    public static boolean isCellEmpty(int x, int y) {
     if(x<0 || y<0 || x>=SIZE || y>=SIZE) {
         return false;
     }
     if (field[x][y] != FIELD_ELEMENT_EMPTY) {
         return false;
     }
     return true;
    }

    public static boolean isFieldFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
if (field[i][j] == '*') {
    return false;
}
            }
        }
        return true;
    }

    public static void printField() {
        for (int i = 0; i <=SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = FIELD_ELEMENT_EMPTY;
            }
        }
    }
}

package at.technikum.tictactoe;

import java.util.Scanner;

public class Board {

    public static final char CHAR_ZERO_REPLACER = '⚡';
    private char[][] cells;

    public Board() {
        this.clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return this.cells[x][y] == 0; // char represented by unicode codepoint
    }

    public int[] chooseCell(Scanner scanner) {
        boolean emptyCellChosen = false;
        int[] chosenCell = new int[2];

        while (!emptyCellChosen) {
            try {
                System.out.println("Please place your marker on an empty cell!");
                System.out.print("row (0-2): ");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.print("column (0-2): ");
                int y = Integer.parseInt(scanner.nextLine());

                if (x < 0 || x > 2 || y < 0 || y > 2) {
                    System.out.println("Error: Coordinates must be between 0 and 2!");
                    continue;
                }

                if (this.isCellEmpty(x, y)) {
                    emptyCellChosen = true;
                    chosenCell[0] = x;
                    chosenCell[1] = y;
                } else {
                    System.out.println("Error: Cell is occupied! Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a number!");
            }
        }
        return chosenCell;
    }



    public void place(int x, int y, char marker) {
        // guard against placing value0-chars
        char placedMarker = marker==0? CHAR_ZERO_REPLACER :marker;

        this.cells[x][y] = placedMarker;

    }

    public boolean isFull() {
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                if (this.isCellEmpty(i,j)) return false;
            }
        }
        return true;
    }

    public void clear() {
        this.cells = new char[3][3]; // assumed assumed to be "3" by spec I assume
    }

    public void print() {
        System.out.println("-------");
        for (var i = 0; i < 3; i++) {
            System.out.print("|");
            for (var j = 0; j < 3; j++) {
                if (this.isCellEmpty(i,j)) {
                    System.out.print(" |");
                } else {
                    System.out.print(this.cells[i][j]);
                    System.out.print("|");
                }
            }
            System.out.println();
        }

        System.out.println("-------");

    }

}

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

    public void place(char marker) {
        // guard against placing value0-chars
        char placedMarker = marker==0? CHAR_ZERO_REPLACER :marker;

        boolean markerPlacedSuccessfully = false;

        while (!markerPlacedSuccessfully) {
            System.out.println("Please place your marker on an empty cell!");
            System.out.print("row (0-2): ");
            Scanner scanner = new Scanner(System.in);
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("column (0-2): ");
            int y = Integer.parseInt(scanner.nextLine());

            if (this.isCellEmpty(x, y)) {
                this.cells[x][y] = placedMarker;
                markerPlacedSuccessfully = true;
            }
        }
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

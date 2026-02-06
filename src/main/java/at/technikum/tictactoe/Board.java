package at.technikum.tictactoe;

public class Board {

    public static final char CHAR_ZERO_REPLACER = '⚡';
    private char[][] cells;

    public Board() {
        this.clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return this.cells[x][y] == 0; // char represented by unicode codepoint
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
        // TODO/reserved for issue #2
    }

}

package at.technikum.tictactoe;

public class Player {
    private char marker;

    public Player(char marker) {
        this.marker = marker;
        if (this.marker == 0) this.marker = Board.CHAR_ZERO_REPLACER; // board spec requires an 'empty' marker. assuming 0 supposed to be reserved value
    }

    public char getMarker() {
        return marker;
    }
}

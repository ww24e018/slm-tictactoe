package at.technikum.tictactoe;


public class TicTacToe {
    public static final char PLAYER1MARKER = 'X';
    public static final char PLAYER2MARKER = 'O';
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        this.player1 = new Player(PLAYER1MARKER);
        this.player2 = new Player(PLAYER2MARKER);
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        return;
    }

    private void switchCurrentPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2; return;
        }
        if (this.currentPlayer == this.player2) {
            this.currentPlayer = this.player1; return;
        }
        throw new RuntimeException("Internal Component Error in TicTacToe - Should not happen! ('Huh?')");
    }

    private boolean hasWinner() {
        throw new RuntimeException("not implemented yet. reserved for #3");
    }
}

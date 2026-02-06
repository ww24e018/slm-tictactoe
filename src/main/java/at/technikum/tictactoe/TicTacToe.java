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
        boolean quitGame = false;
        while (!quitGame) {
            System.out.format("Current Player: %c\n", currentPlayer.getMarker());

            // TODO: player input and acting on it, showing game state

            // TODO: checking game-end conditions, dealing with it, asking player, making switchPlayer conditional
            this.switchCurrentPlayer();

            // TODO: next line is terminating placeholder; replace by actual game logic
            if (this.currentPlayer == this.player1) quitGame = true;
        }
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


    public static void main(String[] args) {
        new TicTacToe().start();
    }
}

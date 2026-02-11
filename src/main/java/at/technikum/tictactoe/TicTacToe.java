package at.technikum.tictactoe;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static final char PLAYER1MARKER = 'X';
    public static final char PLAYER2MARKER = 'O';
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scanner;

    public TicTacToe() {
        this(new Scanner(System.in));
    }

    public TicTacToe(Scanner scanner) {
        this.player1 = new Player(PLAYER1MARKER);
        this.player2 = new Player(PLAYER2MARKER);
        this.currentPlayer = player1;
        this.scanner = scanner;
    }

    public void start() {
        boolean endGame = false;
        do {
            this.board = new Board();
            do {
                System.out.format("Current Player: %c\n", currentPlayer.getMarker());
                board.print();

                int[] coordinates = board.chooseCell(scanner);
                board.place(coordinates[0], coordinates[1], currentPlayer.getMarker());
                this.switchCurrentPlayer();
                endGame = this.hasWinner() || board.isFull();

            } while (!endGame);
            System.out.println(this.getResult());
            board.print();
            System.out.println();

        } while(playAgain());

    }

    public boolean playAgain(){
        System.out.println("Do you want to play agan? Choose by entering yes/no");
        String answer = scanner.nextLine();
        while(!answer.equals("no") && !answer.equals("yes")){
            System.out.println("Invalid input. Valid input is yes/no");
            answer = scanner.nextLine();
        }

        if(answer.equals("no")) return false;
        return true;
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
        if(board.isWinner(player1.getMarker()) || board.isWinner(player2.getMarker())){
            return true;
        }
        return false;
    }

    private String getResult(){
        if(!hasWinner() && board.isFull()){
            return "Game endet in a draw";
        }

        if(board.isWinner(player1.getMarker())){
            return "Player 1 (" + player1.getMarker() + ") won!";
        }

        if(board.isWinner(player2.getMarker())){
            return "Player 2 (" + player2.getMarker() + ") won!";
        }

        return "There are still cells to fill.";
    }


    public static void main(String[] args) {
        new TicTacToe().start();
    }
}

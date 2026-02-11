package at.technikum.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void ticTacToeConstructorCanBeCalledAndReturns() {
        assertNotEquals(null, new TicTacToe());
    }

    @Test
    void playAgainTrue(){
        String simulatedInput = "yes";
        Scanner testScanner = new Scanner(simulatedInput);
        TicTacToe game = new TicTacToe(testScanner);
        assertTrue(game.playAgain());
    }

    @Test
    void playAgainFalse(){
        String simulatedInput = "no";
        Scanner testScanner = new Scanner(simulatedInput);
        TicTacToe game = new TicTacToe(testScanner);
        assertFalse(game.playAgain());
    }

}
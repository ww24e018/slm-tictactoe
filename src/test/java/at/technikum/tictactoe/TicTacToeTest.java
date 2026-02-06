package at.technikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void ticTacToeConstructorCanBeCalledAndReturns() {
        assertNotEquals(null, new TicTacToe());
    }

}
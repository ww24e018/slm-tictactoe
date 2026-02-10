package at.technikum.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void newBoardShouldReturnEmptyForAllCells() {
        var newBoard = new Board();
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                assertTrue(newBoard.isCellEmpty(i,j));
            }
        }
    }

    @Test
    void isEmptyThrowsForOutOfBoundValuesPositive() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Board().isCellEmpty(4,4));
    }
    @Test
    void isEmptyThrowsForOutOfBoundValuesNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Board().isCellEmpty(-1,-1));
    }

    @Test
    void testChooseCellWithInvalidThenValidInput() {
        Board newBoard = new Board();
        String simulatedInput = "abc\n5\n5\n1\n1";
        Scanner testScanner = new Scanner(simulatedInput);

        int[] result = newBoard.chooseCell(testScanner);

        assertArrayEquals(new int[]{1, 1}, result);
    }

    @Test
    void testChooseCellWhenChosenCellIsOccupied() {
        Board newBoard = new Board();
        newBoard.place(0, 0, 'X');
        String simulatedInput = "0\n0\n1\n1\n";
        Scanner testScanner = new Scanner(simulatedInput);
        int[] result = newBoard.chooseCell(testScanner);
        assertArrayEquals(new int[]{1, 1}, result);
    }

    @Test
    void placeThrowsForOutOfBoundValuesPositive() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Board().place(4,4,'X'));
    }
    @Test
    void placeThrowsForOutOfBoundValuesNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Board().place(-1,-1, 'X'));
    }

    @Test
    void placeDoesNotAllowPlacementOfEmpty() {
        var ZeroValueChar = (new char[1])[0]; // similar syntax as code in Board.class constructor
        var newBoard = new Board();
        newBoard.place(1,1,ZeroValueChar);
        assertFalse(newBoard.isCellEmpty(1,1));
    }

    @Test
    void newBoardIsNotFull() {
        assertFalse(new Board().isFull());
    }

    @Test
    void newBoardIsNotFullAfterOnePlacement() {
        var newBoard = new Board();
        newBoard.place(0,0,'X');
        assertFalse(newBoard.isFull());
    }

    @Test
    void newBoardIsFullAfterNinePlacements() {
        var newBoard = new Board();
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                newBoard.place(i,j,'X');
            }
        }
        assertTrue(newBoard.isFull());
    }

    @Test
    void clearShouldEmptifyCellAfterPlacement() {
        var newBoard = new Board();
        newBoard.place(1,1,'X');
        assertFalse(newBoard.isCellEmpty(1,1));
        newBoard.clear();
        assertTrue(newBoard.isCellEmpty(1,1));
    }

}
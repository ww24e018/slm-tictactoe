package at.technikum.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void playerInstanceReturnsCharOfConstruction_X() {
        assertEquals('X', new Player('X').getMarker());
    }

    @Test
    public void playerInstanceReturnsCharOfConstruction_O() {
        assertEquals('O', new Player('O').getMarker());
    }

    @Test
    public void playerInstanceReturnsCharOfConstruction_White_Circle() {
        assertEquals('◯', new Player('◯').getMarker());
    }

    @Test
    public void playerInstanceReturnsCharOfConstruction_Ballot() {
        assertEquals('✗', new Player('✗').getMarker());
    }

}
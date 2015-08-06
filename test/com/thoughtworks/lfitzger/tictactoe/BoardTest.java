package com.thoughtworks.lfitzger.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lfitzger on 8/6/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private final int player1 = 1;
    private final int player2 = 2;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldInsertXInNWCornerWhenUser1Enters1() {
        board.move(1, player1);
        assertEquals("X", board.grid.get(0));
    }

    @Test
    public void shouldInsertOInSWCornerWhenUser2Enters9() {
        board.move(9, player2);
        assertEquals("O", board.grid.get(8));
    }

    @Test
    public void shouldNotBeAvailableWhenTwoUsersSelectSamePosition() {
        board.move(2, player1);
        assertEquals(false, board.positionAvailable(2));
    }

    @Test
    public void shouldHaveNoOpenSpacesWhenBoardIsFull () {
        board.move(1, player1);
        board.move(2, player2);
        board.move(3, player1);
        board.move(4, player2);
        board.move(5, player1);
        board.move(6, player2);
        board.move(7, player1);
        board.move(8, player2);
        board.move(9, player1);
        board.move(9, player2);
        assertEquals(false, board.hasOpenSpaces());
        //verify(printStream).println(contains("Game is a draw"));

    }

}


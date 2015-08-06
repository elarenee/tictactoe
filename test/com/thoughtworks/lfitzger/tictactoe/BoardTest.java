package com.thoughtworks.lfitzger.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by lfitzger on 8/6/15.
 */
public class BoardTest {

    @Test
    public void shouldInsertXIntoFirstSquareWhenMoveIsOne() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        board.play(1, 1);
        assertEquals("X",board.grid.get(0));
    }
}
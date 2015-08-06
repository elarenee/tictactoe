package com.thoughtworks.lfitzger.tictactoe;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lfitzger on 8/6/15.
 */
public class BoardTest {

    @Test
    public void shouldInsertXInNWCornerWhenUser1Enters1() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        board.play(1, 1);
        assertEquals("X",board.grid.get(0));
    }

    @Test
    public void shouldInsertOInSWCornerWhenUser2Enters9() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        board.play(9, 2);
        assertEquals("O", board.grid.get(8));
    }
}
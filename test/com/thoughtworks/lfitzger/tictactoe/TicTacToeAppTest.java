package com.thoughtworks.lfitzger.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by lfitzger on 8/6/15.
 */
public class TicTacToeAppTest {

    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
    }

    @Test
    public void shouldDrawEmptyBoardWhenGameStarts() {
        TicTacToeApp ticTacToeApp = new TicTacToeApp(printStream, bufferedReader);
        ticTacToeApp.startGame();
        verify(printStream).println(contains(" |   | "));
    }

    @Test
    public void shouldAddXWhenUserEntersMove() throws IOException {
        TicTacToeApp ticTacToeApp = new TicTacToeApp(printStream, bufferedReader);
        ticTacToeApp.startGame();
        when(bufferedReader.readLine()).thenReturn("1");
        ticTacToeApp.getUsersMove();
        verify(printStream).println(contains("X"));
    }
}
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
    private TicTacToeApp ticTacToeApp;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        ticTacToeApp = new TicTacToeApp(printStream, bufferedReader);
        ticTacToeApp.startGame();
    }

    @Test
    public void shouldDrawEmptyBoardWhenGameStarts() {
        verify(printStream, times(3)).println(contains(" |   | "));
    }

    @Test
    public void shouldAddXWhenUserEntersMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        ticTacToeApp.getUsersMove();
        verify(printStream).println(contains("X"));
    }

    @Test
    public void shouldAddXInNWCornerWhenUserEnters1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        ticTacToeApp.getUsersMove();
        verify(printStream).println(contains("X |   | "));
    }

}
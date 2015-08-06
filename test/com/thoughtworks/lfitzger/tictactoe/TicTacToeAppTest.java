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
    private final int player1 = 1;
    private final int player2 = 2;

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
    public void shouldDisplayXWhenUser1EntersMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        ticTacToeApp.getUsersMove(1);
        verify(printStream).println(contains("X"));
    }

    @Ignore
    public void shouldRefuseMoveWhenPlayerChoosesUnavailablePosition() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "2");
        ticTacToeApp.getUsersMove(player1);
        ticTacToeApp.getUsersMove(player2);

        verify(printStream).println(contains("Location already taken"));
    }

}
package com.thoughtworks.lfitzger.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lfitzger on 8/6/15.
 */
public class TicTacToeApp {

    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public TicTacToeApp(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void startGame() {
        printStream.println("  |   |   \n" +
                "---------\n" +
                "  |   |   \n" +
                "---------\n" +
                "  |   |   ");
    }

    public void getUsersMove() throws IOException {
        printStream.println("Enter your move: ");
        int userInput = Integer.parseInt(bufferedReader.readLine());
        makeMove(userInput);
    }

    public void makeMove (int move) {
        printStream.println("X");
    }
}

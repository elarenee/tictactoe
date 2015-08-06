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
    private Board board;

    public TicTacToeApp(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        board = new Board(printStream);
    }

    public void startGame() {
        board.draw();
        //getUsersMove();
    }

    public void getUsersMove(int player) {

        printStream.println(String.format("Player %s, enter your move [1-9]: ", player));
        int move = 0;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        board.play(move, player);
        printStream.println("This is the current tic-tac-toe board: ");
        board.draw();
    }

}

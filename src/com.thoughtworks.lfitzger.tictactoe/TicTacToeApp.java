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
    }

    public void getUsersMove(int player) { // this method is way too long!!!

        printStream.println(String.format("Player %s, enter your move [1-9]: ", player));
        int position = 0;
        try {
            position = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(board.positionAvailable(position)) {
            board.move(position, player);
        }
        else {
            printStream.println("Location already taken");
        }


        printStream.println("This is the current tic-tac-toe board: ");
        board.draw();
    }

}

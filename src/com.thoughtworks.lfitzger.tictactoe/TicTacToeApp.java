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
    private boolean waitingForValidMove;
    private int currentPlayer;

    public TicTacToeApp(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        board = new Board(printStream);
        waitingForValidMove = true;
        currentPlayer = 1;
    }

    public void playGame() {
        board.draw();

        while(waitingForValidMove && board.hasOpenSpaces()) {
            getUsersMove(currentPlayer);
        }

    }

    public void getUsersMove(int player) { // this method is way too long!!!
        currentPlayer = player;

        printStream.println(String.format("Player %s, enter your move [1-9]: ", currentPlayer));
        int position = 0;
        try {
            position = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(board.positionAvailable(position)) {
            board.move(position, currentPlayer);
            /*if(currentPlayer == 1) {
                currentPlayer = 2;
            }
            else {
                currentPlayer = 1;
            }*/
            waitingForValidMove = false;
        }
        else {
            printStream.println("Location already taken");
            waitingForValidMove = true;
        }

        board.draw();
    }

}

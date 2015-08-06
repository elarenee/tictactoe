package com.thoughtworks.lfitzger.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lfitzger on 8/6/15.
 */
public class Main {

    public static void main (String[] args) {
        TicTacToeApp ticTacToeApp = new TicTacToeApp(System.out, new BufferedReader(new InputStreamReader(System.in)));
        ticTacToeApp.startGame();
    }
}

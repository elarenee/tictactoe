package com.thoughtworks.lfitzger.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lfitzger on 8/6/15.
 */
public class Board {

    public List<String> grid;
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.grid = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            grid.add(" ");
        }
        this.printStream = printStream;
    }

    public void play(int move, int player) {
        String symbol;
        if (player == 1) {
            symbol = "X";
        }
        else
            symbol = "O";

        grid.set(move - 1, symbol);
    }

    public void draw() {
        int idx = 0;
        for(int lineCount = 1; lineCount <= 5; lineCount++) {
            if(lineCount % 2 == 0) {
                printStream.println("---------");
            }
            else {
                printStream.println(String.format("%s | %s | %s", grid.get(idx++), grid.get(idx++), grid.get(idx++)));
            }
        }
    }

}

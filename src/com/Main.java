/*
 * FILENAME:        Main.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com;

import com.shevtsod.Simulator.BoardManager;
import java.util.Scanner;

/**
 * <p>
 *     The primary entry point for the program
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Main {
    /**
     * The primary entry point for the program.
     * Currently, this method simply passes control of the program to a
     * BoardManager object after it is initialized with an x,y board size.
     * The current version does not use parameters passed by args.
     * @param args Arguments from command line
     */
    public static void main(String[] args) {
        int     sizeX = 0,
                sizeY = 0;

        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Enter number of horizontal cells: ");
        } while(!input.hasNextInt());
        sizeX = input.nextInt();

        do {
            System.out.print("Enter number of vertical cells: ");
        } while(!input.hasNextInt());
        sizeY = input.nextInt();

        //Pass control of the program to the BoardManager
        BoardManager mainBM = new BoardManager(sizeX, sizeY);
    }
}

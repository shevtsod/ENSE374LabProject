package com;
/*
 * FILENAME:        Main.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

import com.shevtsod.Simulator.BoardManager;

import java.util.InputMismatchException;
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
    public static void main(String args[]) {
        int     sizeX = 0,
                sizeY = 0,
                min = 3,
                max = 10;
        boolean correctInput;
        
    	//Print welcome screen.
        //Generated using http://patorjk.com/software/taag/
    	System.out.println(
    			"\n" +
    			"*****************************************************************\n" +
    			"    / \\   _ __ (_)_ __ ___   __ _| / ___|(_)_ __ ___  \n" +
    			"   / _ \\ | '_ \\| | '_ ` _ \\ / _` | \\___ \\| | '_ ` _ \\ \n" +
    			"  / ___ \\| | | | | | | | | | (_| | |___) | | | | | | |\n" +
    			" /_/   \\_\\_| |_|_|_| |_| |_|\\__,_|_|____/|_|_| |_| |_|\n" +
    			"Animal Habitat Simulator created by Daniel Shevtsov for ENSE 374" +
    			"\n*****************************************************************\n"
    			);

        Scanner input = new Scanner(System.in, "UTF-8");

        // Get number of horizontal cells from min to max from keyboard input
        System.out.println("Enter number of horizontal cells (" + min + " to " + max + "): ");
        correctInput = false;
        do {
            System.out.print("\tINPUT: ");
            try {
                sizeX = input.nextInt();
                if(sizeX >= min && sizeX <= max) {
                    correctInput = true;
                } else {
                    System.out.println(
                            "ERROR: The value given for number of horizontal cells " +
                                    "must be between 3 and 10"
                    );
                    input.nextLine();
                }
            } catch(InputMismatchException e) {
                System.out.println(
                        "ERROR: The value given for number of horizontal cells " +
                                "must be between 3 and 10"
                );
                input.nextLine();
            }
        } while(!correctInput);

        // Get number of vertical cells from min to max from keyboard input
        System.out.println("Enter number of vertical cells (" + min + " to " + max + "): ");
        correctInput = false;
        do {
            System.out.print("\tINPUT: ");
            try {
                sizeY = input.nextInt();
                if(sizeY >= min && sizeY <= max) {
                    correctInput = true;
                } else {
                    System.out.println(
                            "ERROR: The value given for number of vertical " +
                                    "cells must be between " + min + " and " + max
                    );
                    input.nextLine();
                }
            } catch(InputMismatchException e) {
                System.out.println(
                        "ERROR: The value given for number of vertical cells " +
                                "must be between " + min + " and " + max
                );
                input.nextLine();
            }
        } while(!correctInput);

        System.out.println(
                "Starting simulator with board of size (" +
                sizeX + " x " + sizeY + ")"
        );

        BoardManager mainBM = new BoardManager(sizeX, sizeY);
        //Pass control of the program to the BoardManager
        mainBM.simulate();
        
        input.close();
    }
}

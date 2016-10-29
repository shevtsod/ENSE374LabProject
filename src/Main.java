/*
 * FILENAME:        Main.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

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
            if(input.hasNextInt()) {
                sizeX = input.nextInt();
            } else {
                input.nextLine();
            }
        } while(sizeX == 0);

        do {
            System.out.print("Enter number of vertical cells: ");
            if(input.hasNextInt()) {
                sizeY = input.nextInt();
            } else {
                input.nextLine();
            }
        } while(sizeY == 0);

        //Pass control of the program to the BoardManager
        BoardManager mainBM = new BoardManager(sizeX, sizeY);
    }
}

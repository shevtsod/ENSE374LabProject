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

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of horizontal cells: ");
        correctInput = false;
        do {
        	System.out.print("INPUT: ");
            if(input.hasNextInt()) {
                sizeX = input.nextInt();
                if(sizeX >= 5 && sizeX <= 20) {
                	correctInput = true;
                } else {
                	System.out.println(
                			"ERROR: The value given for number of horizontal cells " +
                			"must be between 0 and 20"
                			);
                }
            } else {
            	System.out.println(
            			"ERROR: Invalid input for number of horizontal cells"
            			);
                input.nextLine();
            }
        } while(!correctInput);

        System.out.println("Enter number of vertical cells: ");
        correctInput = false;
        do {
        	System.out.print("INPUT: ");
            if(input.hasNextInt()) {
                sizeY = input.nextInt();
                if(sizeY >= 5 && sizeX <= 20) {
                	correctInput = true;
                } else {
                	System.out.println(
                			"ERROR: The value given for number of vertical cells" +
                			"must be between 0 and 20"
                			);
                }
            } else {
            	System.out.println(
            			"ERROR: Invalid input for number of vertical cells"
            			);
                input.nextLine();
            }
        } while(!correctInput);

        //Pass control of the program to the BoardManager
        BoardManager mainBM = new BoardManager(sizeX, sizeY);
        
        input.close();
    }
}

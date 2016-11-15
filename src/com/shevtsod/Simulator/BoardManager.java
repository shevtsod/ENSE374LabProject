package com.shevtsod.Simulator;

import com.shevtsod.Organism.ConcreteClasses.Animals.*;
import com.shevtsod.Organism.ConcreteClasses.Vegetation.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.shevtsod.Organism.*;
import com.shevtsod.Organism.Animal.*;
import com.shevtsod.Organism.Vegetation.*;

/**
 * <p>
 *     Controls the simulation loop for the animal habitat simulator.
 *     Randomly places various organisms on a board of any size and
 *     simulates interactions between the various organisms on a turn-by-turn
 *     basis.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class BoardManager {
    private int sizeX,
                sizeY,
                numOrganisms,
                organismsLeftToGen,
                simDay;
    private Organism[][] board;

    /**
     * Creates an empty board of size given by sizeX (# of horizontal cells)
     * and sizeY ($ of vertical cells)
     * @param sizeX Number of horizontal cells
     * @param sizeY Number of vertical cells
     */
    public BoardManager(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        numOrganisms = 0;
        organismsLeftToGen = 0;
        simDay = 0;
        board = new Organism[sizeX][sizeY];
    }


    /**
     * Adds any class that implements Organism to the board of organisms in
     * the simulation. Returns false if organism cannot be added.
     * @param targetOrganism An object inheriting from Organism
     * @return true if Organism was added successfully
     * false if an error occurred (i.e. space is already occupied)
     */
    public boolean addOrganism(Organism targetOrganism) {
    	// If there is already an organism in this cell, return false
    	if(board[targetOrganism.getPosX()][targetOrganism.getPosY()] != null) {
    		return false;
    	}

    	// Otherwise, add this organism to the requested cell
    	board[targetOrganism.getPosX()][targetOrganism.getPosY()] = targetOrganism;
        numOrganisms++;
        return true;
    }


    /**
     * Helper function to create the Organism with the specified TypeOrganism
     * with random x and y coordinates and add to the board.
     * @param organism TypeOrganism to create an Organism of
     */
    private void randomlyPlaceOrganism(TypeOrganism organism) {
        Random rand = new Random();
        if(organismsLeftToGen <= 0)
            return;

        boolean addedSuccessfully;
        switch(organism) {
            case Grass:
                //Add a Grass
                do {
                    addedSuccessfully = addOrganism(new Grass(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Shrub:
                //Add a Shrub
                do {
                    addedSuccessfully = addOrganism(new Shrub(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Tree:
                //Add a Tree
                do {
                    addedSuccessfully = addOrganism(new Tree(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Bluejay:
                //Add a Bluejay
                do {
                    addedSuccessfully = addOrganism(new Bluejay(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Caterpillar:
                //Add a Caterpillar
                do {
                    addedSuccessfully = addOrganism(new Caterpillar(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Deer:
                //Add a Deer
                do {
                    addedSuccessfully = addOrganism(new Deer(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Fox:
                //Add a Fox
                do {
                    addedSuccessfully = addOrganism(new Fox(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Wolf:
                //Add a Wolf
                do {
                    addedSuccessfully = addOrganism(new Wolf(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Hawk:
                //Add a Hawk
                do {
                    addedSuccessfully = addOrganism(new Hawk(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Grasshopper:
                //Add a Grasshopper
                do {
                    addedSuccessfully = addOrganism(new Grasshopper(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Mouse:
                //Add a Mouse
                do {
                    addedSuccessfully = addOrganism(new Mouse(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Rabbit:
                //Add a Rabbit
                do {
                    addedSuccessfully = addOrganism(new Rabbit(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;
            case Squirrel:
                //Add a Squirrel
                do {
                    addedSuccessfully = addOrganism(new Squirrel(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                break;

            default:
                break;
        }
        organismsLeftToGen--;
    }


    /**
     * Helper function for input of number of organisms to add to simulator.
     * Creates the number of objects requested and randomly scatters them around
     * the board.
     * @param input A Scanner object that processes the input
     * @param organism The OrganismType to request input
     * @return The int that was entered in the console as input
     */
    private int processOrganismInput(Scanner input, TypeOrganism organism) {
        int nUserInput = 0;
        boolean correctInput;
        System.out.println("You have " + organismsLeftToGen + " organisms left to add");
        System.out.println("Enter -2 to start simulation, -1 to quit program");
        System.out.println("Enter number of " + organism.toString() + " objects to add:");
        correctInput = false;
        do {
            System.out.print("\tINPUT: ");
            try {
                nUserInput = input.nextInt();
                if(nUserInput >= -2 && nUserInput <= organismsLeftToGen) {
                    correctInput = true;
                } else {
                    System.out.println("ERROR: You can only add up to " + organismsLeftToGen +
                            " more organisms");
                    input.nextLine();
                }
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                input.nextLine();
            }
        } while(!correctInput);
        if(nUserInput == -2 || nUserInput == -1) {
            return nUserInput;
        }

        //Create objects and place them on the board
        for(int i = 0; i < nUserInput; i++) {
            randomlyPlaceOrganism(organism);
        }
        System.out.println("Successfully created " + nUserInput + " " + organism.toString() + " objects");
        return nUserInput;
    }


    /**
     * Function as 'main()' for the program. 
     * The program logic and simulation loop are processed here.
     */
    public void simulate() {
        int nUserInput = 0;
    	boolean correctInput;
    	
    	Scanner input = new Scanner(System.in, "UTF-8");
    	
    	// Allow user to either use default setup, or configure the simulation.
    	System.out.println("Press 0 for default simulation settings, 1 to configure settings");
        correctInput = false;
        do {
            System.out.print("\tINPUT: ");
            try {
                nUserInput = input.nextInt();
                if(nUserInput == 0 || nUserInput == 1) {
                    correctInput = true;
                } else {
                    System.out.println("ERROR: Invalid action");
                    input.nextLine();
                }
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid action");
                input.nextLine();
            }
        } while(!correctInput);

        //Generate a random number of Organisms within bounds
        Random rand = new Random();
        int maxOrganisms = sizeX * sizeY;
        if(nUserInput == 1) {
            //Allow generating as many Organisms as there are cells on the board.
            organismsLeftToGen = sizeX * sizeY;
            // Enter configuration menu
            System.out.println("*** CONFIGURATION MENU ***");
            for(TypeOrganism i : TypeOrganism.values()) {
                nUserInput = processOrganismInput(input, i);
                if(nUserInput == -2 || nUserInput == -1 || organismsLeftToGen == 0) {
                    break;
                }
            }
            if(organismsLeftToGen <= 0) {
                System.out.println("You have 0 organisms left to add. Starting simulation:");
            }
        } else {
            //Generate between [maxOrganisms/2 to maxOrganisms] organisms
            organismsLeftToGen = rand.nextInt(maxOrganisms / 2 + 1) + (maxOrganisms / 2);
            // Load defaults
            System.out.println("Randomly populating board using default simulation settings");
            while(organismsLeftToGen > 0) {
                for (TypeOrganism i : TypeOrganism.values()) {
                    if (organismsLeftToGen <= 0)
                        break;
                    else
                        randomlyPlaceOrganism(i);
                }
            }
        } // End if-else

        if(nUserInput == -1) {
            input.close();
            System.out.println("Program completed successfully. Exiting");
            return;
        }

        // Output legend with all the icons used in the board
        System.out.println("*** LEGEND ***");
        for(TypeOrganism i : TypeOrganism.values()) {
            System.out.println("\t" + TypeOrganism.getIcon(i) + "\t-\t" + i.toString());
        }
        System.out.println();

        // Begin the simulation
        System.out.println("Starting simulation with " + numOrganisms + " organisms\n");
        printBoard();
        simDay++;

        // Main simulation loop
        nUserInput = 1;
        while(nUserInput != 0) {
            //If user input -1, skip the input portion (aka automatically run to completion)
            if(nUserInput != -1) {
                System.out.println("Press 0 to exit the program. Press -1 to auto-run simulation.\n" +
                        "Press any other key to simulate a day");
                System.out.print("\tINPUT: ");
                try {
                    nUserInput = input.nextInt();
                } catch (InputMismatchException e) {
                    nUserInput = 1;
                    input.nextLine();
                }
                if (nUserInput == 0) {
                    break;
                }
            }

            //Move all animals, process hunger, print log, then print board
            //If iterateThroughBoard returned false, end simulation
            nUserInput = iterateThroughBoard() ? nUserInput : 0;
            System.out.println();
            printBoard();

            if(numOrganisms == 0 || nUserInput == 0)
                break;

            //Record how many simulation days have passed
            simDay++;
            System.out.println("*****************************************************************");
        }

        // If reach here, simulation ended. Close program
        System.out.println(
                "Simulation ended successfully - nothing left to simulate\n" +
                "Simulation ended on day " + simDay
        );

        input.close();
        System.out.println("Program completed successfully. Exiting");

    }   //End simulate()

    /**
     * Helper function to iterate through the board, moving  objects and
     * processing the logic of Organisms eating other Organisms or dying of
     * starvation. Also checks whether the simulation can continue or if it ended
     * (i.e. if board is empty or no animals remain)
     * Outputs a log of what happened during the iteration.
     * Assuming that one iteration is 'a day' of simulation.
     * @return true if simulation can continue, false if simulation ended
     */
    private boolean iterateThroughBoard() {
        System.out.println("*** SIMULATION LOG - DAY " + simDay + " ***");

        //If no Organisms at all, simulation is over.
        if(numOrganisms <= 0) {
            System.out.println("No organisms left");
            return false;
        }

        boolean noAnimalsLeft = true;

        /*
         * Iterate through the 2D array representing the board
         * First, check if the cell is empty, and skip it if so.
         * Check if the Organism is alive, and remove it otherwise.
         * For each cell, move the Organism to a new random location within
         * the bounds of its movement (speed, borders of board).
         * Next, check if the destination cell is empty.
         * *If it is empty, place this Organism into this new empty cell
          * and increment hunger.
         * *If it is occupied, check if any of the two Organisms eats one another
         *      *If so, eat Organism and decrement hunger
         *      *If not, move this Organism again, repeat until it finds a free cell
         *       or an Organism it can eat or be eaten by
         * If at the end of the iteration, noAnimalsLeft is still true, return false
         */

        for(int i = 0; i < sizeY; i++) {
            //Vertical (rows)
            for(int j = 0; j < sizeX; j++) {
                //Horizontal (individual row)
                if(board[i][j] == null)
                    //No Organism in this cell
                    continue;

                if(
                        noAnimalsLeft &&
                        board[i][j].getOrganism() != TypeOrganism.Grass &&
                        board[i][j].getOrganism() != TypeOrganism.Tree &&
                        board[i][j].getOrganism() != TypeOrganism.Shrub
                        ) {
                    noAnimalsLeft = false;
                }

                if (!board[i][j].isAlive()) {
                    //Organism in this cell died
                    System.out.println(
                            board[i][j].getOrganism().toString() +
                            " at (" + i + " , " + j + ") has died of starvation"
                    );
                    board[i][j] = null;
                    numOrganisms--;
                } else {
                    //Organism is alive, move it to a new cell
                    boolean moveSuccessful = false;
                    Organism org = board[i][j];
                    int oldPosX = org.getPosX();
                    int oldPosY = org.getPosY();

                    while(!moveSuccessful) {
                        org.move(sizeX, sizeY);
                        if(org.getPosX() == oldPosX && org.getPosY() == oldPosY ) {
                            //If moved 0 cells, move was successful (i.e. vegetation)
                            moveSuccessful = true;
                        } else if (board[org.getPosX()][org.getPosY()] == null) {
                            //If moved to an empty cell
                            System.out.println(
                                    org.getOrganism().toString() + " at (" + oldPosX
                                    + " , " + oldPosY + ") moves to (" +
                                    org.getPosX() + " , " + org.getPosY() + ")"
                            );
                            board[org.getPosX()][org.getPosY()] = org;
                            board[oldPosX][oldPosY] = null;
                            org.addHunger();
                            moveSuccessful = true;
                        } else {
                            //Moved to an occupied cell
                            if(org.eats(board[org.getPosX()][org.getPosY()].getOrganism())) {
                                System.out.println(
                                        org.getOrganism().toString() + " at (" + oldPosX
                                                + " , " + oldPosY + ") moves to (" +
                                                org.getPosX() + " , " + org.getPosY() + ")"
                                );
                                //If org eats the Organism already in this cell, remove that
                                //organism and reduce this one's hunger.
                                System.out.println(
                                        org.getOrganism().toString() + " at ("  +
                                                org.getPosX() + " , " + org.getPosY() +
                                                ") eats " +
                                                board[org.getPosX()][org.getPosY()].getOrganism().toString() +
                                                " in the same cell"
                                );
                                board[org.getPosX()][org.getPosY()] = org;
                                board[oldPosX][oldPosY] = null;
                                org.reduceHunger();
                                moveSuccessful = true;
                                numOrganisms--;
                            } else if(board[org.getPosX()][org.getPosY()].eats(org.getOrganism())) {
                                System.out.println(
                                        org.getOrganism().toString() + " at (" + oldPosX
                                                + " , " + oldPosY + ") moves to (" +
                                                org.getPosX() + ", " + org.getPosY() + ")"
                                );
                                //If Organism already in this cell eats org, remove org and
                                //reduce the hunger of the Organism in the cell
                                System.out.println(
                                        board[org.getPosX()][org.getPosY()].getOrganism().toString() +
                                                " at ("  + org.getPosX() + " , " + org.getPosY() +
                                                ") eats " +  org.getOrganism().toString()
                                                + " in the same cell"
                                );
                                board[org.getPosX()][org.getPosY()].reduceHunger();
                                org = null;
                                moveSuccessful = true;
                                numOrganisms--;
                            }
                        } // end else
                        // If moveSuccessful is still false here, move again
                    } //end while(!moveSuccessful)
                } //end if-else
            } //end for j
        } //end for i
        System.out.println("There are " + numOrganisms + " Organisms left");
        return !noAnimalsLeft;
    }

    /**
     * Prints the current board visually to the console. Can only be
     * called by the class.
     */
    private void printBoard() {
        System.out.println("*** SIMULATION BOARD - DAY " + simDay + " ***");

        // Print first line (divider)
        for(int i = 0; i < sizeX * 2 + 1; i++) {
            if(i%2 != 0) {
                // If i is odd, print a divider -
                System.out.print(" - ");
            } else {
                // Otherwise, print a divider
                System.out.print(" . ");
            }
        }
        System.out.println();

        // Iterate through the board and print each cell separated by lines
        for(int i = 0; i < sizeY * 2; i++) {
            // Vertical (rows)
            // Print an initial divider
            System.out.print(" . ");
            for(int j = 0; j < sizeX * 2 - 1; j++) {
                // Horizontal (individual row)
                if(j % 2 != 0 && i %2 != 0) {
                    // If j and i are odd, print a divider
                    System.out.print(" . ");
                } else if(j % 2 != 0) {
                    // If j is odd, print a divider |
                    System.out.print(" | ");
                } else if(i % 2 != 0) {
                    // If i is odd, print a divider -
                    System.out.print(" - ");
                } else {
                    // Otherwise, print value in this cell
                    if(board[j / 2][i / 2] == null) {
                        // If no Organism here, print empty space
                        System.out.print("   ");
                    } else {
                        // If Organism here, print icon for it
                        System.out.print(" " + TypeOrganism.getIcon(board[j/2][i/2].getOrganism()) +" ");
                    }
                }
            }
            // Print a final divider
            System.out.println(" . ");
        }
        System.out.println();
    } //End printBoard()
}

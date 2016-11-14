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
    private int sizeX;
    private int sizeY;
    private int numOrganisms;
    private int organismsLeftToGen;
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
        --organismsLeftToGen;
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
                    System.out.println("ERROR: You can only add up to " + organismsLeftToGen + " more organisms");
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
            organismsLeftToGen = rand.nextInt(maxOrganisms / 2 + 1) + (maxOrganisms / 2 + 1);
            // Load defaults
            System.out.println("Randomly populating board using default simulation settings");
            for(TypeOrganism i : TypeOrganism.values()) {
                if(organismsLeftToGen <= 0)
                    break;
                else
                    randomlyPlaceOrganism(i);
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
        System.out.println("Starting simulation with " + numOrganisms + " organisms");
        printBoard();

        // Main simulation loop
        nUserInput = 1;
        while(nUserInput != 0) {
            System.out.println("Press 0 to exit the program. Press any other key to simulate a day");
            System.out.print("\tINPUT: ");
            try {
                nUserInput = input.nextInt();
            } catch (InputMismatchException e) {
                nUserInput = 1;
            }
            if (nUserInput == 0) {
                System.out.println("Simulation ended successfully - terminated by user");
                break;
            }

            //Move all animals, process hunger, print log, then print board
            //If iterateThroughBoard returned false, end simulation
            nUserInput = iterateThroughBoard() ? 1 : 0;
            printBoard();

            if(nUserInput == 0)
                System.out.println("Simulation ended successfully - nothing left to simulate");
        }

        // If reach here, simulation ended. Close program

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
        //If no Organisms at all, simulation is over.
        if(numOrganisms <= 0) {
            return false;
        }

        boolean noAnimalsLeft = true;
        return true;
    }

    /**
     * Prints the current board visually to the console. Can only be
     * called by the class.
     */
    private void printBoard() {
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

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
    private int freeCells;
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
        freeCells = sizeX * sizeY;
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
            System.out.print("INPUT: ");
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
        //Generate between [maxOrganisms/2 to maxOrganisms] organisms
        int organismsLeftToGen = rand.nextInt(maxOrganisms / 2 + 1) + (maxOrganisms / 2 + 1);
        if(nUserInput == 1) {
            // Enter configuration menu
            // TODO: Add configuration menu
        } else {
            // Load defaults
            System.out.println("Randomly populating board using default simulation settings");
            while(organismsLeftToGen != 0) {
                boolean addedSuccessfully;
                //Add a Grass
                do {
                    addedSuccessfully = addOrganism(new Grass(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Shrub
                do {
                    addedSuccessfully = addOrganism(new Shrub(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Tree
                do {
                    addedSuccessfully = addOrganism(new Tree(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Bluejay
                do {
                    addedSuccessfully = addOrganism(new Bluejay(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Caterpillar
                do {
                    addedSuccessfully = addOrganism(new Caterpillar(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Deer
                do {
                    addedSuccessfully = addOrganism(new Deer(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Fox
                do {
                    addedSuccessfully = addOrganism(new Fox(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Wolf
                do {
                    addedSuccessfully = addOrganism(new Wolf(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Hawk
                do {
                    addedSuccessfully = addOrganism(new Hawk(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Grasshopper
                do {
                    addedSuccessfully = addOrganism(new Grasshopper(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Mouse
                do {
                    addedSuccessfully = addOrganism(new Mouse(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Rabbit
                do {
                    addedSuccessfully = addOrganism(new Rabbit(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
                //Add a Squirrel
                do {
                    addedSuccessfully = addOrganism(new Squirrel(rand.nextInt(sizeX), rand.nextInt(sizeY)));
                } while (!addedSuccessfully);
                if(--organismsLeftToGen == 0)
                    break;
            }
        }

        // Main simulation loop
        // TODO: Add simulation loop
        printBoard();

        // If reach here, simulation ended. Close program

        input.close();
        System.out.println("Program completed successfully. Exiting.");

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
        System.out.println("");

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
                        String organismIcon;
                        switch (board[j / 2][i / 2].getOrganism()) {
                            case Bluejay:
                                organismIcon = " B ";
                                break;
                            case Caterpillar:
                                organismIcon = " C ";
                                break;
                            case Deer:
                                organismIcon = " D ";
                                break;
                            case Fox:
                                organismIcon = " F ";
                                break;
                            case Wolf:
                                organismIcon = " W ";
                                break;
                            case Hawk:
                                organismIcon = " H ";
                                break;
                            case Grasshopper:
                                organismIcon = " G ";
                                break;
                            case Mouse:
                                organismIcon = " M ";
                                break;
                            case Rabbit:
                                organismIcon = " R ";
                                break;
                            case Squirrel:
                                organismIcon = " S ";
                                break;
                            case Grass:
                                organismIcon = " g ";
                                break;
                            case Shrub:
                                organismIcon = " s ";
                                break;
                            case Tree:
                                organismIcon = " t ";
                                break;
                            default:
                                organismIcon = " ? ";
                                break;
                        }
                        System.out.print(organismIcon);
                    }
                }
            }
            // Print a final divider
            System.out.println(" . ");
        }
        System.out.println("");
    }
}

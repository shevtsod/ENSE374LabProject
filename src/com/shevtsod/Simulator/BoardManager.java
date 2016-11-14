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
        System.out.println("Enter 0 to start simulation, -1 to quit program");
        System.out.println("Enter number of " + organism.toString() + " objects to add:");
        correctInput = false;
        do {
            System.out.print("INPUT: ");
            try {
                nUserInput = input.nextInt();
                if(nUserInput >= -1 && nUserInput <= organismsLeftToGen) {
                    correctInput = true;
                } else {
                    System.out.println("ERROR: Invalid input");
                    input.nextLine();
                }
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                input.nextLine();
            }
        } while(!correctInput);
        if(nUserInput == -1 || nUserInput == 0) {
            return nUserInput;
        }

        //Create objects and place them on the board
        for(int i = 0; i < nUserInput; i++) {
            randomlyPlaceOrganism(organism);
        }
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
        if(nUserInput == 1) {
            //Allow generating as many Organisms as there are cells on the board.
            organismsLeftToGen = sizeX * sizeY;
            // Enter configuration menu
            System.out.println("*** CONFIGURATION MENU ***");
            // TODO: Add configuration menu
            while(organismsLeftToGen != 0) {
                //Add Grass
                nUserInput = processOrganismInput(input, TypeOrganism.Grass);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Shrub
                nUserInput = processOrganismInput(input, TypeOrganism.Shrub);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Tree
                nUserInput = processOrganismInput(input, TypeOrganism.Tree);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Bluejay
                nUserInput = processOrganismInput(input, TypeOrganism.Bluejay);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Caterpillar
                nUserInput = processOrganismInput(input, TypeOrganism.Caterpillar);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Deer
                nUserInput = processOrganismInput(input, TypeOrganism.Deer);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Fox
                nUserInput = processOrganismInput(input, TypeOrganism.Fox);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Wolf
                nUserInput = processOrganismInput(input, TypeOrganism.Wolf);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Hawk
                nUserInput = processOrganismInput(input, TypeOrganism.Hawk);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Grasshopper
                nUserInput = processOrganismInput(input, TypeOrganism.Grasshopper);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Mouse
                nUserInput = processOrganismInput(input, TypeOrganism.Mouse);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Rabbit
                nUserInput = processOrganismInput(input, TypeOrganism.Rabbit);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
                //Add Squirrel
                nUserInput = processOrganismInput(input, TypeOrganism.Squirrel);
                if(nUserInput == -1 || nUserInput == 0 || organismsLeftToGen == 0) {
                    break;
                }
            } // End while
        } else {
            //Generate between [maxOrganisms/2 to maxOrganisms] organisms
            organismsLeftToGen = rand.nextInt(maxOrganisms / 2 + 1) + (maxOrganisms / 2 + 1);
            // Load defaults
            System.out.println("Randomly populating board using default simulation settings");
            while(organismsLeftToGen != 0) {
                //Add Shrub
                randomlyPlaceOrganism(TypeOrganism.Shrub);
                //Add Tree
                randomlyPlaceOrganism(TypeOrganism.Tree);
                //Add Bluejay
                randomlyPlaceOrganism(TypeOrganism.Bluejay);
                //Add Caterpillar
                randomlyPlaceOrganism(TypeOrganism.Caterpillar);
                //Add Deer
                randomlyPlaceOrganism(TypeOrganism.Deer);
                //Add Fox
                randomlyPlaceOrganism(TypeOrganism.Fox);
                //Add Wolf
                randomlyPlaceOrganism(TypeOrganism.Wolf);
                //Add Hawk
                randomlyPlaceOrganism(TypeOrganism.Hawk);
                //Add Grasshopper
                randomlyPlaceOrganism(TypeOrganism.Grasshopper);
                //Add Mouse
                randomlyPlaceOrganism(TypeOrganism.Mouse);
                //Add Rabbit
                randomlyPlaceOrganism(TypeOrganism.Rabbit);
                //Add Squirrel
                randomlyPlaceOrganism(TypeOrganism.Squirrel);
            } // End while
        } // End if-else

        if(nUserInput == -1) {
            input.close();
            System.out.println("Program completed successfully. Exiting.");
            return;
        }

        // Main simulation loop
        // TODO: Add simulation loop
        printBoard();

        // If reach here, simulation ended. Close program

        input.close();
        System.out.println("Program completed successfully. Exiting.");

    }   //End simulate()

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
    } //End printBoard()
}

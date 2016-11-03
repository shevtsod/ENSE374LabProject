package com.shevtsod.Simulator;

import com.shevtsod.Organism.ConcreteClasses.Animals.*;
import com.shevtsod.Organism.ConcreteClasses.Vegetation.*;

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

        //Pass program control to simulate() function
        simulate();
    }

    /**
     * Adds any class that implements Organism to the board of organisms in
     * the simulation. Returns false if organism cannot be added.
     * @param targetOrganism An object inheriting from Organism
     * @return true if Organism was added
     */
    public boolean addOrganism(Organism targetOrganism) {
    	//If there is already an organism in this cell, return false.
    	if(board[targetOrganism.getPosX()][targetOrganism.getPosY()] != null) {
    		return false;
    	}
    	
    	board[targetOrganism.getPosX()][targetOrganism.getPosY()] = targetOrganism;
        numOrganisms++;
        return true;
    }

    /**
     * Function as 'main()' for the program. 
     * The program logic and simulation loop are processed here.
     */
    public void simulate() {
    	char userInput;
    	boolean correctInput;
    	
    	Scanner input = new Scanner(System.in);
    	
    	//Allow user to either use default setup, or configure the simulation.
    	System.out.println("Press 0 for default simulation settings, 1 to configure settings");
    	correctInput = false;
    	do {
    		System.out.print("INPUT: ");
    		userInput = input.nextLine().charAt(0);
    		if(userInput == '0' || userInput == '1') {
    			correctInput = true;
    		} else {
    			System.out.println("ERROR: Invalid action");
    		}
    	} while(!correctInput);
    	
        //TODO: Remove debug comments, implement simulate()
        //Test that everything works up to this point
        System.out.println("\nInitialized BoardManager");
        System.out.println("sizeX: " + sizeX);
        System.out.println("sizeY: " + sizeY);
        System.out.println("numOrganisms: " + numOrganisms);
        System.out.println("board[0][0]: " + board[0][0]);
        System.out.println("board[1][1]: " + board[1][1] + "\n");

        Animal temp = new Bluejay(0, 0);
        addOrganism(temp);
        System.out.println("\nAdded Bluejay");
        System.out.println("TypeOrganism: " + temp.getOrganism());
        System.out.println("TypeDiet: " + temp.getDiet());
        System.out.println("Position: " + temp.getPosX() + " " + temp.getPosY());
        System.out.println("numOrganisms: " + numOrganisms);
        System.out.println("board[0][0]: " + board[0][0] + "\n");

        Vegetation temp2 = new Shrub(1, 1);
        addOrganism(temp2);
        System.out.println("\nAdded Shrub");
        System.out.println("TypeOrganism: " + temp2.getOrganism());
        System.out.println("Position: " + temp2.getPosX() + " " + temp2.getPosY());
        System.out.println("numOrganisms: " + numOrganisms);
        System.out.println("board[1][1]: " + board[1][1] + "\n");
        
        temp2 = new Shrub(1, 1);
        boolean success = addOrganism(temp2);
        if(!success) {
        	System.out.println("Could not add new Shrub. Space is already used.");
        }

        input.close();
        System.out.println("Exiting.");

    }

    /**
     * Prints the current board visually to the console. Can only be
     * called by the class.
     */
    private void printBoard() {
        //TODO: Add printBoard()
    }
}

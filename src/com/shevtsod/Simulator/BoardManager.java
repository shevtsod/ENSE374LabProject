package com.shevtsod.Simulator;

import com.shevtsod.Organism.ConcreteClasses.Animals.*;
import com.shevtsod.Organism.ConcreteClasses.Vegetation.*;
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

    public void simulate() {
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
        System.out.println("board[0][0]: " + board[0][0]);

        Vegetation temp2 = new Shrub(1, 1);
        addOrganism(temp2);
        System.out.println("\nAdded Shrub");
        System.out.println("TypeOrganism: " + temp2.getOrganism());
        System.out.println("Position: " + temp2.getPosX() + " " + temp2.getPosY());
        System.out.println("numOrganisms: " + numOrganisms);
        System.out.println("board[1][1]: " + board[1][1]);

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

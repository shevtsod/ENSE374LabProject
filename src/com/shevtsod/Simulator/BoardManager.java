package com.shevtsod.Simulator;

import com.shevtsod.Organism.Organism;

import java.util.LinkedList;
import java.util.List;

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
    private int sizeX, sizeY, numOrganisms;
    private List listOrganisms;

    /**
     * Creates an empty board of size given by sizeX (# of horizontal cells)
     * and sizeY ($ of vertical cells)
     * @param sizeX Number of horizontal cells
     * @param sizeY Number of vertical cells
     */
    public BoardManager(int sizeX, int sizeY) {
        listOrganisms = new LinkedList();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        numOrganisms = 0;

        //Pass program control to simulate() function
        simulate();
    }

    /**
     * Adds any class that implements Organism to the list of organisms in
     * the simulation.
     * @param targetOrganism An object inheriting from Organism
     */
    public void addOrganism(Organism targetOrganism) {
        //TODO: Add addOrganism()
    }

    public void simulate() {
        //TODO: Remove debug comments, implement simulate()
        //Test that everything works up to this point
        System.out.println("Simulation running:");
        System.out.println("sizeX: " + sizeX);
        System.out.println("sizeY: " + sizeY);
        System.out.println("numOrganisms: " + numOrganisms);
        System.out.println("listOrganisms.size: " + listOrganisms.size());
    }

    /**
     * Prints the current board visually to the console. Can only be
     * called by the class.
     */
    private void printBoard() {
        //TODO: Add printBoard()
    }
}

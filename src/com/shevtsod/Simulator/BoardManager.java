package com.shevtsod.Simulator;

import com.shevtsod.Organism.ConcreteClasses.Animals.*;
import com.shevtsod.Organism.ConcreteClasses.Vegetation.*;
import com.shevtsod.Organism.*;
import com.shevtsod.Organism.Animal.*;
import com.shevtsod.Organism.Vegetation.*;

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
    private int sizeX;
    private int sizeY;
    private List<Organism> listOrganisms;

    /**
     * Creates an empty board of size given by sizeX (# of horizontal cells)
     * and sizeY ($ of vertical cells)
     * @param sizeX Number of horizontal cells
     * @param sizeY Number of vertical cells
     */
    public BoardManager(int sizeX, int sizeY) {
        listOrganisms = new LinkedList<Organism>();
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        //Pass program control to simulate() function
        simulate();
    }

    /**
     * Adds any class that implements Organism to the list of organisms in
     * the simulation.
     * @param targetOrganism An object inheriting from Organism
     */
    public void addOrganism(Organism targetOrganism) {
        listOrganisms.add(targetOrganism);
    }

    public void simulate() {
        //TODO: Remove debug comments, implement simulate()
        //Test that everything works up to this point
        System.out.println("\nInitialized BoardManager");
        System.out.println("sizeX: " + sizeX);
        System.out.println("sizeY: " + sizeY);
        System.out.println("listOrganisms.size: " + listOrganisms.size());

        Animal bj1 = new Bluejay(0, 0);
        addOrganism(bj1);
        System.out.println("\nAdded Bluejay");
        System.out.println("TypeOrganism: " + bj1.getOrganism());
        System.out.println("TypeDiet: " + bj1.getDiet());
        System.out.println("Position: " + bj1.getPosX() + " " + bj1.getPosY());
        System.out.println("listOrganisms.size: " + listOrganisms.size());

        Vegetation sh1 = new Shrub(1, 1);
        addOrganism(sh1);
        System.out.println("\nAdded Shrub");
        System.out.println("TypeOrganism: " + sh1.getOrganism());
        System.out.println("Position: " + sh1.getPosX() + " " + sh1.getPosY());
        System.out.println("listOrganisms.size: " + listOrganisms.size());

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

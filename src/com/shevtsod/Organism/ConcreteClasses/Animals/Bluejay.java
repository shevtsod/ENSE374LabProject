package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Omnivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Bluejay for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Bluejay extends Omnivore {
    /**
     * Constructor for Bluejay - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Bluejay(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Bluejay;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
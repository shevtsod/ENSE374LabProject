package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Herbivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Squirrel for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Squirrel extends Herbivore {
    /**
     * Constructor for Squirrel - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Squirrel(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Squirrel;

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
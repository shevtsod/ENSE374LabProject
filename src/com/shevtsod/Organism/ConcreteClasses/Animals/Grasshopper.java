package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Herbivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Grasshopper for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Grasshopper extends Herbivore {
    /**
     * Constructor for Grasshopper - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Grasshopper(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Grasshopper;

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
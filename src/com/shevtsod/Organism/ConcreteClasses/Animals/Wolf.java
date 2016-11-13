package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Carnivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Wolf for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Wolf extends Carnivore {
    /**
     * Constructor for Wolf - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Wolf(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Wolf;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    /**
     * Check whether this Organism eats the passed in targetOrganism
     * @param targetOrganism the Organism to check against this Organism
     * @return true if this Organism can eat the targetOrganism, false otherwise.
     */
    public boolean eats(TypeOrganism targetOrganism) {
        switch(targetOrganism) {
            case Deer:
            case Rabbit:
                return true;
            default:
                return false;
        }
    }
}

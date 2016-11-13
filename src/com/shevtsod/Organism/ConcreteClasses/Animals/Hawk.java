package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Carnivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Hawk for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Hawk extends Carnivore {
    /**
     * Constructor for Hawk - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Hawk(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Hawk;

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
package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Herbivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Deer for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Deer extends Herbivore {
    /**
     * Constructor for Deer - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Deer(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Deer;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public TypeOrganism getType() {
        return TypeOrganism.Deer;
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
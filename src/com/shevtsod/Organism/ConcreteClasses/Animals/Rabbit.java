package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Herbivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Rabbit for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Rabbit extends Herbivore {
    /**
     * Constructor for Rabbit - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Rabbit(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Rabbit;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public TypeOrganism getType() {
        return TypeOrganism.Rabbit;
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
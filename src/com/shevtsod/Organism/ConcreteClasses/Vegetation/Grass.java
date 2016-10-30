package com.shevtsod.Organism.ConcreteClasses.Vegetation;


import com.shevtsod.Organism.TypeOrganism;
import com.shevtsod.Organism.Vegetation.Vegetation;

/**
 * <p>
 *     A Grass for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Grass extends Vegetation {
    /**
     * Constructor for Grass - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Grass(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Grass;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public TypeOrganism getType() {
        return TypeOrganism.Grass;
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
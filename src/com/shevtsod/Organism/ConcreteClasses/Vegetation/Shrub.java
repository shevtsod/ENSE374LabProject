package com.shevtsod.Organism.ConcreteClasses.Vegetation;


import com.shevtsod.Organism.Vegetation.Vegetation;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Shrub for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Shrub extends Vegetation {
    /**
     * Constructor for Shrub - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Shrub(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Shrub;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public TypeOrganism getType() {
        return TypeOrganism.Shrub;
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
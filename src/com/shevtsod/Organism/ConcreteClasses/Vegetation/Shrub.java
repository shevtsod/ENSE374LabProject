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
    }

    public boolean eats(TypeOrganism targetOrganism) {
        // We have not defined plants to eat anything in the current version.
        // Currently returns false for any organism, but can be extended.
        return true;
    }
}

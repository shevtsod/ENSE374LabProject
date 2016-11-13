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
    }

    public boolean eats(TypeOrganism targetOrganism) {
        // We have not defined plants to eat anything in the current version.
        // Currently returns false for any organism, but can be extended.
        return false;
    }
}

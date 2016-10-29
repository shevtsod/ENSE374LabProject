package com.shevtsod.Organism.Vegetation;

import com.shevtsod.Organism.Organism;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     Generic vegetation for the animal habitat simulator. Cannot be
 *     instantiated.
 *</p>
 *
 * @author Daniel Shevtsov
 */
public abstract class Vegetation implements Organism {
    protected int posX;
    protected int posY;
    protected TypeOrganism organism;

    //Implementations for methods from Organism:

    /**
     * @return x coordinate of this Vegetation
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return y coordinate of this Vegetation
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @return TypeOrganism of this Vegetation
     */
    public TypeOrganism getOrganism() {
        return organism;
    }
}
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
    private int posX;
    private int posY;
    protected TypeOrganism organism;

    /**
     * Constructor for Vegetation - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Vegetation(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

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

    /**
     * Causes Vegetation to move (change its x and y positions). Call
     * getPosX() and getPosY() after this method to retrieve the new position.
     * @param maxX maximum x coordinate allowed
     * @param maxY maximum y coordinate allowed
     */
    public void move(int maxX, int maxY) {
        //Don't need to do anything here, since Vegetation cannot move
        //Can be extended to create moving Vegetation, I guess
    }

    /**
     * @return Whether or not the Vegetation is alive.
     */
    public boolean isAlive() {
        //Vegetation is always alive.
        //Can be extended to add a hunger mechanic to Vegetables
        return true;
    }

    /**
     * Increases this Vegetation's hunger. Call isAlive() afterwards to check
     * whether the Vegetation is alive, or if its hunger exceeded the maximum
     * allowed.
     */
    public void addHunger() {
        //Vegetation does not have hunger, but can be extended
    }

    /**
     * Decreases this Vegetation's hunger. Call if this Vegetation just ate another
     * Organism.
     */
    public void reduceHunger() {
        //Vegetation does not have hunger, but can be extended
    }
}
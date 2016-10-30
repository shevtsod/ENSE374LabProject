package com.shevtsod.Organism.ConcreteClasses.Vegetation;


import com.shevtsod.Organism.TypeOrganism;
import com.shevtsod.Organism.Vegetation.Vegetation;

/**
 * <p>
 *     A Tree for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Tree extends Vegetation {
    /**
     * Constructor for Tree - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Tree(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Tree;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public TypeOrganism getType() {
        return TypeOrganism.Tree;
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
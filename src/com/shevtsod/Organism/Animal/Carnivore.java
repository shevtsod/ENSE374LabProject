package com.shevtsod.Organism.Animal;

import com.shevtsod.Organism.TypeDiet;

/**
 * <p>
 *     A generic carnivore for the animal habitat simulator. Cannot be
 *     instantiated.
 *</p>
 *
 * @author Daniel Shevtsov
 */
public abstract class Carnivore extends Animal {
    /**
     * Constructor for Herbivore - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Carnivore(int posX, int posY) {
        super(posX, posY);
        diet = TypeDiet.Carnivore;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }
}

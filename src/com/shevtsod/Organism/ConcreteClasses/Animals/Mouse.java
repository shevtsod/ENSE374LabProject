package com.shevtsod.Organism.ConcreteClasses.Animals;


import com.shevtsod.Organism.Animal.Herbivore;
import com.shevtsod.Organism.TypeOrganism;

/**
 * <p>
 *     A Mouse for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Mouse extends Herbivore {
    /**
     * Constructor for Mouse - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Mouse(int posX, int posY) {
        super(posX, posY);
        organism = TypeOrganism.Mouse;

        //The parameters below can be changed to different integer values.
        /*
        this.speed = 3;
        this.maxHunger = 5;
        */
    }

    public boolean eats(TypeOrganism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}
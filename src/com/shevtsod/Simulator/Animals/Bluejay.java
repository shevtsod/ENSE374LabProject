package com.shevtsod.Simulator.Animals;

import com.shevtsod.Organism.*;
import com.shevtsod.Organism.Animal.*;

/**
 * <p>
 *     A Bluejay for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public class Bluejay extends Omnivore {
    public TypeOrganism getType() {
        return TypeOrganism.Bluejay;
    }

    public boolean eats(Organism targetOrganism) {
        //TODO: Add eats()
        return true;
    }
}

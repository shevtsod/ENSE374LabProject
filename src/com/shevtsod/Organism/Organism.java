package com.shevtsod.Organism;

/**
 * <p>
 *     A generic organism for the animal habitat simulator. Cannot be
 *     instantiated.
 *</p>
 *
 * @author Daniel Shevtsov
 */
public interface Organism {
    int getPosX();
    int getPosY();
    TypeOrganism getOrganism();
    boolean eats(Organism targetOrganism);
}

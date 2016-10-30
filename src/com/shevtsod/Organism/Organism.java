package com.shevtsod.Organism;

/**
 * <p>
 *     A generic organism for the animal habitat simulator. Cannot be
 *     instantiated.
 *     Any concrete class extending this interface must implement
 *     <p>eats() - which TypeOrganisms </p>
 *     and
 *     <p>getOrganism() - type of Organism from TypeOrganism enum</p>
 *</p>
 *
 * @author Daniel Shevtsov
 */
public interface Organism {
    int getPosX();
    int getPosY();
    TypeOrganism getOrganism();
    boolean eats(TypeOrganism targetOrganism);
}

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
    public int getPosX();
    public int getPosY();
    public TypeOrganism getType();
    public boolean eats(Organism targetOrganism);
}

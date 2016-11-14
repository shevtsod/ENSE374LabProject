package com.shevtsod.Organism;

/**
 * <p>
 *     Defines all legal organism names for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public enum TypeOrganism {
    Bluejay,
    Caterpillar,
    Deer,
    Fox,
    Wolf,
    Hawk,
    Grasshopper,
    Mouse,
    Rabbit,
    Squirrel,
    Grass,
    Shrub,
    Tree;

    public String toString(TypeOrganism organism) {
        switch(organism) {
            case Bluejay:
                return "Bluejay";
            case Caterpillar:
                return "Caterpillar";
            case Deer:
                return "Deer";
            case Fox:
                return "Fox";
            case Wolf:
                return "Wolf";
            case Hawk:
                return "Hawk";
            case Grasshopper:
                return "Grasshopper";
            case Mouse:
                return "Mouse";
            case Rabbit:
                return "Rabbit";
            case Squirrel:
                return "Squirrel";
            case Grass:
                return "Grass";
            case Shrub:
                return "Shrub";
            case Tree:
                return "Tree";
            default:
                return "Unknown";
        }
    }
}

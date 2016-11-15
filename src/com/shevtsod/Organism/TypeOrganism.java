package com.shevtsod.Organism;

/**
 * <p>
 *     Defines all legal organism names for the animal habitat simulator.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public enum TypeOrganism {
    Grass,
    Shrub,
    Tree,
    Bluejay,
    Caterpillar,
    Deer,
    Fox,
    Wolf,
    Hawk,
    Grasshopper,
    Mouse,
    Rabbit,
    Squirrel;


    /**
     * Returns an icon for printing any TypeOrganism to the screen
     * @param organism The TypeOrganism for which to get the icon
     * @return String icon to represent this TypeOrganism
     */
    public static char getIcon(TypeOrganism organism) {
        switch(organism) {
            case Bluejay:
                return 'B';
            case Caterpillar:
                return 'C';
            case Deer:
                return 'D';
            case Fox:
                return 'F';
            case Wolf:
                return 'W';
            case Hawk:
                return 'H';
            case Grasshopper:
                return 'G';
            case Mouse:
                return 'M';
            case Rabbit:
                return 'R';
            case Squirrel:
                return 'S';
            case Grass:
                return 'g';
            case Shrub:
                return 's';
            case Tree:
                return 't';
            default:
                return '?';
        }
    }
}

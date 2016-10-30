package com.shevtsod.Organism.Animal;

import com.shevtsod.Organism.*;

/**
 * <p>
 *     A generic animal for the animal habitat simulator. Cannot be
 *     instantiated.
 * </p>
 *
 * @author Daniel Shevtsov
 */
public abstract class Animal implements Organism {
    private int posX;
    private int posY;
    protected int speed;
    protected int maxHunger;
    private int currentHunger;
    protected TypeOrganism organism;
    protected TypeDiet diet;

    /**
     * Constructor for Animal - initializes member variables.
     * @param posX initial x coordinate
     * @param posY initial y coordinate
     */
    public Animal(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.currentHunger = 0;

        //The properties below may be overriden by children's constructors.
        this.speed = 3;
        this.maxHunger = 5;
    }

    /**
     * Causes an animal to move (change its x and y positions). Call
     * getPosX() and getPosY() after this method to retrieve the new position.
     * @param maxX maximum x coordinate allowed
     * @param maxY maximum y coordinate allowed
     */
    public void move(int maxX, int maxY) {
        //TODO: Add move()
    }

    /**
     * @return TypeDiet of this Animal
     */
    public TypeDiet getDiet() {
        return diet;
    }

    /**
     * Increases this Animal's hunger. Call isAlive() afterwards to check
     * whether the animal is alive, or if its hunger exceeded the maximum
     * allowed.
     */
    public void addHunger() {
        currentHunger++;
    }

    /**
     * @return Whether or not the Animal is alive.
     */
    public boolean isAlive() {
        //Animal is alive until its currentHunger exceeds the maximum.
        return !(currentHunger >= maxHunger);
    }

    //Implementations for methods from Organism:

    /**
     * @return x coordinate of this Animal
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return y coordinate of this Animal
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @return TypeOrganism of this Animal
     */
    public TypeOrganism getOrganism() {
        return organism;
    }
}
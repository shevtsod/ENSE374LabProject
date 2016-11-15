package com.shevtsod.Organism.Animal;

import com.shevtsod.Organism.*;

import java.util.Random;

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
    protected TypeDiet diet = null;

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
        // Generate random x and y in range [-speed, speed]
        // If random number is less than [0, 0] or greater than [maxX, maxY],
        // random again.
        //
        // NOTE: This algorithm could probably be improved for performance
        //       At the moment, it simply randomizes until a good value is found.
        int posXOld = posX;
        int posYOld = posY;
        do {
            Random rand = new Random();
            int speedX = rand.nextInt(speed * 2 + 1) - speed; //Between -speed and speed
            int speedY = rand.nextInt(speed * 2 + 1) - speed;
            posX += speedX;
            posY += speedY;

            if(posX < 0)
                posX = 0;
            else if (posX > maxX)
                posX = maxX;

            if(posY < 0)
                posY = 0;
            else if (posY > maxY)
                posY = maxY;
        } while(posX < 0 || posX >= maxX ||
                posY < 0 || posY >= maxY ||
                posX == posXOld || posY == posYOld);
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
     * Decreases this Animal's hunger. Call if this Animal just ate another
     * Organism.
     */
    public void reduceHunger() {
        currentHunger--;
        if(currentHunger < 0)
            currentHunger = 0;
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
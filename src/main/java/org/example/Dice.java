package org.example;

public class Dice {
    private int numSides;

    public Dice(int numSides) {
        this.numSides = numSides;
    }

    public Dice() {
        this(6);
    }

    public int rollDice() {
        int roll = (int)(Math.floor(Math.random()*numSides+1));
        return roll;
    }

    public int getNumSides() {
        return numSides;
    }

}

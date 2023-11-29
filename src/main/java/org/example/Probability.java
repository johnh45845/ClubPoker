package org.example;

import java.util.ArrayList;

public class Probability {

    private int numOfTrials;
    private ArrayList<Integer> results = new ArrayList<Integer>();
    private Dice d1 = new Dice();

    public Probability(int numOfTrials) {
        this.numOfTrials = numOfTrials;
    }

    private void conductDiceExperiment() {
        for (int i = 0; i < numOfTrials; i++) {
            results.add(d1.rollDice());
        }
        double outcomes = 0;
        int randomComparison = d1.rollDice();
        for (int q = 0; q < results.size(); q++) {
            if (results.get(q) == randomComparison) {
                outcomes++;
            }
        }
    }

    public ArrayList<Integer> getList() {
        return results;
    }

}

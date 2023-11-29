package org.example;

public class CoinFlip {

    public static void checkForConseqRolls() {
        double startTime = System.currentTimeMillis();
        Dice dice1 = new Dice(2);
        int consecutiveRolls = 0;
        int totalRolls = 0;
        int failures = 0;
        int i = dice1.rollDice();
        int q = dice1.rollDice();

        while (consecutiveRolls <= 20) {
            if (i == q) {
                consecutiveRolls++;
                i = q;
                totalRolls++;
            } else {
                consecutiveRolls = 0;
                i = dice1.rollDice();
                totalRolls++;
                failures++;
            }
            q = dice1.rollDice();
        }
        double endTime = System.currentTimeMillis();
        System.out.println("complete");
        System.out.println("Total Rolls: " + totalRolls);
        System.out.println("Failures: " + failures);
        System.out.println("Total Time: " + (endTime-startTime)/1000 + "s");
    }

    public static void main(String[] args) {
        checkForConseqRolls();
    }
}

package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        int i = 0;
//
//        while (i < 100) {
//            PokerRound myRound = new PokerRound(25);
//            if (myRound.isFoundWinner()) {
//                System.out.println("Round " + i + ": Winners = " + myRound.getWinners() + ", Winning Rank = " + myRound.getWinningRank());
//            }
//            i++;
//        }

        int i = 0;
        boolean isHappy = false;

        while (!isHappy) {
            PokerRound myRound = new PokerRound(1000);
            if (myRound.isFoundWinner()) {
                if (myRound.getWinners().size() >= 1) {
                    System.out.println("Round " + i + ": Winners = " + myRound.getWinners() + ", Winning Rank = " + myRound.getWinningRank());
                    isHappy = true;
                }
            }
            i++;
        }


    }
}
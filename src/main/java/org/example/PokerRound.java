package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PokerRound {

    private ArrayList<String> players;
    private int numPlayers;
    private Poker poker1 = new Poker();
    private ArrayList<ArrayList<String>> allHandsWinnings;

    public PokerRound(int np) {
        numPlayers = np;
        players = new ArrayList<String>();
        for (int i = 0; i < numPlayers; i++) {
            players.add("player" + Integer.toString(i+1));
        }
        playRound();
        findWinner();
    }

    // functionality does not account for a split pot for a tie - simply redoes round until tie is broken
    private void playRound() {
        allHandsWinnings = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < numPlayers; i++) {
            ArrayList<String> myDeck = poker1.getHand();
            ArrayList<String> individualHandWinnings = new ArrayList<String>();
            if (Poker.checkStraight(myDeck)) {
                individualHandWinnings.add("straight");
            }
            if (Poker.checkFullHouse(myDeck)) {
                individualHandWinnings.add("fullHouse");
            }
            allHandsWinnings.add(individualHandWinnings);
        }
    }

    private void findWinner() {
        ArrayList<Integer> winners = new ArrayList<Integer>();
        String winningDeckType;
        for (int i = 0; i < allHandsWinnings.size(); i++) {
            if (!allHandsWinnings.get(i).isEmpty() && allHandsWinnings.get(i).get(0).equals("straight")) {
                winners.add(i);
            }
        }
        System.out.println(winners);
        if (winners.isEmpty()) {
            for (int i = 0; i < allHandsWinnings.size(); i++) {
                if (!allHandsWinnings.get(i).isEmpty() && allHandsWinnings.get(i).get(0).equals("fullHouse")) {
                    winners.add(i);
                }
            }
        }
        if (!winners.isEmpty()) {
            winningDeckType = allHandsWinnings.get(winners.get(0)).get(0);
            System.out.println("winningDeckType = ");
        } else {
            System.out.println("no winner");
        }
    }

}

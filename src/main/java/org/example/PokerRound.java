package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PokerRound {

    private static final int NUM_OF_HANDS = 10;

    private int numPlayers;
    private Poker poker1;
    private ArrayList<Integer> winners;
    private int winningRank;
    private boolean foundWinner;
    private ArrayList<Player> players = new ArrayList<Player>();

    public PokerRound(int n) {
        poker1 = new Poker();
        numPlayers = n;
        winners = new ArrayList<Integer>();
        foundWinner = false;


        for (int q = 0; q < numPlayers; q++) {
            Player myPlayer = new Player(poker1.getHand());
            analyzeDeck(myPlayer);
            players.add(myPlayer);
            findWinners();
        }
    }

    public static int getNumOfHands() {
        return NUM_OF_HANDS;
    }

    private static void analyzeDeck(Player p) {
        ArrayList<String> d = p.getPlayerHand();
        p.setPlayerWinnings(3,Poker.checkFullHouse(d));
        p.setPlayerWinnings(4,Poker.checkFlush(d));
        p.setPlayerWinnings(5,Poker.checkStraight(d));
    }

    private void findWinners() {
        int i = 0;
        while (!foundWinner && i < NUM_OF_HANDS) {
            for (Player p : players) {
                if (p.getPlayerWinnings(i) == true) {
                    winners.add(p.getID());
                    foundWinner = true;
                    winningRank = i;
                }
            }
            i++;
        }
        // removes following if-statement once functionality for rank#9 is complete
        if (!foundWinner) {
            i = 9;
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayerFromID(int i) {
        return players.get(i);
    }

    public ArrayList<Integer> getWinners() {
        return winners;
    }

    public int getWinningRank() {
        return winningRank;
    }

    public boolean isFoundWinner() {
        return foundWinner;
    }
}

package org.example;

import java.util.ArrayList;

public class Player {

    private static int ID = 0;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private int playerID;
    private String playerName;
    private ArrayList<String> playerHand;
    private boolean[] playerWinnings;

    public  Player(ArrayList<String> hand) {
        playerID = ID;
        ID++;

        playerName = "Player_" + playerID;
        playerHand = hand;
        playerWinnings = new boolean[PokerRound.getNumOfHands()];
    }

    public int getID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static Player getPlayerFromID(int i) {
        return players.get(i);
    }

    public boolean getPlayerWinnings(int i) {
        return playerWinnings[i];
    }

    public ArrayList<String> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerWinnings(int i, boolean v) {
        playerWinnings[i] = v;
    }


}

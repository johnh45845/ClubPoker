package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Poker {

    private static final ArrayList<String> deck = new ArrayList<String>();


    // poker hand has five cards chosen from a 52 card deck

    public Poker() {
        initializeDeck();
    }

    private static double factorial(double n)
    {
        double res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    public static double comb(double n, double r) {
        return (factorial(n)) / ((factorial(r)) * (factorial(n-r)));
    }

    public static double totalHandOutcomes() {
        return (factorial(52))/(factorial(5)*(factorial(52-5)));
    }

    public static boolean doesContain(String c, ArrayList<String> d) {
        for (int i = 0; i < d.size(); i++) {
            if (c.equals(d.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static void initializeDeck() {
        ArrayList<String> suits = new ArrayList<String>(Arrays.asList("S", "H", "D", "C"));
        for (int i = 0; i < suits.size(); i++) {
            for (int q = 1; q <= 13; q++) {
                if (q <= 10) {
                    deck.add(suits.get(i) + Integer.toString(q));
                } else if (q == 11) {
                    deck.add(suits.get(i) + "J");
                } else if (q == 12) {
                    deck.add(suits.get(i) + "Q");
                } else if (q == 13) {
                    deck.add(suits.get(i) + "K");
                }
            }
        }
    }


    public ArrayList<String> getHand() {
        ArrayList<String> hand = new ArrayList<String>();
        int i = 0;
        while (i < 5) {
            int selection = (int)(Math.random()*deck.size());
            if (!doesContain(deck.get(selection),hand)) {
                hand.add(deck.get(selection));
                i++;
            }
        }
        return hand;
    }

    public static boolean checkFullHouse(ArrayList<String> d) {
        char kind1 = 'n';
        char kind2 = 'n';
        int numKind1 = 0;
        int numKind2 = 0;
        ArrayList<Character> d2 = new ArrayList<Character>();
        for (int i = 0; i < d.size(); i++) {
            d2.add(d.get(i).charAt(1));
        }

        for (int w = 0; w < d2.size(); w++) {
            for (int b = 0; b < d2.size(); b++) {
                if (w != b) {
                    if (d2.get(w).equals(d2.get(b))) {
                        if (d.get(w).length() == 3 && d.get(b).length() == 2) {
                            break;
                        } else if (d.get(w).length() == 2 && d.get(b).length() == 3) {
                            break;
                        } else {
                            if (kind1 == 'n') {
                                kind1 = d2.get(w);
                                numKind1++;
                            } else if (d2.get(w) == kind1) {
                                numKind1++;
                            } else if (kind2 == 'n') {
                                kind2 = d2.get(w);
                                numKind2++;
                            } else if (d2.get(w) == kind2) {
                                numKind2++;
                            }
                        }
                    }
                }
            }
        }


        if (numKind1 == 6 && numKind2 == 2) {
            return true;
        } else if (numKind2 == 6 && numKind1 == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkFlush(ArrayList<String> d) {
        ArrayList<Character> d2 = new ArrayList<Character>();
        for (int z = 0; z < d.size(); z++) {
            d2.add(d.get(z).charAt(0));
        }

        for (int q = 0; q < d2.size(); q++) {
            for (int t = q+1; t < d2.size(); t++) {
                if (!(d2.get(q).equals(d2.get(t)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkStraight(ArrayList<String> d) {
        ArrayList<Integer> d2 = new ArrayList<Integer>();
        for (int i = 0; i < d.size(); i++) {
            String v = "";
            for (int q = 1; q < d.get(i).length(); q++) {
                v = v + d.get(i).charAt(q);
            }
            if (v.equals("K")) {
                v = "13";
            } else if (v.equals("Q")) {
                v = "12";
            } else if (v.equals("J")) {
                v = "11";
            }
            d2.add(Integer.valueOf(v));
        }

        Collections.sort(d2); // sorts in ascending numerical order

        for (int w = 0; w < d2.size(); w++) {
            for (int b = 0; b < d2.size(); b++) {
                if (w != b) {
                    if (d2.get(w).equals(d2.get(b))) {
                        return false;
                    }
                }
            }
        }

        boolean stillPossible = true;
        int u = 0;
        int k;

        while (stillPossible) {
            k = d2.get(u);
            if (k+1 == d2.get(u+1)) {
                if (u+1 == 5-1) {
                    return true;
                }
                u++;
            } else {
                stillPossible = false;
            }
        }
        return false;
    }

}

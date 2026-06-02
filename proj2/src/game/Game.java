package game;

import java.util.Scanner;

public class Game extends Board {
    protected Player[] players;
    protected Scanner s;

    public Game(int n, int m, Player p1, Player p2) {
        super(n, m);
        players = new Player[] {p1, p2};
        s = new Scanner(System.in);
    }
    protected boolean doesWin(int i, int j) {
        return i == 0 && j == 0;
    }
    protected boolean onePlay(Player p) {
        while (true) {
            System.out.println("Player " + p + ", enter your move (row and column): ");
            int i = s.nextInt();
            int j = s.nextInt();
            if (set(i, j, p)) {
                System.out.println(this);
                return doesWin(i, j);
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public Player play() {
        int currentPlayer = 0;
        while (!isFull()) {
            if (onePlay(players[currentPlayer])) {
                System.out.println(players[currentPlayer] + " Won!");
                return players[currentPlayer];
            }
            currentPlayer = 1 - currentPlayer;
        }
        return null;
    }
} 

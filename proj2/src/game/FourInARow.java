package game;

public class FourInARow extends Game {
    public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
    }

    protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) >= 4;
    }

    protected boolean onePlay(Player p) {
        while (true) {
            System.out.println(p + ", please enter column:");
            int col = s.nextInt();

            int row = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (isEmpty(i, col)) {
                    row = i;
                    break;
                }
            }

            if (row == -1) {
                System.out.println("Column is full. Try again.");
                continue;
            }

            set(row, col, p);
            System.out.println(this);
            return doesWin(row, col);
        }
    }
}

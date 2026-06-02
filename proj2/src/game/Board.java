package game;

public class Board {
    protected Player[][] board = null;
    protected int n, m;

    public Board(int rows, int cols) {
        n = rows;
        m = cols;
        board = new Player[n][m];
    }
    
    protected boolean set(int i, int j, Player p) {
        if (board[i][j] == null) {
            board[i][j] = p;
            return true;
        }
        return false;
    }

    public boolean isEmpty(int i, int j) {
        return get(i, j) == null;
    }

    public Player get(int i, int j) {
        return board[i][j];
    }

    public boolean isFull() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == null) {
                    sb.append(".");
                } else {
                    sb.append(board[i][j].getMark());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    protected int maxLineContaining(int i, int j) {
        Player p = get(i, j);
        if (p == null) {
            return 0;
        }

        int maxCount = 1;

        int[][] directions = {
            {0, 1},   // horizontal
            {1, 0},   // vertical
            {1, 1},   // diagonal down-right
            {1, -1}   // diagonal down-left
        };

        for (int[] dir : directions) {
            int di = dir[0];
            int dj = dir[1];
            int count = rayLength(i, j, di, dj) + rayLength(i, j, -di, -dj) - 1;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private int rayLength(int i, int j, int di, int dj) {
        Player center = get(i, j);
        if (center == null) {
            return 0;
        }
        char mark = center.getMark();
        int length = 0;

        for (int k = 0; ; k++) {
            int ni = i + k * di;
            int nj = j + k * dj;
            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                break;
            }
            Player neighbor = get(ni, nj);
            if (neighbor == null || neighbor.getMark() != mark) {
                break;
            }
            length++;
        }

        return length;
    }
}



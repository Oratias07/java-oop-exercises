package mines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mines {
    private final int height;
    private final int width;
    private final int numMinesWanted;
    private final Cell[][] cells;
    private final Random random = new Random();
    private int mineCount;
    private boolean showAll;

    public Mines(int height, int width, int numMines) {
        this.height = height;
        this.width = width;
        this.numMinesWanted = numMines;
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.cells[i][j] = new Cell();
            }
        }
        this.mineCount = 0;
        this.showAll = false;
    }

    public boolean addMine(int i, int j) {
        if (mineCount >= numMinesWanted) {
            return false;
        }
        Cell cell = cells[i][j];
        if (cell.mine) {
            return false;
        }
        cell.mine = true;
        mineCount++;
        return true;
    }

    public boolean open(int i, int j) {
        ensureMinesInitialized();
        Cell cell = cells[i][j];
        if (cell.mine) {
            return false;
        }
        if (cell.open) {
            return true;
        }
        openCell(i, j);
        return true;
    }

    public void toggleFlag(int x, int y) {
        Cell cell = cells[x][y];
        if (!cell.open) {
            cell.flag = !cell.flag;
        }
    }

    public boolean isDone() {
        ensureMinesInitialized();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = cells[i][j];
                if (!cell.mine && !cell.open) {
                    return false;
                }
            }
        }
        return true;
    }

    public String get(int i, int j) {
        ensureMinesInitialized();
        Cell cell = cells[i][j];
        if (!cell.open && !showAll) {
            return cell.flag ? "F" : ".";
        }
        if (cell.mine) {
            return "X";
        }
        int adjacent = countAdjacentMines(i, j);
        return adjacent == 0 ? " " : Integer.toString(adjacent);
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    @Override
    public String toString() {
        ensureMinesInitialized();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(get(i, j));
            }
            if (i < height - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    private void ensureMinesInitialized() {
        if (mineCount == numMinesWanted) {
            return;
        }
        List<Point> candidates = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!cells[i][j].mine) {
                    candidates.add(new Point(i, j));
                }
            }
        }
        Collections.shuffle(candidates, random);
        int needed = numMinesWanted - mineCount;
        for (int k = 0; k < needed && k < candidates.size(); k++) {
            Point p = candidates.get(k);
            cells[p.i][p.j].mine = true;
            mineCount++;
        }
    }

    private void openCell(int i, int j) {
        Cell cell = cells[i][j];
        if (cell.open || cell.mine) {
            return;
        }
        cell.open = true;
        cell.flag = false;
        int adjacent = countAdjacentMines(i, j);
        if (adjacent != 0) {
            return;
        }
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) {
                    continue;
                }
                int ni = i + di;
                int nj = j + dj;
                if (ni >= 0 && ni < height && nj >= 0 && nj < width) {
                    openCell(ni, nj);
                }
            }
        }
    }

    private int countAdjacentMines(int i, int j) {
        int count = 0;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) {
                    continue;
                }
                int ni = i + di;
                int nj = j + dj;
                if (ni >= 0 && ni < height && nj >= 0 && nj < width) {
                    if (cells[ni][nj].mine) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static class Cell {
        boolean mine;
        boolean open;
        boolean flag;
    }

    private static class Point {
        final int i;
        final int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

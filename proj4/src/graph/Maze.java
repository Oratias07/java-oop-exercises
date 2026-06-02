package graph;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a grid-based maze with start/end points and walls.
 * Provides connectivity checking using graph traversal.
 */
public class Maze implements GraphInterface<Place> {
    private Place start;
    private Place end;
    private boolean[][] walls;
    private int size;

    public Maze(int size, int startx, int starty, int endx, int endy) {
        this.size = size;
        this.walls = new boolean[size][size];
        start = new Place(startx, starty, size);
        end = new Place(endx, endy, size);
    }

    public boolean addWall(int x, int y) {
        new Place(y, x, size);
        if ((start.getX() == y && start.getY() == x) ||
            (end.getX() == y && end.getY() == x) ||
            walls[x][y]) return false;
        walls[x][y] = true;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (start.getX() == x && start.getY() == y) sb.append('S');
                else if (end.getX() == x && end.getY() == y) sb.append('E');
                else if (walls[y][x]) sb.append('@');
                else sb.append('.');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Checks if maze is solvable by building a graph of connected cells
     * and verifying connectivity between start and end positions.
     */
    public boolean isSolvable() {
        Graph<Place> g = new Graph<>();

        // Add all non-wall cells as vertices
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!walls[row][col]) {
                    try { g.addVertex(new Place(col, row, size)); }
                    catch (GraphException e) { e.printStackTrace(); }
                }
            }
        }

        // Connect adjacent cells: up, down, left, right
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (walls[row][col]) continue;
                for (int[] d : dirs) {
                    int nrow = row + d[0], ncol = col + d[1];
                    if (nrow >= 0 && nrow < size && ncol >= 0 && ncol < size && !walls[nrow][ncol]) {
                        Place p1 = new Place(col, row, size);
                        Place p2 = new Place(ncol, nrow, size);
                        if (!g.hasEdge(p1, p2)) {
                            try { g.addEdge(p1, p2); }
                            catch (GraphException e) { e.printStackTrace(); }
                        }
                    }
                }
            }
        }

        try { return g.connected(start, end); }
        catch (GraphException e) { e.printStackTrace(); return false; }
    }

    /**
     * Returns all walkable neighbors (up, down, left, right) of a given cell.
     * Excludes cells outside bounds and wall cells.
     */
    public Collection<Place> neighbours(Place p) {
        List<Place> result = new ArrayList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int nrow = p.getY() + d[0];
            int ncol = p.getX() + d[1];
            // Check boundary and wall conditions
            if (nrow >= 0 && nrow < size && ncol >= 0 && ncol < size && !walls[nrow][ncol])
                result.add(new Place(ncol, nrow, size));
        }
        return result;
    }
}

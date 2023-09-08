package net.projecteuler;

import java.util.HashSet;
import java.util.List;

public class P015 {
    public static final int GRID_WIDTH = 2;
    public static final int GRID_HEIGHT = 2;

    public static HashSet<String> allPaths = new HashSet<>();

    public static int currentX;
    public static int currentY;

    enum Direction {
        RIGHT,
        DOWN
    }

    public static int[] posAfterMove(Direction direction) {
        int[] pos = new int[]{currentX, currentY};
        switch (direction) {
            case RIGHT:
                pos[0]++;
                break;
            case DOWN:
                pos[1]++;
                break;
        }
        return pos;
    }

    public static boolean isLegal(int posX, int posY, Direction direction) {
        return false;
    }
}

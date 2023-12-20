import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private int width;
    private int height;
    private char[][] gridData;
    private boolean[][] energyPoints;
    private List<Head> heads = new ArrayList<>();
    private boolean finished = false;

    public Map(char[][] gridData, int x, int y, char dir) {
        this.gridData = gridData;
        this.width = gridData[0].length;
        this.height = gridData.length;
        this.heads.add(new Head(x, y, dir, this));
        this.energyPoints = new boolean[gridData.length][gridData[0].length];
    }

    public void energisePoint(int x, int y) {
        this.energyPoints[y][x] = true;
    }

    public void tick() {
        List<Head> newHeads = new ArrayList<>();
        for (Head head : heads) {
            newHeads.addAll(head.getNewHeads());
        }
        this.heads = newHeads;
    }


    // Getters
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getGridData() {
        return gridData;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean[][] getEnergyPoints() {
        return energyPoints;
    }
}

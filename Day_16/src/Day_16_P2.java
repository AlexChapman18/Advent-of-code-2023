import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day_16_P2 {
    public static void main(String[] args) {
        char[][] grid = readFile("Day 16/src/input_P1.txt");

        int biggest = 0;
        // 7043

        for (int i = 0; i < grid.length; i++) {
            Map map = new Map(grid, i, -1, 'S');
            int val = processMap(map);
            if (val > biggest){
                biggest = val;
            }
        }
        System.out.println(biggest);
    }

    private static int processMap(Map map) {
        int counter = 0;
        while (counter < 750) {
            map.tick();
            counter ++;
        }

        int total = 0;
        for (boolean[] row : map.getEnergyPoints()) {
            for (boolean cell : row) {
                int myInt = cell ? 1 : 0;
                total += myInt;
            }
        }
        System.out.println(total);
        return total;
    }


    private static char[][] readFile(String fileName) {
        List<char[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rows.add(line.toCharArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        char[][] grid = new char[rows.size()][rows.get(0).length];
        for (int i = 0; i < rows.size(); i++) {
            grid[i] = rows.get(i);
        }
        return grid;
    }
}
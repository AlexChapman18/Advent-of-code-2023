import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Day_13_P1 {

    public static void main(String[] args) {
        try {
            String inputFile = "Day 13/input1.txt";
            List<String> inputData = readFile(inputFile);
            List<List<String>> subSets = partitionList(inputData, "");
            System.out.println("Hello");
            for (List<String> grid : subSets) {
                getSymmetry(parseGrid(grid));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] getSymmetry(char[][] grid) {
        char[][] mainGrid = grid;
        char[][] rotatedGrid = rotateCW(grid);


        System.out.println("FinishedGrid");
        return new int[1];
    }

    private static int getSymmetry(char[] row) {


        return -1;
    }

    private static char[][] parseGrid(List<String> gridData) {

        int height = gridData.size();
        int width = gridData.get(0).length();
        char[][] grid =  new char[height][width];
        int currentRow = 0;

        for (String row : gridData) {
            grid[currentRow] = row.toCharArray();
            currentRow++;
        }

        return grid;
    }

    private static List<String> readFile(String fileName) throws IOException {
        List<String> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line and store it in a String[]
                String row = line;
                rows.add(row);
            }
        }
        return rows;
    }

    private static List<List<String>> partitionList(List<String> inputList, String delimiter) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();

        for (String element : inputList) {
            if (element.equals(delimiter)) {
                // Add the current partition to the list of partitions
                partitions.add(currentPartition);
                // Start a new partition
                currentPartition = new ArrayList<>();
            } else {
                // Add the element to the current partition
                currentPartition.add(element);
            }
        }

        // Add the last partition (if any) to the list of partitions
        if (!currentPartition.isEmpty()) {
            partitions.add(currentPartition);
        }

        return partitions;
    }

    static char[][] rotateCW(char[][] mat) {
        final int M = mat.length;
        final int N = mat[0].length;
        char[][] ret = new char[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                ret[c][M-1-r] = mat[r][c];
            }
        }
        return ret;
    }
}

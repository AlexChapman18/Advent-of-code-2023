import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day15P1 {

    public static void main(String[] args) {
        try {
            String inputFile = "Day 15/input1.txt";
            List<String> inputData = readFile(inputFile);
            System.out.println(processList(inputData));
            System.out.println(processString("qp"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int processChar(int currentValue, char value) {
        int asciiVal = (int) value;
        currentValue += asciiVal;
        currentValue *= 17;
        currentValue = currentValue % 256;
        return currentValue;
    }

    public static int processList(List<String> strings) {
        int total = 0;
        for (String inputString : strings) {
            total += processString(inputString);
        }
        return total;
    }

    public static int processString(String inputString) {
        int currentValue = 0;
        for (char chr : inputString.toCharArray()) {
            currentValue = processChar(currentValue, chr);
        }
        return currentValue;
    }

    private static List<String> readFile(String fileName) throws IOException {
        List<String> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> row = Arrays.asList(line.split(","));
                rows.addAll(row);
            }
        }
        return rows;
    }
}

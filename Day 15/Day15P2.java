import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day15P2 {

    public static void main(String[] args) {
        try {
            String inputFile = "Day 15/input2.txt";
            List<String> inputData = readFile(inputFile);
            List<Instruction> instructions = parseFile(inputData);
            List<Box> outputBoxes = processInstructions(instructions);
            System.out.println(getFocalPower(outputBoxes));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getFocalPower(List<Box> boxes) {
        int total = 0;
        for (Box box : boxes) {
            total += box.getFocusPower();
        }
        return total;
    }


    private static List<Instruction> parseFile(List<String> strings) {
        List<Instruction> instructions = new ArrayList<>();
        for (String str : strings) {
            instructions.add(new Instruction(str));
        }
        return instructions;
    }

    private static List<Box> processInstructions(List<Instruction> instructions) {
        List<Box> boxes = new ArrayList<>();
        for (int i=0; i < 256; i++) {
            boxes.add(new Box(i));
        }
        for (Instruction instruction : instructions) {
            processInstruction(boxes, instruction);
        }
        return boxes;
    }

    private static void processInstruction(List<Box> boxes, Instruction instruction) {
        Box targetBox = boxes.get(instruction.getHashcode());
        if (instruction.getOperand() == '=') {
            Lens newLens = new Lens(instruction.getLabel(), instruction.getFocalLength(), instruction.getHashcode());
            targetBox.addLens(newLens);
        } else {
            targetBox.removeLens(instruction.getLabel());
        }
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


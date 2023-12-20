public class Instruction {

    private char operand;
    private String label;
    private int hashcode;
    private int focalLength;

    public Instruction(String rawInstruction) {
        if (rawInstruction.contains("=")) {
            String[] splitInstruction = rawInstruction.split("=");
            this.operand = '=';
            this.label = splitInstruction[0];
            this.focalLength = Integer.parseInt(splitInstruction[1]);
        } else {
            String[] splitInstruction = rawInstruction.split("-");
            this.operand = '-';
            this.label = splitInstruction[0];
        }
        this.hashcode = hashString(this.label);
    }


    public static int hashChar(int currentValue, char chr) {
        int asciiVal = (int) chr;
        currentValue += asciiVal;
        currentValue *= 17;
        currentValue = currentValue % 256;
        return currentValue;
    }

    public static int hashString(String str) {
        int currentValue = 0;
        for (char chr : str.toCharArray()) {
            currentValue = hashChar(currentValue, chr);
        }
        return currentValue;
    }


    public char getOperand() {
        return operand;
    }

    public String getLabel() {
        return label;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public int getHashcode() {
        return hashcode;
    }
}

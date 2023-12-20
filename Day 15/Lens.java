public class Lens {

    private String label;
    private int focalLength;
    private int hashcode;

    public Lens(String label, int focalLength, int hashcode) {
        this.label = label;
        this.focalLength = focalLength;
        this.hashcode = hashcode;
    }

    public String getLabel() {
        return label;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public int getHashcode() {
        return hashcode;
    }
}

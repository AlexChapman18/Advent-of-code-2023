import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Lens> lenses = new ArrayList<>();
    private int index;

    public Box(int index) {
        this.index = index;
    }

    public void addLens(Lens newLens) {
        for (Lens curLens : this.lenses) {
            if (curLens.getLabel().equals(newLens.getLabel())) {
                curLens.setFocalLength(newLens.getFocalLength());
                return;
            }
        }
        lenses.add(newLens);
    }

    public void removeLens(String label) {
        this.lenses.removeIf(lens -> lens.getLabel().equals(label));
    }

    public int getFocusPower() {
        int total = 0;
        int boxPower = this.index + 1;
        for (int i=0; i < this.lenses.size(); i++) {
            Lens curLens = this.lenses.get(i);
            total += boxPower * (i+1) * curLens.getFocalLength();
        }
        return total;
    }
}

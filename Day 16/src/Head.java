import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Head {

    int x;
    int y;
    char direction;
    Map map;
    List<String> seenHeads = new ArrayList<>();


    public Head(int x, int y, char direction, Map map) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.map = map;
    }

    public List<Head> getNewHeads() {
        List<Head> newHeads = new ArrayList<>();

        if (this.direction == 'N' && this.y - 1 >= 0) {
            this.y -= 1;
        } else if (this.direction == 'E' && this.x + 1 < map.getWidth()) {
            this.x += 1;
        } else if (this.direction == 'S' && this.y + 1 < map.getHeight()) {
            this.y += 1;
        } else if (this.direction == 'W' && this.x - 1 >= 0) {
            this.x -= 1;
        } else {
            return newHeads;
        }

        map.energisePoint(this.x, this.y);
        char newCellItem = map.getGridData()[this.y][this.x];

        if(newCellItem == '.') {
            newHeads.add(new Head(this.x, this.y, this.direction, this.map));
        } else if (newCellItem == '\\') {
            if (this.direction == 'N') {
                newHeads.add(new Head(this.x, this.y, 'W', map));
            } else if (this.direction == 'E') {
                newHeads.add(new Head(this.x, this.y, 'S', map));
            } else if (this.direction == 'S') {
                newHeads.add(new Head(this.x, this.y, 'E', map));
            } else if (this.direction == 'W') {
                newHeads.add(new Head(this.x, this.y, 'N', map));
            }
        } else if (newCellItem == '/') {
            if (this.direction == 'N') {
                newHeads.add(new Head(this.x, this.y, 'E', map));
            } else if (this.direction == 'E') {
                newHeads.add(new Head(this.x, this.y, 'N', map));
            } else if (this.direction == 'S') {
                newHeads.add(new Head(this.x, this.y, 'W', map));
            } else if (this.direction == 'W') {
                newHeads.add(new Head(this.x, this.y, 'S', map));
            }
        } else if (newCellItem == '|') {
            if (this.direction == 'N' || this.direction == 'S') {
                newHeads.add(new Head(this.x, this.y, this.direction, this.map));
            } else if (this.direction == 'E' || this.direction == 'W') {
                newHeads.add(new Head(this.x, this.y, 'N', map));
                newHeads.add(new Head(this.x, this.y, 'S', map));
            }
        } else if (newCellItem == '-') {
            if (this.direction == 'N' || this.direction == 'S') {
                newHeads.add(new Head(this.x, this.y, 'E', map));
                newHeads.add(new Head(this.x, this.y, 'W', map));
            } else if (this.direction == 'E' || this.direction == 'W') {
                newHeads.add(new Head(this.x, this.y, this.direction, this.map));
            }
        }

        // List<Head> finalHeads = new ArrayList<>();
        // for (Head head : newHeads) {
        //     String headString = (head.x + "," + head.y + "," + head.direction);
        //     if (!seenHeads.contains(headString)) {
        //         seenHeads.add(headString);
        //         finalHeads.add(head);
        //     }
        // }
        return newHeads;
    }
}

package backend;

import java.util.ArrayList;
import java.util.List;

public class Bin {
    private ArrayList<Float> items = new ArrayList<>();
    private float filled = 0;
    private float capacity;

    // additems and checks if it's over-capacity
    // returns true and adds item if it fits
    // returns false and ignores item if it doesn't
    public boolean addItem(float item) {
        if (filled + item < capacity) {
            this.items.add(item);
            filled += item;
            return true;
        } else {
            return false;
        }
    }

    // returns the list of items in it
    public List<Float> getItemList() {
        return items;
    }

    // constructor
    public Bin(float item, float capacity) {
        this.items.add(item);
        filled += item;
        this.capacity = capacity;
    }
}

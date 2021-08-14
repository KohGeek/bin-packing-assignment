package backend;

import java.util.LinkedList;
import java.util.List;

public class Bin {

    private LinkedList<Integer> items = new LinkedList<>();
    private int filled = 0;
    private int capacity;

    // add items and checks if it's over-capacity
    // returns true and adds item if it fits
    // returns false and ignores item if it doesn't
    public boolean addItem(int item) {
        if (filled + item < capacity) {
            this.items.add(item);
            filled += item;
            return true;
        } else {
            return false;
        }
    }

    // returns the list of items in the bin
    public List<Integer> getItemList() {
        return items;
    }

    // constructor
    public Bin(int item, int capacity) {
        this.items.add(item);
        filled += item;
        this.capacity = capacity;
    }

    public Bin(int capacity) {
        this.capacity = capacity;
    }
}

package backend;

import java.util.LinkedList;
import java.util.List;

public class Bin {

    private LinkedList<Integer> items = new LinkedList<>();
    private int filled = 0;
    private int capacity;

    // checks if it's over-capacity
    // return remaining capacity if item are added, can be in negative
    public int checkCapacity(int item) {
        return capacity - (filled + item);
    }

    // add items to the bin
    public void addItem(int item) {
        if (filled + item <= capacity) {
            this.items.add(item);
            filled += item;
        } else {
            // this should never happen, as error checking should be done PRIOR to this stage
            // reserved solely for debugging, if something goes really wrong
            throw new IllegalArgumentException("Bin is full.");
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

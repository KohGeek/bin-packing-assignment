package backend;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FirstFit extends BinPackingAlgorithm {

    public FirstFit(int capacity) {
        super(capacity);
        this.algorithmName = "ff";
        bins = new LinkedList<>();
    }

    @Override
    public void pack(List<Integer> items) {
        for (Integer integer : items) {
            // Resets iterator instance, starts from the first bin
            var binIterator = bins.iterator();
            firstFit(integer, binIterator);
        }
    }

    // First Fit Algorithm
    // 1. Check if there is a next bin, if not, add a new bin and call it a day
    // 2. Else, check if it fits in the bin
    // 3. If it fits, add it to the bin
    // 4. Else, go to the next bin
    private void firstFit(int item, Iterator<Bin> binIterator) {
        var added = false;
        while (!added) {
            if (!binIterator.hasNext()) {
                bins.add(new Bin(item, binCapacity));
                added = true;
            } else { 
                var bin = binIterator.next();
                if (bin.checkCapacity(item) >= 0) {
                    bin.addItem(item);
                    added = true;
                }
            }
        }
    }
}

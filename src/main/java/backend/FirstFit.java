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
    // 1. Step through the bin and try to fit the tiem
    // 2. If it fits in the bin, exit loop
    // 3. If it stepped through every bin, and still fail to fit the item, make a
    // new bin
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

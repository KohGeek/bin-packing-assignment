package backend;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FirstFitDescending extends BinPackingAlgorithm {

    private LinkedList<Integer> items = new LinkedList<>();

    public FirstFitDescending(int capacity) {
        super(capacity);
        this.algorithmName = "ffd";
        bins = new LinkedList<>();
    }

    @Override
    public void pack(List<Integer> items) {
        Collections.sort(items, Collections.reverseOrder());

        for (Integer integer : items) {
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
        var isFit = -1;
        while (!added) {
            if (!binIterator.hasNext()) {
                bins.add(new Bin(item, binCapacity));
                added = true;
            } else {
                var bin = binIterator.next();
                isFit = bin.checkCapacity(item);
                if (isFit >= 0) {
                    bin.addItem(item);
                    added = true;
                }
            } 
        }
    }
}

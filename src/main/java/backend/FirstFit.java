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
            var it = bins.iterator();
            firstFit(integer, it);
        }
    }

    // First Fit Algorithm
    // 1. Step through the bin and try to fit the tiem
    // 2. If it fits in the bin, exit loop
    // 3. If it stepped through every bin, and still fail to fit the item, make a
    // new bin
    private void firstFit(int item, Iterator<Bin> it) {
        var isFit = -1;
        while (it.hasNext() && isFit < 0) {
            isFit = it.next().addItem(item);
        }
        if (isFit < 0) {
            bins.add(new Bin(item, binCapacity));
        }
    }
}

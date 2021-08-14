package backend;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FirstFitDescending extends BinPackingAlgorithm {

    LinkedList<Integer> items = new LinkedList<>();

    public FirstFitDescending(int capacity) {
        super(capacity);
        this.algorithmName = "ffd";
        bins = new LinkedList<>();
    }

    @Override
    public void pack(List<Integer> items) {
        Collections.sort(items, Collections.reverseOrder());

        for (Integer integer : items) {
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
        var isFit = false;
        while (it.hasNext() && !isFit) {
            isFit = it.next().addItem(item);
        }
        if (!isFit) {
            bins.add(new Bin(item, binCapacity));
        }
    }
}

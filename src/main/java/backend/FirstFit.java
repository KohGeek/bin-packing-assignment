package backend;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstFit extends BinPackingAlgorithm {

    private Queue<Bin> bins;
    
    public FirstFit(int capacity) {
        this.algorithmName = "ff";
        this.binCapacity = capacity;
        this.bins = new LinkedList<>();
    }

    @Override
    public void pack(List<Integer> items) {
        for (Integer integer : items) {
            // Resets iterator instance, starts from the first bin
            var binIterator = bins.iterator();
            firstFit(integer, binIterator);
        }
    }

    @Override
    public int getNumberOfBins(){
        return bins.size();
    }

    @Override
    public Collection<Bin> getPackedBins() {
        return bins;
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

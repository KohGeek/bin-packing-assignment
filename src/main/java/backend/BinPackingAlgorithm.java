package backend;

import handler.BinPacking;
import java.util.Collection;
import java.util.List;

public abstract class BinPackingAlgorithm implements BinPacking {

    protected String algorithmName;
    protected int binCapacity;
    protected Collection<Bin> bins;

    protected BinPackingAlgorithm(int capacity) {
        this.binCapacity = capacity;
    }

    public void pack(List<Integer> items) {}

    public int getNumberOfBins() {
        return bins.size();
    }

    public Collection<Bin> getPackedBins() {
        return bins;
    }

    public String getAlgoName() {
        return algorithmName;
    }
}

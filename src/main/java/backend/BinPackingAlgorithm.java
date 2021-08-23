package backend;

import java.util.Collection;
import java.util.List;

public abstract class BinPackingAlgorithm {

    protected String algorithmName;
    protected int binCapacity;
    protected Collection<Bin> bins;

    protected BinPackingAlgorithm(int capacity) {
        this.binCapacity = capacity;
    }

    public abstract void pack(List<Integer> items);

    public int getNumberOfBins() {
        return bins.size();
    }

    public Collection<Bin> getPackedBins() {
        return bins;
    }

    public int getBinCapacity() {
        return binCapacity;
    }

    public String getAlgoName() {
        return algorithmName;
    }
}

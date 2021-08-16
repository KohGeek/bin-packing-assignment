package backend;

import handler.BinPacking;
import java.util.Collection;

public abstract class BinPackingAlgorithm implements BinPacking {

    protected String algorithmName;
    protected int binCapacity;
    protected Collection<Bin> bins;

    protected BinPackingAlgorithm(int capacity) {
        this.binCapacity = capacity;
    }

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

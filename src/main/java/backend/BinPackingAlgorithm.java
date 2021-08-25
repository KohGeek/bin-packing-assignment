package backend;

import java.util.Collection;
import java.util.List;

public abstract class BinPackingAlgorithm {

    protected String algorithmName;
    protected int binCapacity;

    public abstract void pack(List<Integer> items);

    public abstract int getNumberOfBins();

    public abstract Collection<Bin> getPackedBins();

    public int getBinCapacity() {
        return binCapacity;
    }

    public String getAlgoName() {
        return algorithmName;
    }
}

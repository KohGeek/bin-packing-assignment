package handler;

import backend.Bin;
import java.util.Collection;
import java.util.List;

public interface BinPacking {
    public void pack(List<Integer> items);

    public int getNumberOfBins();

    public Collection<Bin> getPackedBins();
}

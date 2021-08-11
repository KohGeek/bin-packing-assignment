package handler;

import java.util.Collection;

import backend.Bin;

public interface BinPacking {

    public void setCapacity(int capacity);
    public int getCapacity();

    public void pack(String filename);

    public int getNumberOfBins();
    public Collection<Bin> getPackedBins();
}

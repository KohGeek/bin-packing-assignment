package handler;

import backend.*;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Controller implements Callable<Integer> {

    private File inputFile;
    private int noOfRandomItems;
    private String outputFileName;
    private int binCapacity;
    private boolean isRandomlyGenerated;
    List<Integer> items = new LinkedList<>();

    Random rand = new Random();

    FileHandler fh = new FileHandler();

    BinPackingAlgorithm ff;
    BinPackingAlgorithm ffd;

    public Controller(
        File file,
        int number,
        String outputFile,
        int capacity,
        boolean isRandomlyGenerated
    ) {
        this.inputFile = file;
        this.noOfRandomItems = number;
        this.outputFileName = outputFile;
        this.binCapacity = capacity;
        this.isRandomlyGenerated = isRandomlyGenerated;
    }

    @Override
    public Integer call() throws Exception {
        Collection<Bin> bins;

        ff = new FirstFit(binCapacity);
        ffd = new FirstFitDescending(binCapacity);

        if (isRandomlyGenerated) {
            for (var i = 0; i < noOfRandomItems; i++) items.add(
                rand.nextInt(binCapacity - 1) + 1
            );
        } else {
            items = fh.readFile(inputFile, binCapacity);
        }

        ff.pack(items);
        bins = ff.getPackedBins();
        fh.writeFile(outputFileName, ff.getAlgoName(), bins);

        ffd.pack(items);
        bins = ffd.getPackedBins();
        fh.writeFile(outputFileName, ffd.getAlgoName(), bins);

        return 0;
    }
}

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

    // constructor, looks weird cause formatted by prettier
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

    // Prints what is written to the file, to the console
    public void logToConsole(String algoName, Collection<Bin> bins) {
        System.out.println("\n---" + algoName + "---");
        for (Bin bin : bins) {
            var it = bin.getItemList().iterator();
            while (it.hasNext()) {
                System.out.print(it.next().toString());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // runner calls this method
    @Override
    public Integer call() throws Exception {
        Collection<Bin> bins;

        ff = new FirstFit(binCapacity);
        ffd = new FirstFitDescending(binCapacity);

        // if isRandomlyGenerated, then generated specified amount of random items
        if (isRandomlyGenerated) {
            for (var i = 0; i < noOfRandomItems; i++) items.add(rand.nextInt(binCapacity - 1) + 1);
            System.out.println(noOfRandomItems + " has been generated.");
        // otherwise read from file
        } else {
            items = fh.readFile(inputFile, binCapacity);
            System.out.println(inputFile.getName() + " has been read.");
        }

        // Print out the read items/generated items into 5 columns
        var newline = 0;
        for (Integer item : items) {
            if (newline > 4) {
                System.out.println();
                newline = 0;
            }
            System.out.print(item + "\t");
            newline++;
        }
        System.out.println();
        
        // The following two modules are the same
        // 1. Pack the item list
        // 2. Get the packed bins
        // 3. Write the bins to the output file
        ff.pack(items);
        bins = ff.getPackedBins();
        logToConsole(ff.getAlgoName(), bins);
        fh.writeFile(outputFileName, ff.getAlgoName(), bins);

        ffd.pack(items);
        bins = ffd.getPackedBins();
        logToConsole(ffd.getAlgoName(), bins);
        fh.writeFile(outputFileName, ffd.getAlgoName(), bins);

        return 0;
    }

}

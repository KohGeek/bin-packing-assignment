package analysis;

import backend.BinPackingAlgorithm;
import backend.FirstFit;
import backend.FirstFitDecreasing;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        BinPackingAlgorithm ff;
        BinPackingAlgorithm ffd;
        List<Integer> items;
        Random rand;

        // Setup the initial parameters here
        int binCapacity = 15;
        int maxRandom = 12;
        int minRandom = 3;
        int noOfRandomItems = 5000;
        int repeatCount = 2000;
        // End setup

        float totalFFBins = 0;
        float totalFFDBins = 0;

        long startTime;
        long endTime;
        long ffDuration = 0;
        long ffdDuration = 0;

        for (int n = 0; n < repeatCount; n++) {
            ff = new FirstFit(binCapacity);
            ffd = new FirstFitDecreasing(binCapacity);
            items = new LinkedList<>();
            rand = new Random();

            for (var i = 0; i < noOfRandomItems; i++) items.add(
                rand.nextInt(maxRandom - minRandom + 1) + minRandom
            );

            // Here, the order of the execution is randomised to prevent bias in execution time
            if (rand.nextInt() % 2 == 0) {
                startTime = System.nanoTime();
                ff.pack(items);
                endTime = System.nanoTime();
                ffDuration += endTime - startTime;

                startTime = System.nanoTime();
                ffd.pack(items);
                endTime = System.nanoTime();
                ffdDuration += endTime - startTime;
            } else {
                startTime = System.nanoTime();
                ffd.pack(items);
                endTime = System.nanoTime();
                ffdDuration += endTime - startTime;

                startTime = System.nanoTime();
                ff.pack(items);
                endTime = System.nanoTime();
                ffDuration += endTime - startTime;
            }

            totalFFBins += ff.getNumberOfBins();
            totalFFDBins += ffd.getNumberOfBins();

            // Print the progress
            System.out.println("Current iteration: " + n);
        }

        System.out.println("Average number of bins for First Fit: " + totalFFBins / repeatCount);
        System.out.println(
            "Average number of bins for First Fit Decreasing: " + totalFFDBins / repeatCount
        );

        System.out.println("Average time for First Fit: " + ffDuration / repeatCount + "ns");
        System.out.println(
            "Average time for First Fit Decreasing: " + ffdDuration / repeatCount + "ns"
        );
    }
}

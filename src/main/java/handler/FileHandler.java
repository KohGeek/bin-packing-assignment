package handler;

import backend.Bin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    // write to file
    public void writeFile(String prependName, String algoName, Collection<Bin> bins)
        throws IOException {
        var outputFile = new File(prependName + "-" + algoName + ".txt");

        // try-with-resources for the FileWriter
        // The following code does this:
        // 1. For each of the bin, create go through the ItemList iterator
        // 2. Write the itemlist to the file on the same row for each bin
        // 3. Newline, and repeat until all bins have been written
        try (var writer = new FileWriter(outputFile);) {
            for (Bin bin : bins) {
                var it = bin.getItemList().iterator();
                while (it.hasNext()) {
                    writer.write(it.next().toString());
                    writer.write(" ");
                }
                writer.write("\n");
            }
        }
    }

    public List<Integer> readFile(File inputFile, int capacity) throws FileNotFoundException {
        List<Integer> items = new LinkedList<>();

        // try-with-resources for the Scanner
        // The following code does this:
        // 1. For each of the line, scan and parse as Int
        // 2. If parsing fails, catch the error and skip to the next line
        // 3. If parsing succeeds, but number is still out of bounds, skip to the next line.
        // 4. Otherwise, add the number to the items LinkedList
        // 5. Return LinkedList when complete
        try (var sc = new Scanner(inputFile);) {
            while (sc.hasNextLine()) {
                try {
                    var item = Integer.parseInt(sc.nextLine());
                    if (item <= capacity && item >= 1) {
                        items.add(item);
                    } else {
                        System.out.println("Numbers out of bounds, skipping line.");
                    }
                } catch (Exception e) {
                    System.out.println("Non-integer detected, skipping line.");
                }
            }
        }

        return items;
    }
}

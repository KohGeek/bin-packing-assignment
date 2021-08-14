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

    public void writeFile(
        String prependName,
        String algoName,
        Collection<Bin> bins
    ) throws IOException {
        var outputFile = new File(prependName + "-" + algoName + ".txt");

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

    public List<Integer> readFile(File inputFile, int capacity)
        throws FileNotFoundException {
        List<Integer> items = new LinkedList<>();

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

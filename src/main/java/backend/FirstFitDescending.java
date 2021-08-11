import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import handler.BinPacking;

public class FirstFitDescending implements BinPacking {

    public static void main(String[] args) throws Exception {

        Float binCapacity = Float.parseFloat(args[0]);
        Scanner readFile = new Scanner(new File(args[1]));

        ArrayList<Float> items = new ArrayList<>();
        ArrayList<Bin> bins = new ArrayList<>();

        // this is a first-fit descending algorithm, thus all data is read first
        while (readFile.hasNext()) {
            items.add(Float.parseFloat(readFile.next()));
        }

        // then sorted
        Collections.sort(items, Collections.reverseOrder());
        readFile.close();
        bins.add(new Bin(items.get(0), binCapacity));

        // Following code is a bit ugly due to overuse of breaks
        // How it work:
        // 1. For every item, step through the bins
        // 2. If it fits in the bin, jump to the next object
        // 3. If it stepped through every bin, and still fail to fit the item, make a
        // new bin
        // 4. Repeat until all items are stepped through
        for (int i = 1; i < items.size(); i++) {
            Float item = items.get(i);
            for (int j = 0; j <= bins.size(); j++) {
                if (bins.get(j).addItem(item)) {
                    break;
                } else if (j == bins.size() - 1) {
                    bins.add(new Bin(item, binCapacity));
                    break;
                }
            }
        }

        // Write the data into a file, specified here
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (Bin bin : bins) {
                List<Float> temp = new LinkedList<>();
                temp = bin.getItemList();

                for (Float f : temp) {
                    writer.write(String.valueOf(f) + " ");
                }

                writer.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
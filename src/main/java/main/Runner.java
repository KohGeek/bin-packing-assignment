package main;

import handler.Controller;
import java.io.File;
import java.util.Random;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Command(
    mixinStandardHelpOptions = true,
    version = "Bin Packing Algorithm v0.0.3-SNAPSHOT",
    description = "Runs the bin-packing-algorithm"
)
public class Runner implements Callable<Integer> {

    @ArgGroup(exclusive = true, multiplicity = "1")
    Input input;

    static class Input {

        @Option(
            names = { "-i", "--input" },
            description = "Specify input file name for the items. Mutally exclusive with -r."
        )
        private String inputFile;

        @Option(
            names = { "-r", "--random" },
            description = "Randomly generates a specified number of items. Mutually exclusive with -i.",
            defaultValue = "-1"
        )
        private int number;

        public int getNumberOfItems() {
            return number;
        }

        public String getInputFileName() {
            return inputFile;
        }
    }

    @Option(
        names = { "-o", "--output" },
        description = "Specify the prepend for the output file name. Default prepend is `output`, which to output-<algo>.txt.",
        defaultValue = "output"
    )
    private String outputFile = "output";

    @Option(
        names = { "-c", "--capacity" },
        description = "Specify the capacity of the bin.",
        required = true
    )
    private int capacity;

    @Spec
    CommandSpec spec;

    Random rand = new Random();

    @Override
    public Integer call() throws Exception {
        var cl = spec.commandLine();
        boolean isRandomlyGenerated = cl
            .getParseResult()
            .hasMatchedOption("--random");
        File file = null;

        if (capacity < 1) {
            throw new ParameterException(
                cl,
                "Bin capacity must not be less than 1."
            );
        }

        if (isRandomlyGenerated && input.getNumberOfItems() < 1) {
            throw new ParameterException(
                cl,
                "Number of generated items must not be less than 1."
            );
        } else if (!isRandomlyGenerated) {
            file = new File(input.getInputFileName());
            if (!file.exists()) {
                throw new ParameterException(cl, "Input file does not exists!");
            }
        }

        var controller = new Controller(
            file,
            input.getNumberOfItems(),
            outputFile,
            capacity,
            isRandomlyGenerated
        );
        return controller.call();
    }

    public static void main(String... args) {
        var commandLine = new CommandLine(new Runner());
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}

# bin-packing-assignment

Data Structure and Algorithm assignment, implementing and analysing the speed of various bin packing algorithm.

In this project, we are only targeting First-Fit and First-Fit-Decreasing of the $O(n^2)$ variant.

## Dependencies

- Maven
- picocli 4.6.x

## Compilation and export

Run `mvn clean package assembly:single` in project root or use `Export Jar` in eclipse.

This will produce a jar file under the `target` folder that can be run using the following command:

`java -jar [output-file]`

## Help

Use `java -jar [output-file] -h` to obtain help information.

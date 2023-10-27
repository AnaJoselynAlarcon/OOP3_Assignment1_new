import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Shapes.Cone;
import Shapes.Cylinder;
import Shapes.OctagonalPrism;
import Shapes.PentagonalPrism;
import Shapes.Pyramid;
import Shapes.Shape;
import Shapes.ShapeComparator;
import Shapes.SquarePrism;
import Shapes.TriangularPrism;

public class ComplexityAndSorting {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println(
                    "Invalid input. Usage: java -jar sort.jar -f <file_name> -t <sorting_criteria> -s <sorting_method>");
            return;
        }

        String fileName = null;
        String sortingCriteria = null;
        String sortingMethod = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-f")) {
                fileName = args[i + 1];
            } else if (args[i].equalsIgnoreCase("-t")) {
                sortingCriteria = args[i + 1];
            } else if (args[i].equalsIgnoreCase("-s")) {
                sortingMethod = args[i + 1];
            }
        }

        if (fileName == null || sortingCriteria == null || sortingMethod == null) {
            System.out.println(
                    "Missing arguments. Usage: java -jar sort.jar -f <file_name> -t <sorting_criteria> -s <sorting_method>");
            return;
        }

        System.out.println("File Name: " + fileName);
        System.out.println("Sorting Criteria: " + sortingCriteria);
        System.out.println("Sorting Method: " + sortingMethod);

        // Read shapes from the file and store them in an array
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int numOfObjects = scanner.nextInt();

            Shape[] shapes = new Shape[numOfObjects];

            for (int i = 0; i < numOfObjects; i++) {

                String shapeType = scanner.next();
                double height = scanner.nextDouble();
                double value = scanner.nextDouble();

                Shape shape = null;
                switch (shapeType.toLowerCase()) {
                    case "cylinder":
                        shape = new Cylinder(height, value);
                        break;
                    case "cone":
                        shape = new Cone(height, value);
                        break;
                    case "pyramid":
                        shape = new Pyramid(height, value);
                        break;
                    case "squareprism":
                        shape = new SquarePrism(height, value);
                        break;
                    case "triangularprism":
                        shape = new TriangularPrism(height, value);
                        break;
                    case "pentagonalprism":
                        shape = new PentagonalPrism(height, value);
                        break;
                    case "octagonalprism":
                        shape = new OctagonalPrism(height, value);
                        break;
                    default:
                        System.out.println("Unknown shape type: " + shapeType);
                }

                if (shape != null) {
                    shapes[i] = shape;
                }

            }
            scanner.close();

            // Create a comparator based on the sorting criteria
            // convert sortingCriteria to lowercase
            ;

            ShapeComparator comparator = new ShapeComparator(sortingCriteria.toLowerCase());

            // Benchmark and measure sorting time
            long startTime = System.currentTimeMillis();
            Utility.sortShapes(shapes, comparator, sortingMethod.toLowerCase());
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println("Time taken to sort: " + elapsedTime + " milliseconds");

            // Print the sorted values and benchmarking results
            printSortedShapes(shapes);
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Error while reading input: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printSortedShapes(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            // Only prints the first item, the last item and every thousandth value in
            // between
            if (i == 0 || i == shapes.length - 1 || (i + 1) % 1000 == 0) {

                Shape shape = shapes[i];
                System.out.println("Shape Type: " + shape.getClass().getSimpleName());
                System.out.println("Height: " + shape.getHeight());
                System.out.println("Base Area: " + shape.getBaseArea());
                System.out.println("Volume: " + shape.getVolume());
                System.out.println();

            }

            //

        }
        System.out.println("First element shape type: " + shapes[0].getClass().getSimpleName());
        System.out.println("First element height: " + shapes[0].getHeight());
        System.out.println("First element base area:  " + shapes[0].getBaseArea());
        System.out.println("First element Volume: " + shapes[0].getVolume());

        System.out.println("Last element shape type: " + shapes[shapes.length - 1].getClass().getSimpleName());
        System.out.println("Last element height: " + shapes[shapes.length - 1].getHeight());
        System.out.println("Last element base area" + shapes[shapes.length - 1].getBaseArea());
        System.out.println("Last element Volume:" + shapes[shapes.length - 1].getVolume());

    }
}

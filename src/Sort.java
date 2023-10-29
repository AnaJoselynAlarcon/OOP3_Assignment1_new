import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import Shapes.Cone;
import Shapes.Cylinder;
import Shapes.OctagonalPrism;
import Shapes.PentagonalPrism;
import Shapes.Pyramid;
import Shapes.Shape;
import Shapes.ShapeComparator;
import Shapes.SquarePrism;
import Shapes.TriangularPrism;

public class Sort {

    // Flag constants
    private static final String FLAG_FILE = "-f";
    private static final String FLAG_SORT_CRITERIA = "-t";
    private static final String FLAG_SORT_METHOD = "-s";
    
    public static void main(String[] args) {

        String fileName = null;
        String sortingCriteria = null;
        String sortingMethod = null;

        for (String arg : args) {
            arg = arg.toLowerCase(); // Convert the argument to lowercase for case-insensitive comparison
            if (arg.startsWith(FLAG_FILE)) {
                fileName = arg.replaceFirst(FLAG_FILE + "(\"?)(.*?)\\1", "$2");
            } else if (arg.startsWith(FLAG_SORT_CRITERIA)) {
                sortingCriteria = arg.substring(2);
            } else if (arg.startsWith(FLAG_SORT_METHOD)) {
                sortingMethod = arg.substring(2);
            }
        }

        if (fileName == null || sortingCriteria == null || sortingMethod == null) {
            System.out.println(
                    "Missing arguments. Usage: java -jar sort.jar -f <file_name> -t <sorting_criteria> -s <sorting_method>");
            return;
        }

        System.out.println("------------------- Arguments -----------------");
        System.out.println("-> File Name: " + fileName);
        System.out.println("-> Sorting Criteria: " + sortingCriteria);
        System.out.println("-> Sorting Method: " + sortingMethod + "\n");

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
            Comparator<Shape> comparator;
            long startTime = System.currentTimeMillis();
            
             switch (sortingCriteria) {
                case "h":
                    Arrays.sort(shapes, Collections.reverseOrder());
                    break;
                case "v":
                    comparator = new VolumeComparator();
                    Utility.sortShapes(shapes, comparator, sortingMethod);
                    break;
                case "a":
                    comparator = new AreaComparator();
                    Utility.sortShapes(shapes, comparator, sortingMethod);
                    break;
                default:
                    System.out.println("Unknown sorting criteria: " + sortingCriteria);
            }

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
             
            System.out.println("------------------ Sorting Time ----------------");
            System.out.println("-> Time taken to sort: " + elapsedTime + " milliseconds \n");

            // Print the sorted values and benchmarking results
            System.out.println("-------------------- Shapes --------------------");
            printSortedShapes(shapes);
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Error while reading input: " + e.getMessage());
        }
    }

    public static void printSortedShapes(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            // Only prints the first item, the last item and every thousandth value in between
            if (i == 0 || i == shapes.length - 1 || (i + 1) % 1000 == 0) {

                Shape shape = shapes[i];
                System.out.println("Shape number: " + (i + 1));
                System.out.println("-> Shape Type: " + shape.getClass().getSimpleName());
                System.out.println("-> Height: " + shape.getHeight());
                System.out.println("-> Base Area: " + shape.getBaseArea());
                System.out.println("-> Volume: " + shape.getVolume());
                System.out.println();

            }
        }
    }
}

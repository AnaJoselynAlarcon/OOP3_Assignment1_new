# Java Sorting Application READ ME

### Group 1: Ana Alarcon, Oriana Bermudez, Steph Martyna

### Date: October 27th, 2023

---

## OVERVIEW

This Java program is designed to implement and analyze six different sorting algorithms (Bubble, Insertion, Selection, Merge, Quick, and a user-selected algorithm) for a collection of three-dimensional geometric shapes. The program leverages the Strategy pattern to allow users to specify the sorting criteria (height, volume, or base area) and provides benchmarking data for each sorting algorithm's performance.

# Specifications

The program implements the following sorting algorithms:
:bubbles: Bubble Sort
:white_large_square: Insertion Sort
:yellow_square:Selection Sort
:blue_square:Merge Sort
:green_square:Quick Sort
:purple_square: Heap Sort

### Getting Started:

To run this program, follow these guidelines:

[x] Run the program using the following command-line format:

```
java -jar SortingApplication.jar -f <path_to_file_name> -t <sorting_type> -s <sorting_algorithm>
```

- -f or -F followed by file_name: Specifies the input data file containing random shapes.
- -t or -T followed by v (volume), h (height), or a (base area): Specifies the sorting criteria.
- -s or -S followed by b (Bubble), s (Selection), i (Insertion), m (Merge), q (Quick), or h (Heap): Specifies the sorting algorithm.

_If the user enters an incorrect command-line argument, the program will display a helpful message to guide the user in correcting the error._

## Examples of valid inputs :+1:

```
java -jar sort.jar -fshapes.txt -tv -sb
java -jar sort.jar -ta -sQ -f"res\shapes.txt"
java -jar sort.jar -tH -F"C:\temp\shapes.txt" -sB
```

##### Program Flow 🔁

1. The program reads a text file (provided via the -f option) containing random shapes.

- The shapes are Cylinder, Cone, Prism, or Pyramid.

2. All shapes are added to an array and manipulated as elements of this array

3. The program implements the Strategy pattern by:

- Creating an abstract class representing a three-dimensional geometric shape.
- Implementing the compareTo() method for height comparison and the compare() method for base area and volume comparison using the Comparator and Comparable interfaces.

4. The program measures and prints the time taken to sort the collection for the selected sorting algorithm in milliseconds.

- It will print first sorted value, the last sorted value, and every thousandth value in between.

##Formulas used:

- Cylinder and Cone:

Volume: π _ radius^2 _ height
Base Area: π \* radius^2

- Pyramid:

Volume: (edgeLength^2 \* height) / 3
Base Area: edgeLength^2

- Prism:

The base area depends on the type of base polygon.
Volume: baseArea \* height

##### Contributors ⭐

- Oriana Bermudez
- Steph Martyna
- Ana Alarcon

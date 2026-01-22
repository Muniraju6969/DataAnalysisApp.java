import java.util.Scanner; // For console input

/**
 * Arrays & Basic Data Analysis Program
 * Demonstrates:
 * - Storing numerical data in arrays (hint #1)
 * - Operations: sum, average, max, min (hint #2)
 * - Manual sorting without built-in methods (hint #3)
 * - Single and multi-dimensional arrays (hint #4)
 * - Handling ArrayIndexOutOfBoundsException (hint #5)
 * - Efficient loops for traversal (hint #6)
 * - Formatted output (hint #7)
 * - Clear comments for logic (hint #8)
 */
public class DataAnalysisApp {

    // Method to calculate sum of a 1D array (reusable)
    private static double sum(double[] arr) {
        double total = 0;
        for (double num : arr) { // Efficient enhanced for-loop for traversal (hint #6)
            total += num;
        }
        return total;
    }

    // Method to calculate average (reuses sum)
    private static double average(double[] arr) {
        if (arr.length == 0) return 0; // Avoid division by zero
        return sum(arr) / arr.length;
    }

    // Method to find max in array
    private static double max(double[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        double maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) { // Standard for-loop for index access
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    // Method to find min in array
    private static double min(double[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        double minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }

    // Manual bubble sort (without built-in methods - hint #3)
    private static void sort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // Outer loop for passes
            for (int j = 0; j < n - i - 1; j++) { // Inner loop for comparisons
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Demonstrate multi-dimensional array (2D matrix sum - hint #4)
    private static double sum2D(double[][] matrix) {
        double total = 0;
        for (double[] row : matrix) { // Traverse rows
            total += sum(row); // Reuse 1D sum method
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Analysis App - Enter numerical data.");

        // Single-dimensional array demo (hint #4)
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        double[] data = new double[size]; // Store numerical data (hint #1)

        // Input loop with exception handling
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            data[i] = scanner.nextDouble();
        }

        // Operations (hint #2)
        double dataSum = sum(data);
        double dataAvg = average(data);
        double dataMax = max(data);
        double dataMin = min(data);

        // Manual sort
        sort(data); // Sorts in-place (ascending)

        // Formatted output (hint #7)
        System.out.println("\nAnalysis Results:");
        System.out.printf("Sum: %.2f%n", dataSum);
        System.out.printf("Average: %.2f%n", dataAvg);
        System.out.printf("Max: %.2f%n", dataMax);
        System.out.printf("Min: %.2f%n", dataMin);
        System.out.print("Sorted Array: ");
        for (double num : data) {
            System.out.printf("%.2f ", num);
        }
        System.out.println();

        // Multi-dimensional array demo (2D matrix)
        double[][] matrix = {
                {1.5, 2.5, 3.5},
                {4.5, 5.5, 6.5}
        };
        System.out.printf("\n2D Matrix Sum: %.2f%n", sum2D(matrix));

        // Demonstrate ArrayIndexOutOfBoundsException handling (hint #5)
        try {
            System.out.println("Accessing invalid index: " + data[size]); // Intentional out-of-bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage() + " - Array index out of bounds.");
        }

        scanner.close();
        System.out.println("App exited.");
    }

}

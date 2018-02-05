import java.util.Arrays;
import java.util.Collections;

/**
 * Programmed by Joey Ferguson
 * 5 February 2018
 */

// This class is to test the different implementations of different
// edge cases for the sorting algorithms.
public class EdgeCases {

    // Arranges the array to be only values of 1.0 or 2.0
    private static void twoValues(Double[] array, int numToSort) {
        for (int i = 0; i < numToSort; i++) {
            if (i % 2 == 0) {
                array[i] = 1.0;
            }
            else {
                array[i] = 2.0;
            }
        }
    }

    // Arranges the array in the exact opposite order of sorted
    private static void reverseOrder(Double[] array, int numToSort) {
        for (int i = 0; i < numToSort; i++) {
            array[i] = StdRandom.uniform();
            // StdOut.println(array[i]);
        }

        Arrays.sort(array, Collections.reverseOrder());
    }

    public static void main(String[] args) {
        int numToSort = 10000;
        double elapsedTime;
        Double[] a = new Double[numToSort];

        // twoValues(a, numToSort);
        reverseOrder(a, numToSort);

        // Populating all arrays to be the exact same
        Double[] b = a.clone();
        Double[] c = a.clone();
        Double[] d = a.clone();
        Double[] e = a.clone();
        Double[] f = a.clone();
        Double[] g = a.clone();

        StdOut.println("Items to sort: " + numToSort);
        StdOut.println();

        Stopwatch timer1 = new Stopwatch();
        Bubble.sort(a);
        elapsedTime = timer1.elapsedTime();
        StdOut.println("Bubble Sort");
        StdOut.println(elapsedTime);

        Stopwatch timer2 = new Stopwatch();
        Selection.sort(b);
        elapsedTime = timer2.elapsedTime();
        StdOut.println("Selection Sort");
        StdOut.println(elapsedTime);

        Stopwatch timer3 = new Stopwatch();
        Insertion.sort(c);
        elapsedTime = timer3.elapsedTime();
        StdOut.println("Insertion Sort");
        StdOut.println(elapsedTime);

        Stopwatch timer4 = new Stopwatch();
        Shell.sort(d);
        elapsedTime = timer4.elapsedTime();
        StdOut.println("Shell Sort");
        StdOut.println(elapsedTime);

        Stopwatch timer5 = new Stopwatch();
        Quick.sort(e);
        elapsedTime = timer5.elapsedTime();
        StdOut.println("Quick Sort");
        StdOut.println(elapsedTime);

        Stopwatch timer6 = new Stopwatch();
        QuickSortMedian3.sort(f);
        elapsedTime = timer6.elapsedTime();
        StdOut.println("Quick Sort Median 3");
        StdOut.println(elapsedTime);

        Stopwatch timer7 = new Stopwatch();
        QuickSortMedian5.sort(g);
        elapsedTime = timer7.elapsedTime();
        StdOut.println("Quick Sort Median 5");
        StdOut.println(elapsedTime);
    }
}

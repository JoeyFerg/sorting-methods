/**
 * Programmed by Joey Ferguson
 * 5 February 2018
 */

// This class is designed to be an improvement of Quick sort.
// It sorts very similarly to Quick Sort, except it partitions
// the array with a function that finds the median of five indices.
public abstract class QuickSortMedian5 extends Sorting {

    // Public sort method callable from outside the class
    static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    // Sorts the array from low to high indices
    private static void sort(Comparable[] array, int low, int high) {
        if (high <= low) { return; }

        int median = low + (high - low)/2;

        median = medianOf5(array, low, low + (median - low)/2, median, median + (high - median)/2, high);
        exchange(array, low, median);

        int j = QuickSortMedian3.partition(array, low, high);       // partition data into parts, returning pivot index
        sort(array, low, j-1);                                      // recursively sort lower part
        sort(array, j+1, high);                                     // recursively sort higher part
    }

    // Takes in five values to try to find the median
    // Returns the best three out of five candidates and then calls the medianOf3 function.
    private static int medianOf5(Comparable[] array, int low, int quart1, int median, int quart3, int high) {
        int leftMin, leftMax;
        int rightMin, rightMax;
        int c1, c2, c3;

        if (less(array[low], array[quart1])) {
            leftMin = low;
            leftMax = quart1;
        } else {
            leftMin = quart1;
            leftMax = low;
        }

        if (less(array[high], array[quart3])) {
            rightMin = high;
            rightMax = quart3;
        } else {
            rightMin = quart3;
            rightMax = high;
        }

        if (less(array[rightMax], array[leftMax])) {
            c1 = rightMax;
        } else {
            c1 = leftMax;
        }

        if (less(array[leftMin], array[rightMin])) {
            c2 = rightMin;
        } else {
            c2 = leftMin;
        }

        c3 = median;

        // Calls the medianOf3 function in the other class to avoid code duplication
        return QuickSortMedian3.medianOf3(array, c1, c2, c3);
    }

    private static Double[] populateArray(int numToSort) {
        Double[] randomArray = new Double[numToSort];
        for (int randoms = 0; randoms < numToSort; randoms++) {
            randomArray[randoms] = StdRandom.uniform();
        }

        return randomArray;
    }

    public static void main(String[] args) {
        int N = 1000000;

        for (int numToSort = N ; numToSort <= 64 * N; numToSort *= 2) {
            Double[] arrayToSort = populateArray(numToSort);

            Stopwatch timer = new Stopwatch();
            sort(arrayToSort);
            StdOut.println(numToSort + " => " + timer.elapsedTime() + " seconds.");
        }
    }
}

/**
 * Programmed by Joey Ferguson
 * 16 June 2017
 */

// This class is designed to be an improvement of Quick Sort.
// It sorts very similarly to Quick Sort, except it partitions
// the array with a function that finds the median of three indices.
public class QuickSortMedian3 extends Sorting {

    // Public sort method callable from outside the class
    static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    // Sorts the array from low to high indices
    private static void sort(Comparable[] array, int low, int high) {
        if (high <= low) { return; }

        int median = low + (high - low)/2;

        median = medianOf3(array, low, median, high);
        exchange(array, low, median);

        int i = partition(array, low, high);        // partition data into parts, returning pivot index
        sort(array, low, i-1);                 // recursively sort lower part
        sort(array,i+1, high);                  // recursively sort higher part
    }

     // Returns the median of three indices passed in
     private static int medianOf3(Comparable[] array, int low, int median, int high) {
        if (less(array[low], array[median])) {
            if (less(array[median], array[high])) {
                return median;
            }
            else {
                if (less(array[low], array[high])) {
                    return high;
                }
                else {
                    return low;
                }
            }
        } else {
            if (less(array[low], array[high])) {
                return low;
            }
            else {
                if (less(array[median], array[high])) {
                    return high;
                }
                else {
                    return median;
                }
            }
        }
    }

    // Partition the sub-array so that array[lo..j-1] < array[j] < array[j+1..hi]
    private static int partition(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;

        Comparable partition = array[low];       // pivot

        while(true) {

            while(less(array[++i], partition)) {
                if (i == high) break;
            }
            while(less(partition, array[--j])) {
                if (j == low) break;
            }

            if(i >= j) { break; }

            exchange(array, i, j);
        }

        exchange(array, low, j);
        return j;
    }

    public static void main(String[] args) {
        int N = 100000;
        for (int numToSort = N; numToSort <= 64 * N; numToSort *= 2) {
            Double[] randomArray = new Double[numToSort];
            for (int randoms = 0; randoms < numToSort; randoms++) {
                randomArray[randoms] = StdRandom.uniform();
            }

            Stopwatch timer = new Stopwatch();
            sort(randomArray);
            StdOut.println(numToSort + " => " + timer.elapsedTime() + " seconds.");
        }
    }
}

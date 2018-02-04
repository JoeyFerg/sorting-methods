/**
 * Programmed by Joey Ferguson
 * 16 June 2017
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

        int j = partition(array, low, high);      // partition data into parts, returning pivot index
        sort(array, low, j-1);               // recursively sort lower part
        sort(array, j+1, high);               // recursively sort higher part
    }

    // Returns the median of three indices passed in. This is called
    // by the medianOf5 method when it narrows down to three numbers.
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

    // Returns the best three candidates for the medianOf3 function.
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

        return medianOf3(array, c1, c2, c3);
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
        int N = 1000000;
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

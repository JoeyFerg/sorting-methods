/**
 * Programmed by Joey Ferguson
 * 5 February 2018
 */

public class Bubble extends Sorting {

    // Simple Bubble sort method callable from outside the class
    public static void sort(Comparable[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (less(array[i + 1], array[i])) {
                    sorted = false;
                    exchange(array, i, i + 1);
                }
            }
        }
    }

    private static Double[] populateArray(int numToSort) {
        Double[] randomArray = new Double[numToSort];
        for (int randoms = 0; randoms < numToSort; randoms++) {
            randomArray[randoms] = StdRandom.uniform();
        }

        return randomArray;
    }

    public static void main(String[] args) {
        int N = 10000;

        for (int numToSort = N ; numToSort <= 64 * N; numToSort *= 2) {
            Double[] arrayToSort = populateArray(numToSort);

            Stopwatch timer = new Stopwatch();
            sort(arrayToSort);
            StdOut.println(numToSort + " => " + timer.elapsedTime() + " seconds.");
        }
    }
}

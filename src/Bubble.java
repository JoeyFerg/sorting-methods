/**
 * Programmed by Joey Ferguson
 * 16 June 2017
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

    public static void main(String[] args) {
        int N = 1000;
        for (int numToSort = N; numToSort <= 16 * N; numToSort *= 2) {
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

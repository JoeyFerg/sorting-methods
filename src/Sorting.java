/**
 * Programmed by Joey Ferguson
 * 5 February 2018
 */

// This is a class that sorting algorithms can extend in order
// to easily add functionality to compare and exchange items.
public class Sorting {

    // Returns true if v is less than w, false if w is less than v
    static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Swaps array[i] and array[j]
    static void exchange(Object[] array, int i, int j) {
        Object swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    public static void main(String[] args) {}
}

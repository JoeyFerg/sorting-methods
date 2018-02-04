import java.text.DecimalFormat;

/**
 * Programmed by Joey Ferguson
 * 16 June 2017
 */

public class DoublingTest {

    // Prints the results of calling multiple algorithms at once
    // and allows comparison of their times and ratios
    private static void doublingTest(int N, int sortType) {
        DecimalFormat rt = new DecimalFormat("#.####");
        DecimalFormat et = new DecimalFormat("##.##");

        double elapsedTime;
        double prevTime = 0.0;

        for (int numToSort = N; numToSort <= (32 * N); numToSort *= 2) {
            Double[] randomArray = new Double[numToSort];
            for (int randoms = 0; randoms < numToSort; randoms++) {
                randomArray[randoms] = StdRandom.uniform();
            }

            Stopwatch timer = new Stopwatch();
            if      (sortType == 0) {        Insertion.sort(randomArray); }
            else if (sortType == 1) {        Selection.sort(randomArray); }
            else if (sortType == 2) {            Shell.sort(randomArray); }
            else if (sortType == 3) {           Bubble.sort(randomArray); }
            else if (sortType == 4) { QuickSortMedian3.sort(randomArray); }
            else if (sortType == 5) { QuickSortMedian5.sort(randomArray); }
            else if (sortType == 6) {            Quick.sort(randomArray); }
            elapsedTime = timer.elapsedTime();

            double ratio = 0.0;

            // Printing stats and headers
            if (numToSort != N) { ratio = ratio(elapsedTime, prevTime); }
            else { StdOut.println("Items\t\t Time\t\t Ratio"); }

            int numLength = String.valueOf(numToSort).length();      // for formatting numbers when printing to console
            if (numLength <= 7) {
                StdOut.println(numToSort + "\t\t" + " " + et.format(elapsedTime) + "\t\t" + " " + rt.format(ratio));
            } else {
                StdOut.println(numToSort + "\t" + " " + et.format(elapsedTime) + "\t\t" + " " + rt.format(ratio));
            }

            prevTime = elapsedTime;
        }
        StdOut.println();
    }

    // Calculates the ratio of the current time compared to the previous time
    private static double ratio(double elapsedTime, double prevTime) {
        return (elapsedTime/prevTime);
    }

    public static void main(String[] args) {
        StdOut.println("Insertion Sort");
        doublingTest(10000, 0);

        StdOut.println("Selection Sort");
        doublingTest(10000, 1);

        StdOut.println("Shell Sort");
        doublingTest(10000, 2);

        StdOut.println("Bubble Sort");
        doublingTest(10000, 3);

        StdOut.println("Quick Sort Median 3");
        doublingTest(1000000, 4);

        StdOut.println("Quick Sort Median 5");
        doublingTest(1000000, 5);

        StdOut.println("Quick Sort");
        doublingTest(1000000, 6);
    }
}

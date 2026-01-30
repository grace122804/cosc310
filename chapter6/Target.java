package chapter6;

import java.io.PrintWriter;
import java.util.ArrayList;

abstract public class Target {
    public static final int TRIALS = 5;

    protected int arr[];
    protected ArrayList<Integer> list;
    protected String name; // format: array,random_access etc.

    private long times[] = new long[TRIALS];
    private int checksums[] = new int[TRIALS];

    public Target(int arr[], ArrayList<Integer> list, String name) {
        this.arr = arr;
        this.list = list;
        this.name = name;
    }

    // method under test
    abstract public int method(int indicesOrnums[]);

    public double runTests(int indicesOrnums[]) {
        long total = 0;

        for (int i = 0; i < TRIALS; i++) {
            long start = System.nanoTime();
            int result = method(indicesOrnums);
            long end = System.nanoTime();

            long elapsed = end - start;
            times[i] = elapsed;
            checksums[i] = result;
            total += elapsed;
        }
        return total / (double) TRIALS;
    }

    public void writeResults(PrintWriter out) {
        for (int i = 0; i < TRIALS; i++) {
            out.printf(
                "%s,%d,%.2f,%d\n",
                name,
                i + 1,
                times[i] / 1_000_000.0,
                checksums[i]
            );
        }
    }
}

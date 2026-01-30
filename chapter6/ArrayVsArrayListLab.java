package chapter6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {

    public static void main(String[] args) throws IOException {

        int[] arr = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");

        Random r = new Random();
        int[] data = new int[200_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(arr.length);
        }

        PrintWriter out = new PrintWriter(new File("results.csv"));

        Target[] tests = {
            new ArrayRandom(arr, list, "array,random_access"),
            new ListRandom(arr, list, "arraylist,random_access"),

            new ArrayAppend(arr, list, "array,append"),
            new ListAppend(arr, list, "arraylist,append"),

            new ArrayInsert(arr, list, "array,insert_front"),
            new ListInsert(arr, list, "arraylist,insert_front"),

            new ArrayRemove(arr, list, "array,remove_front"),
            new ListRemove(arr, list, "arraylist,remove_front")
        };

        double[] avgs = new double[tests.length];

        for (int i = 0; i < tests.length; i++) {
            avgs[i] = tests[i].runTests(data);
            tests[i].writeResults(out);
        }

        out.close();

        // Console summary
        String[] ops = {
            "random_access", "append", "insert_front", "remove_front"
        };

        for (int i = 0; i < ops.length; i++) {
            double arrayAvg = avgs[i * 2] / 1_000_000.0;
            double listAvg = avgs[i * 2 + 1] / 1_000_000.0;
            String winner = arrayAvg < listAvg ? "array" : "arraylist";

            System.out.printf(
                "Operation: %s array avg: %.2f ms arraylist avg: %.2f ms winner: %s%n",
                ops[i], arrayAvg, listAvg, winner
            );
        }
    }
}

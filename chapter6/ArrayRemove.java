package chapter6;

import java.util.ArrayList;

public class ArrayRemove extends Target {

    public ArrayRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] ignored) {
        int removed = 0;
        int[] smaller = new int[arr.length - 20_000];

        for (int i = 20_000; i < arr.length; i++) {
            smaller[i - 20_000] = arr[i];
            removed++;
        }
        return removed;
    }
}

    

package chapter6;

import java.util.ArrayList;

public class ListRemove extends Target {

    public ListRemove(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] ignored) {
        ArrayList<Integer> copy = new ArrayList<>(list);
        int removed = 0;

        for (int i = 0; i < 20_000; i++) {
            copy.remove(0);
            removed++;
        }
        return removed;
    }
}

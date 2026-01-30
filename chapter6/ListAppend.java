package chapter6;

import java.util.ArrayList;

public class ListAppend extends Target {

    public ListAppend(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] nums) {
        int sum = 0;
        ArrayList<Integer> copy = new ArrayList<>(list);

        for (int n : nums) {
            copy.add(n);
            sum += n;
        }
        return sum;
    }
}

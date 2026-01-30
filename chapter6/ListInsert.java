package chapter6;

import java.util.ArrayList;

public class ListInsert extends Target {

    public ListInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] nums) {
        int sum = 0;
        ArrayList<Integer> copy = new ArrayList<>(list);

        for (int i = nums.length - 1; i >= 0; i--) {
            copy.add(0, nums[i]);
            sum += nums[i];
        }
        return sum;
    }
}

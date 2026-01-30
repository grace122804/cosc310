package chapter6;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAppend extends Target {

    public ArrayAppend(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] nums) {
        int sum = 0;
        int[] larger = Arrays.copyOf(arr, arr.length + nums.length);

        for (int i = 0; i < nums.length; i++) {
            larger[arr.length + i] = nums[i];
            sum += nums[i];
        }
        return sum;
    }
}

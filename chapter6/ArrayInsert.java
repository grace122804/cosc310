package chapter6;

import java.util.ArrayList;

public class ArrayInsert extends Target {

    public ArrayInsert(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] nums) {
        int sum = 0;
        int[] larger = new int[arr.length + nums.length];

        for (int i = 0; i < nums.length; i++) {
            larger[i] = nums[i];
            sum += nums[i];
        }

        for (int i = 0; i < arr.length; i++) {
            larger[i + nums.length] = arr[i];
            sum += arr[i];
        }
        return sum;
    }
}

package chapter6;

import java.util.ArrayList;

public class ArrayRandom extends Target {

    public ArrayRandom(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indices) {
        int sum = 0;
        for (int i : indices) {
            sum += arr[i];
        }
        return sum;
    }
}



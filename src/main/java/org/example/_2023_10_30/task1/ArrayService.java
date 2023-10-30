package org.example._2023_10_30.task1;

public class ArrayService {
    public int[] getArrayBySize(int size){
        if (size < 0) {
          throw new IllegalArgumentException("The array size cannot be negative!");
        }
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}

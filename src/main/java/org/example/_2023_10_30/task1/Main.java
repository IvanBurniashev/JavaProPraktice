package org.example._2023_10_30.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayService arrayService = new ArrayService();
        int[] array = arrayService.getArrayBySize(7);
        System.out.println(Arrays.toString(array));
    }
}

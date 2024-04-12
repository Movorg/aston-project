package com.aston.homework.lesson4;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {17, 30, 29, 128, 35, 133, 149, 516, 2, 105};

        System.out.println("The source array: " + Arrays.toString(array));

        BubbleSort.bubbleSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));


        MyArrayList<Integer> array1 = new MyArrayList<>();
        array1.add(17);
        array1.add(30);
        array1.add(29);
        array1.add(128);
        array1.add(35);
        array1.add(133);
        array1.add(149);
        array1.add(516);
        array1.add(2);
        array1.add(105);

        BubbleSort.bubbleSort(array1);
        System.out.println("Sorted collection: " + array1);
    }
}

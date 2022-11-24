//You are given an array of integers numbers and an integer pivot . Let countGreater denote how many integers within numbers are greater than pivot, and countless denote how many integers are less than pivot
//        Your task is to compute countGreater and countLess, then return:
//        • 'greater! if countGreater is greater than countless
//
//        • "smaller" if countGreater is less than countless;
//        • "tie" if they are equal.

public class PivotArray {
    public static void main(String[] args) {
//        int[] numbers = new int[]{1, 3, 0, -1, 1, 4, 3};
//        int pivot = 2;
//        int[] numbers = new int[]{3, 4, 5, 1, 0};
//        int pivot = 3;
        int[] numbers = new int[]{9, 8, -5};
        int pivot = -1;
        Solution(numbers, pivot);
    }

    public static void Solution(int[] arr, int pivot) {
        int greater = 0;
        int lesser = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) lesser++;
            else if (arr[i] > pivot) greater++;
        }
        if (lesser < greater) System.out.println("greater");
        else if (greater < lesser) System.out.println("smaller");
        else System.out.println("tie");
    }
}

package ZipRecruiter;

import java.util.ArrayList;

public class DataCorruption {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 5}, {1, 4}, {2, 4}, {1, 5}};
        Solution(arr);
    }

    public static void Solution(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] ints : arr) {
            if (!list.contains(ints[0])) list.add(ints[0]);
            if (!list.contains(ints[1])) list.add(ints[1]);

        }
        Object[] objects = list.toArray();
        for (Object obj : objects) System.out.print(obj + " ");

    }

}


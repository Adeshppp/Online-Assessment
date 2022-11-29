import java.util.HashSet;

public class OddLength {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 10, 7};
        Solution(arr);
    }

    public static void Solution(int[] arr) {
        int n = arr.length;
        int z = 1;
        int[] data = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) Combinations(arr, data, 0, n - 1, 0, i, set);
//        System.out.println(set);
        int sum = 0;
        for (Integer e : set) sum += e;
        System.out.println(sum);

    }

    public static void Combinations(int[] arr, int[] data, int start, int end, int index, int r, HashSet<Integer> set) {
        if (index == r) {
            int count = 0;
            int sum = 0;
            for (int i = 0; i < r; i++) {
                sum += data[i];
                count++;
//                System.out.print(data[i] + " ");
            }
//            System.out.println();
//            System.out.println("sum : " + sum);
            if (count % 2 == 1) set.add(sum);
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            Combinations(arr, data, i + 1, end, index + 1, r, set);
        }
    }
}

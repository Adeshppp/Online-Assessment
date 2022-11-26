package ZipRecruiter;

public class SortArray {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 5, 7, 3, 2, 1};
//        int[] arr = new int[]{6, 7, 8, 8, 5, 3, 2};
        int[] arr = new int[]{6, 6, 6, 6, 6, 6, 6};
        Solution(arr);
    }

    public static void Solution(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i = i + 2) {

            if (i == n - 1 || n == 1) break;
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
}

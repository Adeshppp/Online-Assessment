public class ArrayPair {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        solve(arr);
    }

    public static void solve(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= n; i = i + 2) {
            if (i >= n) break;
            if (arr[i - 1] > arr[i]) {
                int z = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = z;
            }
//            System.out.print(i + " : ");
//            System.out.println(arr[i]);

        }
        for (int j : arr) System.out.print(j + " ");
    }
}

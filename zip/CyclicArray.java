import java.util.Arrays;

public class CyclicArray {
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 2, 1, 5, 4};
//        int[] arr = new int[]{1, 4, 2, 3};
//        int[] arr = new int[]{98};
        int[] arr = new int[]{2, 4};
        Solution(arr);
    }

    public static void Solution(int[] arr) {
        int flag = 0;
        if (arr.length < 1) {
            System.out.println("-1");
            flag = 1;
        }
        if (flag == 0) {
            int[] sorted = new int[arr.length];
            System.arraycopy(arr, 0, sorted, 0, arr.length);
            for (int p = 0; p < arr.length; p++) {
                for (int d = p; d < arr.length; d++) {
                    if (sorted[p] < sorted[d]) {
                        int tempi = sorted[d];
                        sorted[d] = sorted[p];
                        sorted[p] = tempi;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                int z = i;
                int[] temp = new int[arr.length];
                for (int j = 0; j < arr.length; j++) {
                    temp[j] = arr[z++];
                    if (z == arr.length) z = 0;
                }
                if (Arrays.equals(temp, sorted)) {
                    System.out.println(i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) System.out.println("-1");
        }
    }
}

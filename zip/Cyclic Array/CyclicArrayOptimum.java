package zip;

public class CyclicArrayOptimum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 4};
//        int[] arr = new int[]{1, 4, 2, 3};
//        int[] arr = new int[]{98};
//        int[] arr = new int[]{2, 1, 0, -1, 5, 4, 3};
        System.out.println("op : " + Solution(arr));
    }

    public static int Solution(int[] arr) {
        int result = 0;
        int flag = 0;
        if (arr.length < 1) {
            System.out.println("-1");
            flag = 1;
        }

        //=============================more space complexity===============================
//        if (flag == 0) {
//            int[] sorted = new int[arr.length];
//            System.arraycopy(arr, 0, sorted, 0, arr.length);

//
//            //sort given array in reverse order
//            Arrays.sort(sorted);
//            for (int i = 0; i < sorted.length / 2; i++) {
//                int temp = sorted[i];
//                sorted[i] = sorted[sorted.length - 1 - i];
//                sorted[sorted.length - 1 - i] = temp;
//            }

//            for (int i = 0; i < arr.length; i++) {
//                int z = arr.length - 1 - i;
//                int[] temp = new int[arr.length];
//                for (int j = 0; j < arr.length; j++) {
//                    temp[j] = arr[z++];
//                    System.out.print(temp[j] + " ");
//                    if (z == arr.length) z = 0;
//                }
//                System.out.println();
//                if (Arrays.equals(temp, sorted)) {
//                    result = i + 1;
//                    flag = 1;
//                    break;
//                }
//            }
//            if (flag == 0) result = -1;
//        }for (int i : arr) System.out.print(i + " ");

        //=============================time complexity is more==============================
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == arr.length - 2 && arr[i] > arr[i + 1]) return 0;
            if (arr[i] > arr[i + 1]) continue;
            break;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            int index = arr.length - 1 - i;
            int z = 0;
            int com = arr[index++];
            if (index == arr.length) index = 0;
            for (int j = index; j < arr.length; j++) {
                if (com < arr[j]) break;
                else {
                    com = arr[j];
                    count++;
                }
                if (count == arr.length - 1) return i + 1;
                if (j == arr.length - 1) j = -1;
                z++;
                if (z == arr.length) break;
            }
        }
        return -1;
    }
}

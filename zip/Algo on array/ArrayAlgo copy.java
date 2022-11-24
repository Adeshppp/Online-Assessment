public class ArrayAlgo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 5, 2, 3};
        Solution(arr);
    }

    public static void Solution(int[] arr) {
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            int index = 0;
            int p = 0;
            System.out.print("array before :");
            for (int j = 0; j < arr.length; j++) System.out.print(arr[j] + " ");
            System.out.println();
            System.out.println("i " + i + " : " + arr[i]);
            if (arr[i] == 0) continue;
            int x = arr[i];
            System.out.println("count : " + count);
            System.out.println("x : " + x);
            for (int j = i; j < arr.length; j++) {
                System.out.print("j : " + j + " ");
                if (arr[j] < x) {
                    count += x;
                    i = index - 1;
                    System.out.println("Breaking......!");
                    break;
                }
                if (j == arr.length - 1 && arr[j] < x) {
                    count += x;
                    System.out.println("Breaking......!");
                    break;
                }
                arr[j] = arr[j] - x;
                if (arr[j] != 0 && p == 0) {
                    index = j;
                    p++;
                }
                System.out.println("arr[j] : " + arr[j] + " index " + index);
                i = index - 1;

            }
            System.out.println();
            System.out.print("array after :");
            for (int j = 0; j < arr.length; j++) System.out.print(arr[j] + " ");
            System.out.println();
            System.out.println("===================================================");
        }
        System.out.println(count);

    }
}

import java.util.Scanner;


public class ProcessingTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tasks : ");
        int n = sc.nextInt();
        int m = 3;
        int[][] arr = new int[n][m];
        System.out.println("Enter Start End and period of each task:");
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = sc.nextInt();
        System.out.println("Minimum time computer can perform all the tasks : " + MinTasks(arr, n, m));
    }

    public static int MinTasks(int[][] arr, int n, int m) {
        int temp = 0;
        for (int i = 0; i < n; i++) if (temp < arr[i][1]) temp = arr[i][1];
        sort(arr, n, m);//sort according to end in descending order
        int[] computer = new int[temp];
        for (int i = 0; i < temp; i++) computer[i] = 0;
        int r = 2;
        for (int i = temp - 1; i >= 0; i--) {
            int z = arr[r][1] - arr[r][0] + 1;
            if (z > arr[r][2]) z = arr[r][2];
            for (int h = 0; h < z - 1; h++) computer[i--] = 1;
            if (r == 0) break;
            r--;
        }
        int count = 0;
        for (int i = 0; i < temp; i++) if (computer[i] == 1) count++;
        return count;
    }

    public static void sort(int[][] arr, int n, int m) {
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][1] < arr[j][1]) {
                    int[] z = arr[i];
                    arr[i] = arr[j];
                    arr[j] = z;
                }
            }

        }
    }
}

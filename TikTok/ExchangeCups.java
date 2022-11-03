package TikTok;

import java.util.Scanner;

public class ExchangeCups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bottles on a shelf : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Current arrangement of bottles : ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Number of swap required to be in sorting : " + noOfSwap(arr, n));
    }

    public static int noOfSwap(int[] arr, int n) {
        int count = 0;
        int ptr = n - 1;
        int p = -1;
        int z = 0;

        for (int j = 0; j < n / 2; j++) {
            int largest = 0;
            for (int i = 0; i < n - j; i++)
                if (arr[i] > largest) {
                    largest = arr[i];
                    p = i;
                } else break;
            if (arr[ptr] != largest) {
                z = arr[p];
                arr[p] = arr[ptr];
                arr[ptr--] = z;
                count++;
            }

        }

        return count;
    }
}



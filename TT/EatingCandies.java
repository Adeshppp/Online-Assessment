package TikTok;

import java.util.Scanner;

public class EatingCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of candies : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter weight of each candy : ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("total no of candies eaten by Alice and Bob : " + totalWeight(arr, n));

    }

    public static int totalWeight(int[] arr, int n) {
        int i = -1;
        int j = n;
        int a = 0;
        int b = 0;
        while (arr[i + 1] == 0) i++;
        while (arr[j - 1] == 0) j--;
        a = arr[i + 1];
        b = arr[j - 1];
        i++;
        j--;
        while (i < j) {
            if (a < b) a += arr[i++];
            else if (a > b) b += arr[j--];
            if (a == b && (i == j - 1 || j - 1 == i + 1 || i + 1 == j)) break;
        }
        if (a != b || i >= j) {
            a = 0;
            b = 0;
        }
        return a + b;
    }
}

package Barclays.Me;

import java.util.Scanner;

public class BeautifulHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int n = sc.nextInt();
        System.out.print("Enter number of cols : ");

        int m = sc.nextInt();
        System.out.println("Enter 1 and 0 : ");

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) grid[i][j] = sc.nextInt();
        }
        System.out.println("Beautiful houses in a city : " + CountBeautifulHouses(grid, n, m));
    }

    public static int CountBeautifulHouses(int[][] grid, int n, int m) {

        if (n == 0 || m == 0) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fun(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void fun(int[][] grid, int n, int m) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid.length || grid[n][m] != 1) return;
        grid[n][m] = 2;
        fun(grid, n + 1, m);
        fun(grid, n + 1, m + 1);
        fun(grid, n + 1, m - 1);
        fun(grid, n, m - 1);
        fun(grid, n, m + 1);
        fun(grid, n - 1, m);
        fun(grid, n - 1, m - 1);
        fun(grid, n - 1, m + 1);
    }

}

import java.util.Arrays;
import java.util.Scanner;

public class LargestPlot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] houses = new int[size + 1][2];
        houses[0][0] = size;
        houses[0][1] = 2;
        System.out.println("Enter house number and position of the house : ");
        for (int i = 1; i < size + 1; i++) {
            houses[i][0] = sc.nextInt();
            houses[i][1] = sc.nextInt();
        }
//        System.out.println(availablePlot(houses));
        availablePlot(houses);
    }

    public static void swap(int i, int j, int[][] houses) {
        int[] z = houses[i];
        houses[i] = houses[j];
        houses[j] = z;

    }

    public static void print(int[][] houses) {
        for (int i = 1; i < houses.length; i++) System.out.print(Arrays.toString(houses[i]) + " ");
    }

    public static void availablePlot(int[][] houses) {
        int n = houses[0][0];
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (houses[i][1] > houses[j][1]) swap(i, j, houses);
            }
        }
//        print(houses);
        int largest = 0;
        int z = 0;
        for (z = 0; z < n - 1; z++) {
            int q = houses[z][1] - houses[z + 1][1];
            if (q < 0) q = -q;
            if (q > largest) largest = q;
        }
        int a = houses[z][0];
        int b = houses[z + 1][0];
        if (a > b) {
            int q = a;
            a = b;
            b = q;
        }
        System.out.println(a + " " + b);
    }
}

import java.util.Arrays;

public class Stock {
    public static void main(String[] args) {
        int[] prices = new int[]{2, 4, 1, 5, 2, 6, 7};
        int[] algo = new int[]{0, 1, 0, 0, 1, 0, 0};
        int[] large = new int[4];
        int n = 4;
        for (int i = 0; i < prices.length - n + 1; i++) {
            int sum = 0;
            int z = 0;
            while (z < i) {
                sum = cal(prices[z], algo[z], sum);
                z++;
            }
            for (int j = i; j < i + 4; j++) {
                z = j;
                sum = cal(prices[z], 1, sum);
            }
            z++;
            while (z < prices.length) {
                sum = cal(prices[z], algo[z], sum);
                z++;
            }
            large[i] = sum;
        }
        Arrays.sort(large);
        System.out.println("highest revenue : " + large[large.length - 1]);
    }

    public static int cal(int val, int algo, int sum) {
        if (algo == 1) sum += val;
        else sum -= val;
        return sum;
    }
}

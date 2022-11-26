package ZipRecruiter.Piyush;

import java.util.HashMap;
import java.util.Map;

public class Lamp {
    public static void main(String[] args) {
        int[][] lamps = new int[][]{{-2, 3}, {2, 3}, {2, 1}};
//        int[][] lamps = new int[][]{{-2, 1}, {2, 1}};
        Solution(lamps);
    }

    public static void Solution(int[][] lamps) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lamps.length; i++) {
            int temp = lamps[i][0] - lamps[i][1];

            while (temp < lamps[i][0] + lamps[i][1] + 1) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                temp++;

            }
        }
        int i = 0;
        int index = 0;
        int hit = 0;
        int count = 0;
        for (int key : map.keySet()) {
            if (count == 0) {
                i = map.get(key);
                index = key;
                count++;
                continue;
            }
            if (i < map.get(key)) {
                hit = 1;
                i = map.get(key);
                index = key;
                continue;
            } else if (i == map.get(key)) {
                if (index > key) {
                    index = key;
                }
            }

        }
        System.out.println(index);
    }
}

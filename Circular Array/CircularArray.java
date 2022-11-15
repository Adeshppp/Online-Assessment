import java.util.HashMap;
import java.util.Map;

public class CircularArray {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[]{1, 5, 10, 5};
        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=1;i<11;i++) map.put(i,0);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int z = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = z;
            }
            for (int j = arr[i]; j < arr[i + 1] + 1; j++) map.put(j, map.getOrDefault(j, 0) + 1);

        }
        int large = 0;
        int lk = 0;
//        System.out.println(map);
        for (int i : map.keySet()) {
//            System.out.println("key : " + i);
            if (large < map.get(i)) {
                large = map.get(i);
                lk = i;
            }
        }
        System.out.println(lk);
    }
}

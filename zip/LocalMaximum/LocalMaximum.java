import java.util.Arrays;
import java.util.HashMap;

public class LocalMaximum {
    private static final HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 2, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 3, 0, 0, 3}};
        int[][] result = null;
        result = Solution(arr);
        for (int[] ints : result) System.out.println(Arrays.toString(ints));
    }

    public static int[][] Solution(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {//looping rows
            for (int j = 0; j < arr[0].length; j++) {//looping cols
                if (arr[i][j] != 0 && Check(arr, i, j)) {//checking element is local maximum or not?
                    count++;// for declaring the size of result array
                    map.put(i, j);// if yes putting it in hashmap
                }
            }
        }
        int[][] result = new int[count][2];
        int key = 0;
        for (int i : map.keySet()) {//putting key,value pair in two-dimensional array
            result[key][0] = i;
            result[key++][1] = map.get(i);
        }
        return result;//returning two-dimensional result array
    }

    public static Boolean Check(int[][] arr, int a, int b) {
        int count = 0;
        int size = (arr[a][b] * 2) + 1;// given formula for square
        int side = size / 2;
        int Li = a - side;//lower i index
        int Lj = b - side;//lower j index
        int Hi = a + side;//Higher i index
        int Hj = b + side;//Higher j index
        for (int i = Li; i <= Hi; i++) {//looping from lower i and j
            for (int j = Lj; j <= Hj; j++) {// to looping till higher i and j
                if (i == a && j == b) continue;
                else {
                    if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length) {//upper and lower limit
                        if ((i == Li && j == Lj) || (i == Hi && j == Hj) || (i == Hi && j == Lj) || (i == Li && j == Hj))//corner cases
                            continue;
                        else {
                            if (arr[a][b] < arr[i][j]) {//checking each element with the centered element
                                return false;
                            } else if (arr[a][b] == arr[i][j]) {
                                count++;
                                if (count > 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

import java.util.Scanner;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of processes: ");

        int a = sc.nextInt();
        int[] at = new int[a];

        System.out.print("Enter the request time of processes: ");
        for (int i = 0; i < a; i++) {
            at[i] = sc.nextInt();
        }

        int[] bt = new int[a];

        System.out.print("Enter the duration of each process: ");
        for (int i = 0; i < a; i++) {
            bt[i] = sc.nextInt();
        }

        System.out.println("avg waiting time is " + averageWait(at, bt, a));
    }

    public static void swap(int i, int j, int[] at, int[] bt) {
        int z = at[i];
        at[i] = at[j];
        at[j] = z;
        z = bt[i];
        bt[i] = bt[j];
        bt[j] = z;

    }

    public static float averageWait(int[] at, int[] bt, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (bt[i] > bt[j]) swap(i, j, at, bt);
            }
        }
        int[] s = new int[size];
        for (int i : s) s[i] = 0;
        int time = 0;
        int wait = 0;
        int count = 0;

        for (int i = 0; i < size; i++) {
//            System.out.println(" start : " + i);
            if (at[i] <= time && s[i] == 0) {
//                System.out.println("i at beginning : " + i);
//                System.out.print("wait before : " + wait);
                s[i] = 1;
//                System.out.println(" TIME  : " + time);
//                System.out.println(" arriving time : " + at[i]);
                wait += time - at[i];
//                System.out.println(" wait after : " + wait);
//                System.out.println(" execution time  : " + bt[i]);
                time += bt[i];
//                System.out.println(" TIME after : " + time);

                count++;
//                System.out.println("count is " + count);
//                System.out.println("next iteration");
//                System.out.println("i : " + i);
            }


            if (count == size) {
//                System.out.print("Reached to break!!!");
                break;
            }
            if (i == size - 1) i = -1;
//            System.out.println("i after : " + i);
        }
//        System.out.println("wait : " + wait);
//        System.out.println("size : " + size);
//        System.out.println("avg : " + (float) wait / size);

        return ((float) wait / size);

    }
}

import java.util.Scanner;

public class TerroristProb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string by agent : ");
        String s = sc.nextLine();
        System.out.print("Enter the name told by agent : ");

        String name = sc.nextLine();
        System.out.println("No of terrorist going to attack the army base : " + find(s, name));
    }

    public static int find(String s, String name) {
        int count = 0;
        s = s.toLowerCase();
        name = name.toLowerCase();

        int b = name.length();
        for (int i = 0; i < s.length() - name.length() + 1; i++) {
            String str = s.substring(i, b);
            b += 1;
            if (str.equals(name)) count++;
        }
        return count;
    }
}

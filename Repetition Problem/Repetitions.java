import java.util.HashMap;
import java.util.Map;

public class Repetitions {
    public static void main(String[] args) {
//        String str = "The Sun is the star at the center of the Solar System. It is a nearly perfect sphere of hot plasma, with internal convective motion that generates a magnetic field via a dynamo process.• It is, by far, the most important • source of energy for• life on Earth.";
        String str = "the the the the the is is is of of of it it a a a The";
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        String key = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') key += Character.toString(str.charAt(i));
            else {
                String n = key;
                if (key.charAt(0) == ' ') n = key.substring(1);
                else n = key;
                map.put(n, map.getOrDefault(n, 0) + 1);
                key = " ";
            }
        }
        int rep = 0;
        for (int val : map.values()) rep += val - 1;
        System.out.println(rep);
    }
}

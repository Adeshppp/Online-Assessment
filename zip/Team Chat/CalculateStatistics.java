import java.util.*;

public class CalculateStatistics {
    public static void main(String[] args) {
        String[] members = new String[]{"id42", "id158", "id23"};
        String[][] events = new String[][]{{"MESSAGE", "0", "ALL id158 id142"},
                {"OFFLINE", "1", "id158"},
                {"MESSAGE", "2", "id158 id158"},
                {"OFFLINE", "3", "id23"},
                {"MESSAGE", "60", "HERE id158 id42 id23"},
                {"MESSAGE", "61", "HERE"}};

//        String[] members = new String[]{"id1", "id2", "id3"};
//        String[][] events = new String[][]{{"MESSAGE", "0", "id1"},
//                {"MESSAGE", "9", "HERE id3"},
//                {"MESSAGE", "6", "ALL"},
//                {"MESSAGE", "100", ""},
//                {"OFFLINE", "200", "id3"}};
        Solution(members, events);
    }

    public static void Solution(String[] members, String[][] arr) {
        Set<String> set = new HashSet<>();

        Map<String, Integer> active = new HashMap<>();
        Map<String, Integer> notify = new HashMap<>();
        for (String each : members) active.put(each, 0);
        for (String each : members) notify.put(each, 0);

        for (int i = 0; i < arr.length; i++) {
            String[] ids = null;
            ids = arr[i][2].split(" ");
            if (ids.length == 0 || (ids.length == 1 && ids[0].equals(""))) continue;
            set.clear();
            if (arr[i][0].equals("MESSAGE")) {
                for (int j = 0; j < ids.length; j++) {
                    if (ids[j].equals("ALL")) {
                        for (String each : members) notify.put(each, notify.getOrDefault(each, 0) + 1);
                        break;
                    } else if (ids[j].equals("HERE")) for (String each : members) {
                        if (active.get(each) <= Integer.parseInt(arr[i][1])) set.add(each);
                    }
                    else set.add(ids[j]);

                }
                Iterator<String> mit = set.iterator();
                while (mit.hasNext()) {
                    String temp = mit.next();
                    notify.put(temp, notify.get(temp) + 1);
                }
            } else if (arr[i][0].equals("OFFLINE")) {
                for (int j = 0; j < ids.length; j++) {
                    if (ids[j].equals("ALL")) {
                        for (String each : members)
                            active.put(each, active.get(each) + 60 + Integer.parseInt(arr[i][1]));
                        break;
                    } else if (ids[j].equals("HERE")) for (String each : members) {
                        if (active.get(each) <= Integer.parseInt(arr[i][1])) set.add(ids[j]);
                    }
                    else set.add(ids[j]);

                }
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String temp = it.next();
                    active.put(temp, active.get(temp) + 60 + Integer.parseInt(arr[i][1]));
                }
            }
        }

        //printing results
        String[] result = new String[members.length];
        int i = 0;
        for (String key : notify.keySet()) {
            String str = key + "=" + notify.get(key);
            result[i++] = str;
        }
        Arrays.sort(result);
        for (i = 0; i < result.length; i++) System.out.print(result[i] + " ");
        System.out.println();
    }


}
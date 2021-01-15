package String;

import javafx.util.Pair;

import java.util.*;

public class _1152_AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> userMap = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < username.length; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair<Integer, String>(timestamp[i], website[i]));
        }

        for (String s : userMap.keySet()) {
            List<Pair<Integer, String>> list = userMap.get(s);
            Collections.sort(list, (l1, l2) -> (l1.getKey() - l2.getKey()));
        }

        String res = "";

        for (String s : userMap.keySet()) {
            Set<String> set = new HashSet<>();
            List<Pair<Integer, String>> list = userMap.get(s);

            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String pattern = list.get(i).getValue() + " " + list.get(j).getValue() + " " + list.get(k).getValue();

                        if (!set.contains(pattern)) {
                            set.add(pattern);
                            count.put(pattern, count.getOrDefault(pattern, 0) + 1);
                        }

                        if (res == "" || count.get(res) < count.get(pattern) || (count.get(res) == count.get(pattern) && pattern.compareTo(res) < 0)) {
                            res = pattern;
                        }
                    }
                }
            }
        }

        List<String> ret = new LinkedList<>();
        String[] webs = res.split(" ");
        for (String web : webs) {
            ret.add(web);
        }

        return ret;
    }
}

import java.util.*;

public class _1181_BeforeandAfterPuzzle {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        //Solution One:
        Map<String, Set<String>> head = new HashMap<>();
        Map<String, Set<String>> tail = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (String phrase : phrases) {
            String[] arr = phrase.split(" ");
            head.computeIfAbsent(arr[0], s -> new HashSet<>()).add(phrase);
            tail.computeIfAbsent(arr[arr.length - 1], s -> new HashSet<>()).add(phrase);
            count.put(phrase, count.getOrDefault(phrase, 0) + 1);
        }

        TreeSet<String> ans = new TreeSet<>();

        for (String end : tail.keySet()) {
            for (String h : head.getOrDefault(end, Collections.emptySet())){
                for (String t : tail.get(end)) {
                    if (!t.equals(h) || count.get(t) > 1) {
                        ans.add(h + t.substring(end.length()));
                    }
                }
            }
        }

        return new ArrayList<>(ans);

        //Solution two:
//        HashMap<String, List<Integer>> map = new HashMap<>();
//
//        for (int i = 0; i < phrases.length; i++){
//            int idx = phrases[i].indexOf(" ");
//            String key = "";
//            if (idx < 0) {
//                key = phrases[i];
//            } else {
//                key = phrases[i].substring(0, idx);
//            }
//            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(i);
//            map.put(key, list);
//        }
//
//        TreeSet<String> res = new TreeSet<>();
//        for (int i = 0; i < phrases.length; i++) {
//            String s = phrases[i];
//            int idx = s.lastIndexOf(" ");
//            String key = s.substring(idx + 1);
//            if (map.containsKey(key)) {
//                List<Integer> list = map.get(key);
//                for (Integer j : list) {
//                    if (j == i) {continue;}
//                    String toAdd = s.substring(0, idx + 1) + phrases[j];
//                    res.add(toAdd);
//                }
//            }
//        }
//        List<String> ans= new ArrayList<>(res);
//
//        return ans;
    }
}

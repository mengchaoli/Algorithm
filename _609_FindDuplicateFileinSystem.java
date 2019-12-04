import java.util.*;

public class _609_FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> results = new LinkedList<>();
        int n = paths.length;
        if (n <= 0) {
            return results;
        }

        Map<String, Set<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] split = path.split(" ");
            String filePath = split[0];
            for (int i = 1; i < split.length; i++) {
                String content = getContent(split[i]);
                String fileName = getName(split[i]);
                if (map.keySet().contains(content)) {
                    map.get(content).add(filePath + "/" + fileName);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(filePath + "/" + fileName);
                    map.put(content, set);
                }
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                results.add(new ArrayList<>(map.get(key)));
            }
        }

        return results;
    }

    private String getContent(String s) {
        int start = s.indexOf("(");
        return s.substring(start + 1);
    }

    private String getName(String s) {
        int start = s.indexOf("(");
        return s.substring(0, start);
    }

    public static void main(String[] args) {
        String[] s = new String[] {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        _609_FindDuplicateFileinSystem test = new _609_FindDuplicateFileinSystem();
        List r = test.findDuplicate(s);
        for (int i = 0 ; i < r.size(); i++) {
            System.out.println(r.get(i));
        }
    }
}

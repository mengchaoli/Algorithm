import java.util.*;

public class _726_NumberofAtoms {
    public String countOfAtoms(String formula) {
        int i = 0, n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();

        while (i < n) {
            char c = formula.charAt(i++);
            if (c == '(') {
                stack.add(map);
                map = new HashMap<>();
            } else if (c == ')') {
                Map<String, Integer> temp = map;
                map = stack.pop();
                int value = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    value = value * 10 + formula.charAt(i++) - '0';
                }
                if (value == 0) {
                    value = 1;
                }

                for (String key : temp.keySet()) {
                    map.put(key, temp.getOrDefault(key, 0) * value);
                }
            } else {
                int start = i - 1;
                while (Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String s = formula.substring(start, i);

                int value = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    value = value * 10 + formula.charAt(i++) - '0';
                }

                if (value == 0) {
                    value = 1;
                }

                map.put(s, map.getOrDefault(s, 0) + value);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key);
            if (map.get(key) > 1) {
                sb.append(map.get(key));
            }
        }

        return sb.toString();
    }
}

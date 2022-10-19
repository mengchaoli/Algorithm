package Backtracking;

import java.util.*;

/**
 * this is a plain DFS problem, we don't need to do backtracking. We need to figure out when we need to backtrack and when we don't
 * Here is a good explanation for why we don't need backtracking for this problem: https://leetcode.com/problems/evaluate-division/solutions/171649/1ms-DFS-with-Explanations/comments/319798/
 * */
public class _399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            res[i] = getWeight(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return res;
    }

    private double getWeight(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        // cases that should be rejected
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            String key = neighbor.getKey();
            Double value = neighbor.getValue();

            if (!visited.contains(key)) {
                Double productWeight = getWeight(graph, key, end, visited);

                if (productWeight != -1.0) {
                    return value * productWeight;
                }
            }
        }

        return -1.0;
    }

    /**
     * compare graph.get(start).containsKey(end) vs key.equals(end)
     * we don't use this second comparison because
     * Accepting case is (graph.get(u).containsKey(v)) rather than (u.equals(v)) for it takes O(1) but (u.equals(v)) takes O(n) for n is the length of the longer one between u and v.
     * */
//    private double getWeight(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
//        if (!graph.containsKey(start)) {
//            return -1.0;
//        }
//
//        // if (graph.get(start).containsKey(end))
//        //     return graph.get(start).get(end);
//
//        visited.add(start);
//
//        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
//            String key = entry.getKey();
//            double value = entry.getValue();
//
//            if (key.equals(end)) {
//                return value;
//            }
//
//            if (!visited.contains(key)) {
//                double productWeight = getWeight(graph, key, end, visited);
//                if (productWeight != -1.0) {
//                    return value * productWeight;
//                }
//            }
//        }
//
//        return -1.0;
//    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }
}

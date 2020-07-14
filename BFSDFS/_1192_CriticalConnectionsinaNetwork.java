package BFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1192_CriticalConnectionsinaNetwork {

    int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        int[] low = new int[n];
        int[] disc = new int[n];
        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (List<Integer> c : connections) {
            int from = c.get(0);
            int to = c.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        List<List<Integer>> res = new ArrayList<>();

        DFS(graph, disc, low, res, 0, -1);

        return res;
    }

    private void DFS(List<Integer>[] graph, int[] disc, int[] low, List<List<Integer>> res, int node, int parent) {
        disc[node] = low[node] = timer++;
        for (int neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }
            if (disc[neighbor] == -1) {
                DFS(graph, disc, low, res, neighbor, node);
                low[node] = Math.min(low[node], low[neighbor]);
                if (disc[node] < low[neighbor]) {
                    res.add(Arrays.asList(node, neighbor));
                }
            } else {
                low[node] = Math.min(disc[neighbor], low[node]);
            }
        }
    }
}

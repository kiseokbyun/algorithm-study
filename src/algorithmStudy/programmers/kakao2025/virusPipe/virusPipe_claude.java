package algorithmStudy.programmers.kakao2025.virusPipe;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class virusPipe_claude {
    // graph[type][node] = 해당 type 파이프로 연결된 이웃 노드들
    List<List<List<Integer>>> graph;

    // 감염된 노드에서 type 파이프로 이어진 곳까지 끝까지 퍼뜨린 새 상태를 반환
    private boolean[] spread(boolean[] infected, int type) {
        boolean[] next = infected.clone();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int node = 1; node < next.length; node++) {
            if (next[node]) queue.add(node);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph.get(type).get(cur)) {
                if (!next[nxt]) {
                    next[nxt] = true;
                    queue.add(nxt);
                }
            }
        }
        return next;
    }

    private int count(boolean[] infected) {
        int count = 0;
        for (boolean v : infected) {
            if (v) count++;
        }
        return count;
    }

    // prevType과 같은 종류를 연달아 여는 건 의미가 없으므로 건너뜀
    private int dfs(boolean[] infected, int remain, int prevType) {
        int best = count(infected);
        if (remain == 0) return best;

        for (int type = 1; type <= 3; type++) {
            if (type == prevType) continue;
            best = Math.max(best, dfs(spread(infected, type), remain - 1, type));
        }
        return best;
    }

    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new ArrayList<>();
        for (int type = 0; type <= 3; type++) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int node = 0; node <= n; node++) adj.add(new ArrayList<>());
            graph.add(adj);
        }
        for (int[] e : edges) {
            graph.get(e[2]).get(e[0]).add(e[1]);
            graph.get(e[2]).get(e[1]).add(e[0]);
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        return dfs(infected, k, 0);
    }

    @Test
    public void example1() {
        int[][] edges = {{1, 2, 1}, {1, 3, 1}, {1, 4, 3}, {1, 5, 2}, {5, 6, 1}, {5, 7, 1}, {2, 8, 3}, {2, 9, 2}, {9, 10, 1}};
        check(6, solution(10, 1, edges, 2));
    }

    @Test
    public void example2() {
        int[][] edges = {{1, 2, 3}, {1, 4, 3}, {4, 5, 1}, {5, 6, 1}, {3, 6, 2}, {3, 7, 2}};
        check(7, solution(7, 6, edges, 3));
    }

    private void check(int expected, int result) {
        System.out.println("result = " + result + ", expected = " + expected);
        assertEquals(expected, result);
    }
}

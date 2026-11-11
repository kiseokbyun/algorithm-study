package algorithmStudy.programmers.kakao2025.virusPipe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class virusPipe {
    int[][] edges;
    int n;

    enum Pipe {
        A(1),
        B(2),
        C(3);

        int code;
        Pipe(int code) {
            this.code = code;
        }

        public int code() {
            return this.code;
        }
    }

    private int counting(boolean[] infections) {
        int count = 0;

        for (boolean infection : infections) {
            if (infection)
                count++;
        }
        return count;
    }

    public int dfs(boolean[] infections, Pipe openPipe, int k) {
        if (k==0) {
            return counting(infections);
        }

        // 한 바퀴에 한 칸씩 퍼지므로, 더 이상 변화가 없을 때까지 반복
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int[] edge : edges) {
                if (edge[2] != openPipe.code()) continue;
                int x = edge[0]-1, y = edge[1]-1;
                if (infections[x] != infections[y]) {
                    infections[x] = infections[y] = true;
                    changed = true;
                }
            }
        }

        boolean[] infectionA = new boolean[n], infectionB = new boolean[n], infectionC = new boolean[n];
        for (int i=0; i<n; i++) {
            infectionA[i] = infections[i];
            infectionB[i] = infections[i];
            infectionC[i] = infections[i];
        }

        int a = dfs(infectionA, Pipe.A, k-1);
        int b = dfs(infectionB, Pipe.B, k-1);
        int c = dfs(infectionC, Pipe.C, k-1);
        
        return Math.max(c, Math.max(a, b));
    }

    public int solution(int n, int infection, int[][] inputEdges, int k) {
        edges = inputEdges;
        this.n = n;

        boolean[] infectionA = new boolean[n], infectionB = new boolean[n], infectionC = new boolean[n];
        for (int i=0; i<n; i++) {
            infectionA[i] = false;
            infectionB[i] = false;
            infectionC[i] = false;
        }

        infectionA[infection-1] = true;
        infectionB[infection-1] = true;
        infectionC[infection-1] = true;

        int a = dfs(infectionA, Pipe.A, k);
        int b = dfs(infectionB, Pipe.B, k);
        int c = dfs(infectionC, Pipe.C, k);
        
        return Math.max(c, Math.max(a, b));
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

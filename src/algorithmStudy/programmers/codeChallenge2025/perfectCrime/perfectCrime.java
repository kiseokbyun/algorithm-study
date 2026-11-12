package algorithmStudy.programmers.codeChallenge2025.perfectCrime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class perfectCrime {
    int[][] info;
    int n, m;

    int[][][] memory;

    static int MAX = 1000000000;

    public int dfs(int x, int a, int b) {
        if ((a>=n) | (b>=m)) {
            return MAX;
        }
        if (x>= info.length) {
            return a;
        }
        if (memory[x][a][b] != 0) {
            return memory[x][a][b];
        }

        int dustA = dfs(x+1, a+info[x][0], b);
        int dustB = dfs(x+1, a, b+info[x][1]);

        memory[x][a][b] = Math.min(dustA, dustB);

        return memory[x][a][b];
    }

    public int solution(int[][] info, int n, int m) {
        this.info = info;
        this.n = n;
        this.m = m;

        this.memory = new int [info.length][n][m];

        int result = dfs(0,0,0);
        if (result == MAX) 
            return -1;

        return result;
    }

    @Test
    public void example1() {
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        check(2, solution(info, 4, 4));
    }

    @Test
    public void example2() {
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        check(0, solution(info, 1, 7));
    }

    @Test
    public void example3() {
        int[][] info = {{3, 3}, {3, 3}};
        check(6, solution(info, 7, 1));
    }

    @Test
    public void example4() {
        int[][] info = {{3, 3}, {3, 3}};
        check(-1, solution(info, 6, 1));
    }

    private void check(int expected, int result) {
        System.out.println("result = " + result + ", expected = " + expected);
        assertEquals(expected, result);
    }
}

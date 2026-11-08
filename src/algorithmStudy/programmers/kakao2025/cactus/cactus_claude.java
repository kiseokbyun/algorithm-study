package algorithmStudy.programmers.kakao2025.cactus;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class cactus_claude {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        // 1) 칸마다 몇 번째 빗방울에 젖는지 기록 (안 젖으면 INF)
        int INF = drops.length + 1;
        int[][] time = new int[m][n];
        for (int[] row : time) {
            Arrays.fill(row, INF);
        }
        for (int k = 0; k < drops.length; k++) {
            time[drops[k][0]][drops[k][1]] = k + 1;
        }

        int[] dq = new int[Math.max(m, n)]; // 단조 덱 (인덱스 저장)

        // 2) 행마다 가로 w칸 윈도우 최솟값 → rowMin[m][cw]
        //    rowMin[i][j] = time[i][j ~ j+w-1] 중 최솟값
        int cw = n - w + 1;
        int[][] rowMin = new int[m][cw];
        for (int i = 0; i < m; i++) {
            int head = 0, tail = 0;
            for (int j = 0; j < n; j++) {
                int v = time[i][j];
                // 뒤에서 v 이상인 값 제거: 다시 최솟값이 될 수 없음
                while (tail > head && time[i][dq[tail - 1]] >= v) tail--;
                dq[tail++] = j;
                // 맨 앞이 윈도우 밖이면 제거
                if (dq[head] <= j - w) head++;
                // 윈도우가 w칸 찼으면 덱 맨 앞이 최솟값
                if (j >= w - 1) rowMin[i][j - w + 1] = time[i][dq[head]];
            }
        }

        // 3) rowMin의 열마다 세로 h칸 윈도우 최솟값 → colMin[rh][cw]
        //    colMin[r][c] = 왼쪽 위가 (r, c)인 구역이 처음 젖는 시점
        int rh = m - h + 1;
        int[][] colMin = new int[rh][cw];
        for (int j = 0; j < cw; j++) {
            int head = 0, tail = 0;
            for (int i = 0; i < m; i++) {
                int v = rowMin[i][j];
                while (tail > head && rowMin[dq[tail - 1]][j] >= v) tail--;
                dq[tail++] = i;
                if (dq[head] <= i - h) head++;
                if (i >= h - 1) colMin[i - h + 1][j] = rowMin[dq[head]][j];
            }
        }

        // 4) 가장 늦게 젖는 구역. 행 우선 + '더 클 때만' 갱신 → 동점이면 위쪽, 왼쪽 우선
        int best = -1, br = 0, bc = 0;
        for (int i = 0; i < rh; i++) {
            for (int j = 0; j < cw; j++) {
                if (colMin[i][j] > best) {
                    best = colMin[i][j];
                    br = i;
                    bc = j;
                }
            }
        }
        return new int[]{br, bc};
    }

    @Test
    public void example1() {
        int[][] drops = {{0, 0}, {3, 1}, {1, 3}, {2, 4}, {1, 1}, {2, 2}, {2, 3}, {0, 4}};
        check(new int[]{2, 2}, solution(4, 5, 2, 2, drops));
    }

    @Test
    public void example2() {
        int[][] drops = {{0, 0}, {0, 1}, {0, 2}, {1, 0}};
        check(new int[]{1, 1}, solution(3, 3, 1, 1, drops));
    }

    @Test
    public void example3() {
        int[][] drops = {{1, 2}};
        check(new int[]{0, 0}, solution(4, 6, 3, 4, drops));
    }

    @Test
    public void example4() {
        int[][] drops = {{0, 1}, {0, 3}, {0, 5}, {1, 1}, {1, 3}, {1, 5},
                         {2, 1}, {2, 3}, {2, 5}, {3, 1}, {3, 3}, {3, 5}};
        check(new int[]{3, 4}, solution(4, 6, 1, 2, drops));
    }

    @Test
    public void example5() {
        int[][] drops = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        check(new int[]{0, 0}, solution(2, 2, 2, 2, drops));
    }

    @Test
    public void example6() {
        int[][] drops = {{2, 0}, {1, 3}, {3, 2}, {0, 1}};
        check(new int[]{0, 2}, solution(4, 4, 3, 1, drops));
    }

    private void check(int[] expected, int[] result) {
        System.out.println("result = " + Arrays.toString(result) + ", expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, result);
    }
}

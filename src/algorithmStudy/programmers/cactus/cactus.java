package algorithmStudy.programmers.cactus;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class cactus {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int dh = h-1;
        int dw = w-1;
        int[] answer = {};
        int enableCactusCount = m*n;

        int[][] enableCactus = new int[m][n];
        for (int i=m-dh; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (enableCactus[i][j] == 0) {
                    enableCactus[i][j] = 1;
                    enableCactusCount--;
                }
            }
        }

         for (int j=n-dw; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (enableCactus[i][j] == 0) {
                    enableCactus[i][j] = 1;
                    enableCactusCount--;
                }
            }
        }

        for (int[] drop : drops) {
            int x = drop[0];
            int y = drop[1];

            for (int i=x; i>=(x-dh >= 0 ? x-dh : 0); i--) {
                for (int j=y; j>=(y-dw >= 0 ? y-dw : 0); j--) {
                    if (enableCactusCount == 1) {
                        break;
                    }
                    if (enableCactus[i][j] == 0) {
                        enableCactus[i][j] = 1;
                        enableCactusCount--;
                    }
                }
                
                if (enableCactusCount == 1) {
                    break;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (enableCactus[i][j] == 0) {
                    int[] tmp= {i, j};
                    return tmp;
                }
            }
        }

        return answer;
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


    private void print(int[][] arrays) {
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
    private void check(int[] expected, int[] result) {
        System.out.println("result = " + Arrays.toString(result) + ", expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, result);
    }
}

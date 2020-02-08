package algorithmStudy.dp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LIS {
    private static int [] biggestLISLength;

    public int solution(int[] array) {
        biggestLISLength = new int [array.length];
        for (int i=0; i<array.length; i++) {
            biggestLISLength[i] = 0;
        }
        int result =0;
        for (int i=0; i<array.length; i++) {
            result = Math.max(result, getBiggestLISLength(i, array));
        }

        return result;
    }

    private static int getBiggestLISLength(int index, int[] array) {
        if (index>=array.length) {
            return 0;
        }
        if (biggestLISLength[index] != 0) {
            return biggestLISLength[index];
        }

        // 남은 array중 가장 크면 1을 반환.
        boolean isMax = true;
        for (int i=index+1; i<array.length; i++) {
            isMax = isMax & (array[index] > array[i]);
        }
        if (isMax) {
            return 1;
        }

        int maxLIS=0;
        for (int i=index+1; i<array.length; i++) {
            if (array[index] < array[i]) {
                maxLIS = Math.max(maxLIS, getBiggestLISLength(i, array));
            }
        }
        biggestLISLength[index] = maxLIS + 1;
        return maxLIS + 1;
    }

    @Test
    public void test() {
        int[] array = {5, 6, 7, 8, 1, 2, 3, 4};
        
        int result = solution(array);
        assertThat(result, equalTo(4));
    }
}

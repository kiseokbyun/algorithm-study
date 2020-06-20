package algorithmStudy.programmers.stockPrice;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StockPrice {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                answer[i] = j-i;

                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution(prices);

        int[] predict = {4, 3, 1, 1, 0};
        assertThat(result).isEqualTo(predict);
    }
}

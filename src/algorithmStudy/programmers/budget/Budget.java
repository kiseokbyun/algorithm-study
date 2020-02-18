package algorithmStudy.programmers.budget;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class Budget {
    public int solution(int[] budgets, int M) {
        int[] jobs = new int[100000];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = 0;
        }

        long sum = 0;
        int maxBudget = 0;
        for (int budget : budgets) {
            if (maxBudget < budget) {
                maxBudget = budget;
            }
            jobs[budget]++;
            sum += budget;
        }

        while (sum > M) {
            sum -= jobs[maxBudget];
            jobs[maxBudget - 1] += jobs[maxBudget];
            jobs[maxBudget] = 0;
            maxBudget--;
        }

        return maxBudget;
    }
    
    @Test
    public void test() {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        int result = solution(budgets, M);
        assertThat(result, equalTo(127));
    }
    
}

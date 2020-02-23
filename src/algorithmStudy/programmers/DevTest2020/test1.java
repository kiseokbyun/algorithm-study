package algorithmStudy.programmers.DevTest2020;

import org.junit.Test;

public class test1 {
    public class Solution {
        public int solution(int N, int[] sequence) {
            int answer = 0;
            
            int now = 1;
            for (int next : sequence) {
                int distance = Math.abs(now - next);
                
                answer += distance < N-distance ? distance : N-distance;
                now = next;
            }
            
            return answer;
        }
    }
    
    
    @Test
    public void test() {
        int N = 5;
        int[] sequence = {3, 5, 4, 1, 2};
        
        Solution solution = new Solution();
        System.out.println(solution.solution(N, sequence));
        
        
    }
}

package algorithmStudy.programmers.DevTest2020;

import org.junit.Test;

public class test2 {
    class Solution {
        public int solution(int[] numbers, int K) {
            int answer = 0;
            return -1;
        }
        // 재귀함수를 이용해야하나? 이미 swap 된걸 다시 swap하게되면 어떡하나..
        private boolean switchable(int[] numbers, int K, int i, int j) {
            if (i>0 && Math.abs(numbers[i-1] - numbers[j]) > K) {
                return false;
            }
            if (i<numbers.length && Math.abs(numbers[i+1] - numbers[j]) > K) {
                return false;
            }
            
            if (j>0 && Math.abs(numbers[j-1] - numbers[i]) > K) {
                return false;
            }
            
            if (j<numbers.length && Math.abs(numbers[j+1] - numbers[i]) > K) {
                return false;
            }
            
            return true;
        }
    }
    
    
    
    
    @Test
    public void test() {
        int[] numbers = {3, 7, 2, 8, 6, 4, 5, 1};
        int K = 5;
        
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, K));
        
        
    }
}

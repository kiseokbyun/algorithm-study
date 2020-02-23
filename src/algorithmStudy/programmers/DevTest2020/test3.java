package algorithmStudy.programmers.DevTest2020;

import java.util.Arrays;

import org.junit.Test;

public class test3 {
    public class Solution {
        public int[] solution(int[] black_caps) {
            int n = black_caps.length;

            int[] answer = new int [n];
            for (int i=0; i<n; i++) {
                answer[i] = 0;
            }
            if (black_caps[0] == 1) {
                answer[1] = 1;
            } else {
                // black_caps[i] == 0
                answer[1] = 2;
            }
            
            if (black_caps[n-1] == 1) {
                answer[n-2] = 1;
            } else {
                // black_caps[i] == 0
                answer[n-2] = 2;
            }
            
            while (true) {
                int sum = Arrays.stream(answer).sum();
                for (int i=1; i<n-1; i++) {
                    if (black_caps[i] == 2) {
                        answer[i-1] = 1;
                        answer[i+1] = 1;
                    } else if (black_caps[i] == 1) {
                        if (answer[i-1] == 2) {
                            answer[i+1] = 1;
                        } else if (answer[i-1] == 1) {
                            answer[i+1] = 2;
                        } else {
                            // answer[i-1] == 0
                            if (answer[i+1] == 2) {
                                answer[i-1] = 1;
                            } else if (answer[i+1] == 1) {
                                answer[i-1] = 2;
                            } else {
                                // 둘다 0 알수없음.
                                continue;
                            }
                        }
                    } else {
                        // black_caps[i] == 0
                        answer[i-1] = 2;
                        answer[i+1] = 2;
                    }
                }
                
                // 변한게 없으면 종료.
                int tmp = Arrays.stream(answer).sum();
                if (sum == tmp) {
                    break;
                }
            }
            
            return answer;
        }
    }
    
    
    @Test
    public void test() {
        int[] black_caps = {1, 1, 2, 0};
        
        Solution solution = new Solution();
        System.out.println(solution.solution(black_caps));
        
        
    }
}

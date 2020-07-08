package algorithmStudy.programmers.fibonacci;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Fibonacci {
    private static int[] fibonacci = null;
    
    public Fibonacci() {
        if (fibonacci == null) {
            synchronized(this) {
                fibonacci = new int[100000];
                fibonacci[0] = 0;
                fibonacci[1] = 1;
                
                for (int i=2; i<fibonacci.length; i++) {
                    fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1234567;
                }
            }
        }
    }
    
    public int solution(int n) {
        return fibonacci[n];
    }
    
    @Test
    public void test() {
        int result = solution(5);
        assertThat(result, equalTo(5));
    }
}

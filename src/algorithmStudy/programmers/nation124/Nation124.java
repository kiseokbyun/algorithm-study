package algorithmStudy.programmers.nation124;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Nation124 {
    final static String ONE = "1";
    final static String TWO = "2";
    final static String FOUR = "4";
    
    public String solution(int n) {
        String result = "";
        
        while(n > 0) {
            int remainder = n%3;
            
            if (remainder == 1) {
                result = ONE + result;
                n = n/3;
            } else if (remainder == 2) {
                result = TWO + result;
                n = n/3;
            } else {
                result = FOUR + result;
                n = n/3-1;
            }
        }
        
        return result;
    }
    
    @Test
    public void test1() {
        String result = solution(1);
        assertThat(result, equalTo("1"));
    }
    
    @Test
    public void test2() {
        assertThat(solution(2), equalTo("2"));
    }
    
    @Test
    public void test3() {
        assertThat(solution(3), equalTo("4"));
    }
    
    @Test
    public void test4() {
        assertThat(solution(4), equalTo("11"));
    }
    
    @Test
    public void test5() {
        assertThat(solution(5), equalTo("12"));
    }
    
    @Test
    public void test6() {
        assertThat(solution(6), equalTo("14"));
    }
    
    @Test
    public void test7() {
        assertThat(solution(7), equalTo("21"));
    }
    
    @Test
    public void test8() {
        assertThat(solution(8), equalTo("22"));
    }
    
    @Test
    public void test9() {
        assertThat(solution(9), equalTo("24"));
    }
    
    @Test
    public void test10() {
        assertThat(solution(10), equalTo("41"));
    }
}

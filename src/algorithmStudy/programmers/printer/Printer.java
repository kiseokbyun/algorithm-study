package algorithmStudy.programmers.printer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class Printer {
    public int solution(int[] priorities, int location) {
        ArrayList<Integer>returnOrder = new ArrayList<Integer>();
        
        int size = 0;
        int maxIndex=0;
        int tmpIndex=0;
        while(true) {
            if (returnOrder.size() == priorities.length) {
                break;
            }
            
            if (size == priorities.length) {
                returnOrder.add(maxIndex);
                if (maxIndex == location) {
                    break;
                }
                priorities[maxIndex] = 0;
                tmpIndex = maxIndex+1;
                size = 0;
                continue;
            }
            
            if (tmpIndex >= priorities.length) {
                tmpIndex = 0;
            }
            
            if (priorities[maxIndex] < priorities[tmpIndex]) {
                maxIndex = tmpIndex;
            }
            size++;
            tmpIndex++;
        }
        
        return returnOrder.size();
    }
    
    @Test
    public void test1() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        
        int result = solution(priorities, location);
        
        assertThat(result, equalTo(1));
    }
    
    @Test
    public void test2() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        
        int result = solution(priorities, location);
        
        assertThat(result, equalTo(5));
    }
}

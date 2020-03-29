package algorithmStudy.binarySearch;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
       Arrays.sort(rocks);
       
       List<Integer> list = new ArrayList<Integer>();
       list.add(0, rocks[0]);
       for (int i=1; i<rocks.length; i++) {
           list.add(i, rocks[i]-rocks[i-1]);
       }
       list.add(rocks.length, distance-rocks[rocks.length-1]);
       
       
       int[] distances = new int [list.size()-n];
       for (int i=0; i<n; i++) {
       }
       
        return list.get(getSmallestDistance(list));
    }
    
    public int steppingStone(List<Integer> list, int[] arr) {
        list.get(0);
        
        
        return 0;
    }
    
    private int getSmallestDistance(List<Integer> list) {
        int index = 0;
        for (int i=1; i<list.size(); i++) {
            
            index = list.get(i) < list.get(index) ? i : index;
        }
        
        return index;
    }
    
    @Test
    public void test() {
        int distance = 15;
        int[] rocks = {1,3,6,10};
        int n = 2;
        
        int result = solution(distance, rocks, n);
        assertThat(result, equalTo(4));
    }
}

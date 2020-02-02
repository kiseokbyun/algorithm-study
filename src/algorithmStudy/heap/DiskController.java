package algorithmStudy.heap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] j1, int[] j2){
                if(j1[0]<j2[0]) return -1;
                else if(j1[0]==j2[0]){
                    if(j1[1]<j2[1]) return -1;
                }
                return 1;
            }
        });
        
        ArrayList<int[]> jobList = new ArrayList<int[]>();
        for (int[] job : jobs) {
            jobList.add(job);
        }
        
        int now = 0;
        int totalTime = 0;

        while (!jobList.isEmpty()) {
            int shortestJobIndex = 0;
            for (int i=0; i<jobList.size(); i++) {
                int [] job = jobList.get(i);
                if (job[0] <= now) {    // 실행 가능 작업
                    if (jobList.get(shortestJobIndex)[1] > job[1]) {    // 가장 빨리 끝나는 작업
                        shortestJobIndex = i;
                    }
                    continue;
                } else {
                    break;
                }
            }
            if (jobList.get(shortestJobIndex)[0] > now) {
                now = jobList.get(shortestJobIndex)[0];
            }
            
            now += jobList.get(shortestJobIndex)[1];
            totalTime += now - jobList.get(shortestJobIndex)[0];
            jobList.remove(shortestJobIndex);
        }
        
        return totalTime/jobs.length;
    }
    
    @Test
    public void test() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        
        int result = solution(jobs);
        assertThat(result, equalTo(9));
    }
}

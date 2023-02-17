package algorithmStudy.baekjoon.week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12018
public class BJ12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] minMileage = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int total = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            if (total < limit) {
                minMileage[i] = 1;
            } else {
                int[] personalMileage = new int[total];
                for (int j=0; j<total; j++) {
                    personalMileage[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(personalMileage);

                minMileage[i] = personalMileage[total-limit];
            }
        }
        Arrays.sort(minMileage);

        int count=0;
        for (int i=0; i<N; i++) {
            if (minMileage[i] <= M) {
                M -= minMileage[i];
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
        br.close();
    }
}
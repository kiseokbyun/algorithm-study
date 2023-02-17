package algorithmStudy.baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2138
public class BJ2138{
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();

        boolean []now1 = new boolean[N];
        boolean []now2 = new boolean[N];
        boolean []will = new boolean[N];
        for (int i=0; i<N; i++) {
            now1[i] = A.charAt(i) != '0';
            now2[i] = A.charAt(i) != '0';
            will[i] = B.charAt(i) != '0';
        }

        // 첫번째 스위치 off
        int count1 = count(0, now1, will);

        // 첫번째 스위치 on
        now2[0] = !now2[0];
        now2[1] = !now2[1];
        int count2 = count(1, now2, will);

        if (count1 == -1) {
            System.out.println(count2);
        } else if (count2 == -1) {
            System.out.println(count1);
        } else {
            System.out.println(Math.min(count1,count2));
        }

        br.close();
    }

    public static int count(int count, boolean[] now, boolean[]will) {
        for (int i=1; i<N-1; i++) {
            if (now[i-1] != will[i-1]) {
                now[i-1] = !now[i-1];
                now[i] = !now[i];
                now[i+1] = !now[i+1];
                count++;
            }
        }

        if (now[N-2] != will[N-2]) {
            now[N-2] = !now[N-2];
            now[N-1] = !now[N-1];
            count++;
        }

        if (now[N-1] == will[N-1]) {
            return count;
        } else {
            return -1;
        }
    }
}